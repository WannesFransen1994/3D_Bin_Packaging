package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public class VolumeObjectFactory {
    public Box createBox(int length,int width, int height){
        return new Box(length, width, height);
    }
    public Container createContainer(ContainerType type){
        return new Container(type.getLength(), type.getWidth(), type.getHeight());
    }
}
