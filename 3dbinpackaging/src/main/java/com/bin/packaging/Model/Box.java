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
 *
 * Created by Wannes Fransen.
 */
public class Box extends VolumeObject {
    private final Map<Coordinate,Column> items;
    private static FillBehaviour fillBehaviour;

    public Box(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }

    public Box(Box container) {
        setLength(container.getLength());
        setWidth(container.getWidth());
        setHeight(container.getHeight());
        this.items = container.getItems();
    }

    public static Box fillContainer(BoxType containerType, Column c, int amount) {
        return fillBehaviour.fillContainer(VolumeObjectFactory.createContainer(containerType),c,amount);
    }

    public static void setFillBehaviour(FillBehaviour algo){
        fillBehaviour = algo;
    }

    public float getFilled() {
        if (items.size()>0) {
            Column temp = (Column) items.values().toArray()[0];
            float volume = temp.getVolume();
            float objectsVolume = volume * getAmountOfItems();
            return objectsVolume / getVolume();
        }
        return 0;
    }

    public Map<Coordinate,Column> getItems() {
        return items;
    }

    public int getAmountOfItems(){
        return items.size();
    }

    public void addItem(Coordinate coordinate,Column box) {
        this.items.put(coordinate,box);
        //TODO: Sanity check
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            if (this.getLength() != ((Box) obj).getLength()){return false;}
            if (this.getWidth() != ((Box) obj).getWidth()){return false;}
            if (this.getHeight() != ((Box) obj).getHeight()){return false;}
            if (this.getAmountOfItems() != ((Box) obj).getAmountOfItems()){return false;}
        }else {return false;}
        return true;
    }
}
