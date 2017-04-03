package com.bin.packaging;

import java.util.Comparator;

/**
 * Created by erowan on 31/03/2017.
 */
public class Coordinate{
    //This coordinate defines the left upper corner of the basis of the box
    private int coordinate_x; // Length  is regarded as the X-axis
    private int coordinate_y; // Width is regarded as the Y-axis
    private int coordinate_z; // Height is regarded as the Z-axis

    public Coordinate(int coordinate_x, int coordinate_y, int coordinate_z) {
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.coordinate_z = coordinate_z;
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    public int getCoordinate_z() {
        return coordinate_z;
    }

    public void setCoordinate_z(int coordinate_z) {
        this.coordinate_z = coordinate_z;
    }
}
