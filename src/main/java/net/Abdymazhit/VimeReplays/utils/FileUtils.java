package net.Abdymazhit.VimeReplays.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.unsafe.UnsafeInput;
import com.esotericsoftware.kryo.unsafe.UnsafeOutput;
import com.github.luben.zstd.Zstd;
import net.Abdymazhit.VimeReplays.replay.Replay;
import net.Abdymazhit.VimeReplays.replay.ReplaySerializer;
import net.Abdymazhit.VimeReplays.replay.data.MovingData;
import net.Abdymazhit.VimeReplays.replay.data.SneakingData;
import net.Abdymazhit.VimeReplays.replay.data.UnsneakingData;
import org.bukkit.Bukkit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public void saveFile(Replay replay) {
        serialize(replay);
        compress();
        upload();
    }

    public Replay readFile() {
        download();
        decompress();
        return deserialize();
    }

    private void serialize(Replay replay) {
        try {
            Kryo kryo = new Kryo();

            ReplaySerializer replaySerializer = new ReplaySerializer();

            kryo.register(Replay.class, replaySerializer);
            kryo.register(MovingData.class);
            kryo.register(SneakingData.class);
            kryo.register(UnsneakingData.class);

            RandomAccessFile raf = new RandomAccessFile(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.replay", "rw");
            Output output = new Output(new FileOutputStream(raf.getFD()));
            UnsafeOutput unsafeOutput = new UnsafeOutput(output);
            replaySerializer.write(kryo, unsafeOutput, replay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void compress() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.replay"));
            byte[] compressed = Zstd.compress(data);

            RandomAccessFile raf = new RandomAccessFile(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game_" + data.length + ".rep", "rw");
            FileOutputStream fileOutputStream = new FileOutputStream(raf.getFD());
            fileOutputStream.write(compressed);
            fileOutputStream.close();

            File file = new File(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.replay");
            if(file.delete()) {
                System.out.println("Файл replay был удален");
            }
            else {
                System.out.println("Файл replay не найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload() {

    }

    public void download() {

    }

    private void decompress() {
        try {
            String path = null;

            File root = new File(Bukkit.getWorldContainer() + "/plugins/VimeReplays/");
            FilenameFilter beginsWith = (directory, filename) -> filename.startsWith("game_");
            File[] files = root.listFiles(beginsWith);
            if(files != null) {
                for (File f: files) {
                    path = f.getPath();
                }
            }

            if(path != null) {
                String size = path.split("_")[1].replace(".rep", "");

                byte[] compressed = Files.readAllBytes(Paths.get(path));
                byte[] decompressed = Zstd.decompress(compressed, Integer.parseInt(size));

                File file = new File(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.rep");
                if(file.delete()) {
                    System.out.println("Файл rep был удален");
                }
                else {
                    System.out.println("Файл rep не найден");
                }

                RandomAccessFile raf = new RandomAccessFile(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.replay", "rw");
                FileOutputStream fileOutputStream = new FileOutputStream(raf.getFD());
                fileOutputStream.write(decompressed);
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Replay deserialize() {
        try {
            Kryo kryo = new Kryo();

            ReplaySerializer replaySerializer = new ReplaySerializer();

            kryo.register(Replay.class, replaySerializer);
            kryo.register(MovingData.class);
            kryo.register(SneakingData.class);
            kryo.register(UnsneakingData.class);

            RandomAccessFile raf = new RandomAccessFile(Bukkit.getWorldContainer() + "/plugins/VimeReplays/game.replay", "rw");
            Input input = new Input(new FileInputStream(raf.getFD()));
            UnsafeInput unsafeInput = new UnsafeInput(input);

            return replaySerializer.read(kryo, unsafeInput, Replay.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
