package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public class Subspace extends VolumeObject {
    private Coordinate coordinate;

    public Subspace(Coordinate coordinate,int length, int width, int height) {
        this.coordinate = coordinate;
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public Subspace(Container container) {
        this.coordinate = LocationFactory.createCoordinate(0,0,0);
        setLength(container.getLength());
        setWidth(container.getWidth());
        setHeight(container.getHeight());
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }



}
