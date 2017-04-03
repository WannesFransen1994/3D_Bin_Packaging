package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public class LocationFactory {
    public static Subspace createSubspace(Coordinate coordinate,int length, int width, int height){
        return new Subspace(coordinate,length,width,height);
    }
}
