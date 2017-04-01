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
public class BasicAlgorithm implements FillBehaviour{
    private int counter = 1;
    private Coordinate place = new Coordinate(0,0,0);

    @Override
    public Container fillContainer(Container container, Box box, int amount) {
        int counter = 1;
        List<Integer> options = new ArrayList<>();
        options.add(moduloCalculateLostSpace(container,box));
        turnBox(counter,box);
        counter ++;
        options.add(moduloCalculateLostSpace(container,box));
        options.add(moduloCalculateLostSpace(container,box));
        options.add(moduloCalculateLostSpace(container,box));
        options.add(moduloCalculateLostSpace(container,box));
        options.add(moduloCalculateLostSpace(container,box));
        //TODO: Clean this up...
        //TODO: rest of algorithm, select lowest, allocate quick & dirty
        return container;
    }

    private int moduloCalculateLostSpace(Container container, Box box){
        int lostHeight = container.getHeight()%box.height;
        int lostWidth  = container.getWidth()%box.width;
        int lostLength = container.getLength()%box.length;

        return lostHeight*lostLength*lostWidth;
    }

    private Box turnBox(int counter, Box box){
        if (counter % 2 == 0) {
            box.turnZaxis();
        }else {
            box.turnXaxis();
        }
        return box;
    }
}
