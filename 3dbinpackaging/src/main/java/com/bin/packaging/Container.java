/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author erowan
 */
public class Container extends VolumeObject {
    private Map<Coordinate,Box> items;

    public Container(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }

    public Container(Container container) {
        setLength(container.getLength());
        setWidth(container.getWidth());
        setHeight(container.getHeight());
        this.items = container.getItems();
    }

    public float getFilled() {
        if (items.size()>0) {
            Box temp = (Box) items.values().toArray()[0];
            float volume = temp.getVolume();
            float objectsVolume = volume * getAmountOfItems();
            return objectsVolume / getVolume();
        }
        return 0;
    }

    public Map<Coordinate,Box> getItems() {
        return items;
    }

    public int getAmountOfItems(){
        return items.size();
    }

    public void addItem(Coordinate coordinate,Box box) {
        this.items.put(coordinate,box);
        //TODO: Sanity check
    }
    
    public void removeItem(Coordinate coordinate) {
        this.items.remove(coordinate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Container) {
            if (this.getLength() != ((Container) obj).getLength()){return false;}
            if (this.getWidth() != ((Container) obj).getWidth()){return false;}
            if (this.getHeight() != ((Container) obj).getHeight()){return false;}
            if (this.getAmountOfItems() != ((Container) obj).getAmountOfItems()){return false;}
        }else {return false;}
        return true;
    }
}
