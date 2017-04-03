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
public class BoxFitter {
    //This class will fit the maximum amount of boxes in the container
    private FillBehaviour fillBehaviour;
    private VolumeObjectFactory factory = new VolumeObjectFactory();

    public List<Container> fillContainersMax(int height, int width, int length, int amount) {
        Box samplebox = factory.createBox(length,width,height);
        List<Container> filledContainers = new ArrayList<>();
        for (ContainerType containerType : ContainerType.values()) {
            Container filledContainer = fillBehaviour.fillContainer(factory.createContainer(containerType),samplebox,amount);
            filledContainers.add(filledContainer);
        }
        return filledContainers;
    }

    public Container fillContainer(ContainerType containerType, int length,int width,int height,int amount) {
        return fillBehaviour.fillContainer(factory.createContainer(containerType),factory.createBox(length, width, height),amount);
    }

    public void setFillBehaviour(FillBehaviour algo){
        fillBehaviour = algo;
    }
}
