package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public class VolumeObjectFactory {

    public static Subspace createSubspace(Coordinate coordinate, int length, int width, int height) {
        return new Subspace(coordinate, length, width, height);
    }

    public static Subspace createSubspace(Box box) {
        return new Subspace(box);
    }

    public static Column createColumn(int length, int width, int height, int pockets) {
        return new Column(length, width, height, pockets);
    }

    public static Column copyColumn(Column column) {
        return new Column(column);
    }

    public static Box createBox(BoxType type) {
        return new Box(type.getLength(), type.getWidth(), type.getHeight());
    }

    public static Box copyBox(Box box) {
        return new Box(box);
    }
    public static Box copyBoxAmountItems(Box box, int amount) {
        return new Box(box,amount);
    }
}
