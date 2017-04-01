package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public abstract class VolumeObject {
    protected int length;
    protected int width;
    protected int height;

    protected void setLength(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length should be bigger than 0");
        this.length = length;
    }

    protected void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Height should be bigger than 0");
        this.height = height;
    }

    protected void setWidth(int width) {
        if (width <= 0) throw new IllegalArgumentException("Width should be bigger than 0");
        this.width = width;
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
    public int getVolume() {
        return getHeight() * getWidth() * getLength();
    }
}
