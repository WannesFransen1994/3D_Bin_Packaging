package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public enum BoxType {
    SMALLEST(120,80,100),
    BIGGEST(150,100,120);

    private final int length;
    private final int width;
    private final int height;

    BoxType(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
