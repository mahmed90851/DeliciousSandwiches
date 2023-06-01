package org.example;

public enum SandwichSize {
    FOUR_INCH(4),
    EIGHT_INCH(8),
    TWELVE_INCH(12);

    private final int size;

    SandwichSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
