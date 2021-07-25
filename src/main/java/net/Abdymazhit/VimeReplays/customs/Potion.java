package net.Abdymazhit.VimeReplays.customs;

public class Potion extends Item {

    private final boolean isSplash;

    public Potion(int data, boolean isSplash) {
        super(data);
        this.isSplash = isSplash;
    }

    public boolean isSplash() {
        return isSplash;
    }
}
