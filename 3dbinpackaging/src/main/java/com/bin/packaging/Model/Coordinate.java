package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public class Coordinate{
    //This coordinate defines the left upper corner of the basis of the box
    private int coordinate_x; // Length  is regarded as the X-axis
    private int coordinate_y; // Width is regarded as the Y-axis
    private int coordinate_z; // Height is regarded as the Z-axis

    public Coordinate(int coordinate_x, int coordinate_y, int coordinate_z) {
        setCoordinate_x(coordinate_x);
        setCoordinate_y(coordinate_y);
        setCoordinate_z(coordinate_z);
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
