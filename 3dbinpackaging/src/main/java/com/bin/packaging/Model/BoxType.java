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
        if (length<=0) length=1;
        this.length = length;
    }

    public void setWidth(int width) {
        if (width<=0) width=1;
        this.width = width;
    }

    public void setHeight(int height) {
        if (height<=0) height=1;
        this.height = height;
    }
}
