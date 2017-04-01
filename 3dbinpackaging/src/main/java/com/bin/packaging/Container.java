/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author erowan
 */
public class Container extends VolumeObject{
    private Map<Coordinate,Box> items;

    public Container(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }

    public float getFilled() {
        Box temp = (Box)items.values().toArray()[0];
        float volume = temp.getVolume();
        int size = (items.size()-2)/2;
        float objectsVolume =volume*size;
        return objectsVolume/getVolume();
    }

    public Map<Coordinate,Box> getItems() {
        return items;
    }

    public void addItem(Coordinate coordinate,Box box) {
        this.items.put(coordinate,box);
    }
    
    public void removeItem(Coordinate coordinate) {
        this.items.remove(coordinate);
    }
}
