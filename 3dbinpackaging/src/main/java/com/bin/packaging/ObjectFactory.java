package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public class ObjectFactory {
    public Box createBox(int length,int width, int height){
        return new Box(length, width, height);
    }
    public Container createContainer(ContainerType type){
        return new Container(type.getLength(), type.getWidth(), type.getHeight());
    }
    public Coordinate createCoordinate(int x, int y, int z){
        return new Coordinate(x,y,z);
    }
}
