package net.Abdymazhit.VimeReplays.replay.data;

import java.io.Serializable;

public class BlockBreakData extends RecordingData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final byte blockId;
    private final short x;
    private final short y;
    private final short z;

    public BlockBreakData(byte blockId, short x, short y, short z) {
        this.blockId = blockId;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public byte getBlockId() {
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
}