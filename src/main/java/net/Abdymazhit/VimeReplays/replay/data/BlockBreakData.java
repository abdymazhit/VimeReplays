package net.Abdymazhit.VimeReplays.replay.data;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import net.Abdymazhit.VimeReplays.VimeReplays;

import java.io.Serializable;

public class BlockBreakData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final short blockId;
    private final short x;
    private final short y;
    private final short z;

    public BlockBreakData(byte blockId, short x, short y, short z) {
        this.blockId = blockId;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BlockBreakData(Input input) {
        blockId = input.readShort();
        x = input.readShort();
        y = input.readShort();
        z = input.readShort();
    }

    public short getBlockId() {
        return blockId;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public short getZ() {
        return z;
    }

    public void write(Output output) {
        output.writeByte(VimeReplays.getSerializationUtils().getId(BlockBreakData.class));
        output.writeShort(blockId);
        output.writeShort(x);
        output.writeShort(y);
        output.writeShort(z);
    }
}
