package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public class VolumeObjectFactory {

    public static Subspace createSubspace(Coordinate coordinate, int length, int width, int height) {
        return new Subspace(coordinate, length, width, height);
    }

    public static Subspace createSubspace(Box container) {
        return new Subspace(container);
    }

    public static Column createColumn(int length, int width, int height, int pockets) {
        return new Column(length, width, height, pockets);
    }

    public static Column createColumn(Column column) {
        return new Column(column);
    }

    public static Box createContainer(BoxType type) {
        return new Box(type.getLength(), type.getWidth(), type.getHeight());
    }

    public static Box createContainer(Box container) {
        return new Box(container);
    }
}
