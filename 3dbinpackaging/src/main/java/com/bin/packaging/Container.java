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
public class Container {
    private int length;
    private int width;
    private int height;
    private float filled;
    private Map<Coordinate,Box> items;

    public Container(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
        this.items = new HashMap<>();
    }
    
    private void setLength(int length) {
    	if (length <= 0) throw new IllegalArgumentException("Length should be bigger than 0");
    	this.length = length;
    }
    
    private void setHeight(int height) {
    	if (height <= 0) throw new IllegalArgumentException("Height should be bigger than 0");
    	this.height = height;
    }
    
    private void setWidth(int width) {
    	if (width <= 0) throw new IllegalArgumentException("Width should be bigger than 0");
    	this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getFilled() {
        return filled;
    }

    public void setFilled(float filled) {
        this.filled = filled;
    }

    public Map<Coordinate,Box> getItems() {
        return items;
    }

    public void addItem(Coordinate coordinate,Box box) {
        this.items.put(coordinate,box);
    }
    
    public void removeItem(Box box) {
        this.items.remove(box);
    }
}