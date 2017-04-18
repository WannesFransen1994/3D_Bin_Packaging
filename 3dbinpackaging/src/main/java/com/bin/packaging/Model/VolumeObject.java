package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public abstract class VolumeObject {
    int length;
    int width;
    int height;

    void setLength(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length should be bigger than 0");
        this.length = length;
    }

    void setHeight(int height) {
        if (height <= 0) throw new IllegalArgumentException("Height should be bigger than 0");
        this.height = height;
    }

    void setWidth(int width) {
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
