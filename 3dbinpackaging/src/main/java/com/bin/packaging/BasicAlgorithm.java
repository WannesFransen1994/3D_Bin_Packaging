/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

/**
 * @author erowan
 */
public class BasicAlgorithm implements FillBehaviour{
    private Coordinate place = new Coordinate(0,0,0);

    @Override
    public Container fillContainer(Container container, Box box, int amount) {
        int counter = 1;
        Box lowestBoxSetup = tempDeepCloneBox(box);
        int lowest;
        lowest = moduloCalculateLostSpace(container,box);
        turnBox(counter,box);
        counter ++;
        if (moduloCalculateLostSpace(container,box)<lowest){
            lowest=moduloCalculateLostSpace(container,box);
            lowestBoxSetup = tempDeepCloneBox(box);
        }
        turnBox(counter,box);
        counter ++;
        if (moduloCalculateLostSpace(container,box)<lowest){
            lowest=moduloCalculateLostSpace(container,box);
            lowestBoxSetup = tempDeepCloneBox(box);
        }
        turnBox(counter,box);
        counter ++;
        if (moduloCalculateLostSpace(container,box)<lowest){
            lowest=moduloCalculateLostSpace(container,box);
            lowestBoxSetup = tempDeepCloneBox(box);
        }
        turnBox(counter,box);
        counter ++;
        if (moduloCalculateLostSpace(container,box)<lowest){
            lowest=moduloCalculateLostSpace(container,box);
            lowestBoxSetup = tempDeepCloneBox(box);
        }
        turnBox(counter,box);
        counter ++;
        if (moduloCalculateLostSpace(container,box)<lowest){
            lowest=moduloCalculateLostSpace(container,box);
            lowestBoxSetup = tempDeepCloneBox(box);
        }
        //TODO: Clean this horror up...
        container = placeBoxes(container,lowestBoxSetup,amount);
        return container;
    }

    private Container placeBoxes(Container container,Box box, int limit){
        int templength=0,tempwidth=0,tempheight=0,counter=0;
        for (int l = 0;l<container.getLength()/box.getLength();l++){
            for (int w = 0;w<container.getWidth()/box.getWidth();w++){
                for (int h = 0;h<container.getHeight()/box.getHeight();h++){
                    if (templength<container.getLength() && tempwidth<container.getWidth() && tempheight<container.getHeight() && counter<limit){
                        container.addItem(new Coordinate(templength,tempwidth,tempheight),tempDeepCloneBox(box));
                        counter ++;
                    }
                    tempheight = place.getCoordinate_z() + box.getHeight();
                }
                tempheight = 0;
                tempwidth = place.getCoordinate_y() + box.getWidth();
            }
            tempwidth = 0;
            templength = place.getCoordinate_x() + box.getLength();
        }
        return container;
    }

    private int moduloCalculateLostSpace(Container container, Box box){
        int lostHeight = 1, lostWidth = 1 ,lostLength = 1;
        if (container.getHeight()%box.height!=0){lostHeight = container.getHeight()%box.height;}
        if (container.getWidth()%box.width!=0){lostWidth  = container.getWidth()%box.width;}
        if (container.getLength()%box.length!=0){lostLength = container.getLength()%box.length;}

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

    private Box tempDeepCloneBox(Box box){
        return new Box(box.getLength(),box.getWidth(),box.getHeight());
    }

    private Coordinate tempDeepCloneCoordinate(Coordinate coordinate){
        return new Coordinate(coordinate.getCoordinate_x(),coordinate.getCoordinate_y(),coordinate.getCoordinate_z());
    }
}
