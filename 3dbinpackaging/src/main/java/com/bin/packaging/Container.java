/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erowan
 */
public class Container {
    private int length;
    private int width;
    private int height;
    private float filled;
    private List<Box> items;

    public Container(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.items = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getFilled() {
        return filled;
    }

    public void setFilled(float filled) {
        this.filled = filled;
    }

    public List<Box> getItems() {
        return items;
    }

    public void addItem(Box box) {
        this.items.add(box);
    }
    
    public void removeItem(Box box) {
        this.items.remove(box);
    }
    
    
}
