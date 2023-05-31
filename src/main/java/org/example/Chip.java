package org.example;

public class Chip {
    private ChipType type;

    public Chip(ChipType type) {
        this.type = type;
    }

    // Getter and Setter
    public ChipType getType() {
        return type;
    }

    public void setType(ChipType type) {
        this.type = type;
    }

    // toString method
    @Override
    public String toString() {
        return type.toString() + " Chip";
    }
}
