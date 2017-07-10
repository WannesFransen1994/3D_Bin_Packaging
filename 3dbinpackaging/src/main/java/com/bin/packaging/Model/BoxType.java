package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public enum BoxType {
    BOX1(120,80,100),
    BOX2(150,100,120);

    private int length;
    private int width;
    private int height;

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

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
