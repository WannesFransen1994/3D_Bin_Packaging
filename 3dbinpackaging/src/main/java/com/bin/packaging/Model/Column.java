/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public class Column extends VolumeObject {
    final double SAFETY_MARGIN= 1.05;
    public Column(int length, int width, int height, int pockets) {
        setLength(calculateLength(length));
        setWidth(calculateWidth(width));
        setHeight(calculateHeight(height,pockets));
    }

    public Column(Column column) {
        setLength(column.getLength());
        setWidth(column.getWidth());
        setHeight(column.getHeight());
    }

    // Width becomes height, height becomes width
    public void turnZaxis() {
        int tmp = getWidth();
        setWidth(getLength());
        setLength(tmp);
    }

    // Length becomes height, height becomes length
    public void turnYaxis() {
        int tmp = getHeight();
        setHeight(getLength());
        setLength(tmp);
    }

    // Width becomes height, height becomes width
    public void turnXaxis() {
        int tmp = getHeight();
        setHeight(getWidth());
        setWidth(tmp);
    }



    public int calculateHeight(int height, int pockets){
        double temp = ((height*0.05) + ((pockets +1)*0.6))*2 + 5;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }

    public int calculateLength(int length){
        double temp = length*1.10;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }

    public int calculateWidth(int width){
        double temp = width*1.15;
        return (int)Math.ceil(temp*SAFETY_MARGIN);
    }
}
