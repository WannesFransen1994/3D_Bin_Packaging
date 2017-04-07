package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public class LocationFactory {
    public static Coordinate createCoordinate(int x, int y, int z){
        return new Coordinate(x,y,z);
    }
}
