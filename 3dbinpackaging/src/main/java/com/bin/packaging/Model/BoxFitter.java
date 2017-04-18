/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Wannes Fransen.
 */
public class BoxFitter {
    //This class will fit the maximum amount of boxes in the container
    private FillBehaviour fillBehaviour;

    public List<Container> fillContainersMax(int height, int width, int length, int amount) {
        Box samplebox = VolumeObjectFactory.createBox(length,width,height);
        List<Container> filledContainers = new ArrayList<>();
        for (ContainerType containerType : ContainerType.values()) {
            Container filledContainer = fillBehaviour.fillContainer(VolumeObjectFactory.createContainer(containerType),samplebox,amount);
            filledContainers.add(filledContainer);
        }
        return filledContainers;
    }

    public Container fillContainer(ContainerType containerType, int length,int width,int height,int amount) {
        return fillBehaviour.fillContainer(VolumeObjectFactory.createContainer(containerType),VolumeObjectFactory.createBox(length, width, height),amount);
    }

    public void setFillBehaviour(FillBehaviour algo){
        fillBehaviour = algo;
    }
}
