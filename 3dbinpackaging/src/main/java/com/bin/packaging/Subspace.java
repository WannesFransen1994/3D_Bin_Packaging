package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public class Subspace extends VolumeObject {
    private Coordinate coordinate;

    public Subspace(Coordinate coordinate,int length, int width, int height) {
        this.coordinate = coordinate;
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public Subspace(Container container) {
        this.coordinate = LocationFactory.createCoordinate(0,0,0);
        this.setHeight(container.getHeight());
        this.setLength(container.getLength());
        this.setWidth(container.getWidth());
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
