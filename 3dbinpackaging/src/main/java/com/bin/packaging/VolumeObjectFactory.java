package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public class VolumeObjectFactory {
    public static Box createBox(int length,int width, int height){
        return new Box(length, width, height);
    }
    public static Container createContainer(int length,int width, int height){
        return new Container(length, width, height);
    }
}
