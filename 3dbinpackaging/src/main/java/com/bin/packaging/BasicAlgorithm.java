/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

/**
 * @author erowan
 */
public class BasicAlgorithm extends AlgorithmCommonMethods{

    @Override
    public Container fillContainer(Container container, Box box, int amount) {
        int counter = 1,lowest;
        Box lowestBoxSetup = VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight());
        lowest = moduloCalculateLostSpace(container,box);
        while (counter<=6){
            turnBox(counter,box);
            counter ++;
            if (moduloCalculateLostSpace(container,box)<lowest){
                lowest=moduloCalculateLostSpace(container,box);
                lowestBoxSetup = VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight());
            }
        }
        container = placeBoxes(container,lowestBoxSetup,amount);
        return container;
    }

    private Container placeBoxes(Container container,Box box, int limit){
        int templength=0,tempwidth=0,tempheight=0,counter=0;
        for (int l = 0; l < container.getLength() / box.getLength(); l++){
            for (int w = 0; w < container.getWidth() / box.getWidth(); w++){
                for (int h = 0; h < container.getHeight() / box.getHeight(); h++){
                    if (templength<container.getLength() && tempwidth<container.getWidth() && tempheight<container.getHeight() && counter<limit){
                        container.addItem(LocationFactory.createCoordinate(templength,tempwidth,tempheight), VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight()));
                        counter ++;
                    }
                    tempheight = box.getHeight();
                }
                tempheight = 0;
                tempwidth = box.getWidth();
            }
            tempwidth = 0;
            templength = box.getLength();
        }
        return container;
    }
}
