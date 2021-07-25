package net.Abdymazhit.VimeReplays.customs;

public class PotionItem extends Item {

    private final boolean isSplash;

    public PotionItem(int data, boolean isSplash) {
        super(data);
        this.isSplash = isSplash;
    }

    public boolean isSplash() {
        return isSplash;
    }
}
