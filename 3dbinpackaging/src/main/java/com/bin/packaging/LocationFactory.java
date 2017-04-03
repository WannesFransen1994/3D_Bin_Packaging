package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public class LocationFactory {
    public static Coordinate createCoordinate(int x, int y, int z){
        return new Coordinate(x,y,z);
    }
}
