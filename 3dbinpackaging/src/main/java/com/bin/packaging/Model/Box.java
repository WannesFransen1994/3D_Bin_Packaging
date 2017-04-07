/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging.Model;

/**
 *
 * Created by Wannes Fransen.
 */
public class Box extends VolumeObject{

    public Box(int length, int width, int height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }
    // Width becomes height, height becomes width
    public void turnZaxis(){
        int tmp = getWidth();
        setWidth(getLength());
        setLength(tmp);
    }

    // Length becomes height, height becomes length
    public void turnYaxis(){
        int tmp = getHeight();
        setHeight(getLength());
        setLength(tmp);
    }

    // Width becomes height, height becomes width
    public void turnXaxis(){
        int tmp = getHeight();
        setHeight(getWidth());
        setWidth(tmp);
    }
}
