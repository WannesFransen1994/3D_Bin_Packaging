/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class Box extends VolumeObject {
    private final Map<Coordinate, Column> items;
    private static FillBehaviour fillBehaviour;

    public Box(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }

    public Box(Box box) {
        setLength(box.getLength());
        setWidth(box.getWidth());
        setHeight(box.getHeight());
        this.items = box.getItems();
    }

    public Box(Box box, int amount) {
        setLength(box.getLength());
        setWidth(box.getWidth());
        setHeight(box.getHeight());
        int i = amount;
        this.items = new HashMap<>();
        for (Coordinate c : box.getItems().keySet()) {
            if (i > 0) {
                this.items.put(c, box.getItems().get(c));
                i--;
            }
        }
    }

    public static Box fillBox(BoxType boxType, Column c, int amount) {
        Box empty = VolumeObjectFactory.createBox(boxType);
        if (empty.getHeight() < c.getHeight() || empty.getWidth() < c.getWidth() || empty.getLength() < c.getLength()) {
            return null;
        }
        return fillBehaviour.fillContainer(empty, c, amount);
    }

    public static List<Box> getAllTypeFilledBoxes(int length, int width, int height, int amount, int pockets) {
        Column c = VolumeObjectFactory.createColumn(length, width, height, pockets);
        List<Box> listBoxTypes = new ArrayList<>();
        for (BoxType boxType : BoxType.values()) {
            Box b = fillBox(boxType, c, OnlyTwoTypes.calculateAmount(amount));
            if (b !=null) listBoxTypes.add(b);
        }
        return listBoxTypes;
    }

    public static void setFillBehaviour(FillBehaviour algo) {
        fillBehaviour = algo;
    }

    public float getFilled() {
        if (items.size() > 0) {
            Column temp = (Column) items.values().toArray()[0];
            float volume = temp.getVolume();
            float objectsVolume = volume * getAmountOfItems();
            return objectsVolume / getVolume();
        }
        return 0;
    }

    public Map<Coordinate, Column> getItems() {
        return items;
    }

    public int getAmountOfItems() {
        return items.size();
    }

    public void addItem(Coordinate coordinate, Column column) {
        this.items.put(coordinate, column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            if (this.getLength() != ((Box) obj).getLength()) {
                return false;
            }
            if (this.getWidth() != ((Box) obj).getWidth()) {
                return false;
            }
            if (this.getHeight() != ((Box) obj).getHeight()) {
                return false;
            }
            if (this.getAmountOfItems() != ((Box) obj).getAmountOfItems()) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
