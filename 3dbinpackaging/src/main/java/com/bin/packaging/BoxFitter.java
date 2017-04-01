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

    public List<Container> getSampleData() {
        Box samplebox = factory.createBox(70,100,50);
        List<Container> filledContainers = new ArrayList<>();
        filledContainers.add(factory.createContainer(ContainerType.SAMPLE_CONTAINER));
        filledContainers.add(factory.createContainer(ContainerType.SAMPLE_CONTAINER));
        filledContainers.get(0).addItem(new Coordinate(70, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(140, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(70, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(140, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(70, 100, 50),samplebox);
        samplebox.turnXaxis();
        filledContainers.get(0).addItem(new Coordinate(140, 100, 70),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 100, 70),samplebox);
        filledContainers.get(1).addItem(new Coordinate(70, 100, 0),samplebox);
        return filledContainers;
    }

    public void setFillBehaviour(FillBehaviour algo){
        fillBehaviour = fillBehaviour;
    }
}
