package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public class VolumeObjectFactory {

    public static Subspace createSubspace(Coordinate coordinate,int length, int width, int height){
        return new Subspace(coordinate,length,width,height);
    }
    public static Subspace createSubspace(Container container){
        return new Subspace(container);
    }
    public static Box createBox(int length,int width, int height){
        return new Box(length, width, height);
    }
    public static Container createContainer(ContainerType type){
        return new Container(type.getLength(), type.getWidth(), type.getHeight());
    }
    public static Container createContainer(Container container){
        return new Container(container);
    }
}
