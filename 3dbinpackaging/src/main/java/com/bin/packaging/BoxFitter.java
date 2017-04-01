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
    //TODO Factorize a lot in this class (box and container)
    //TODO Use enum for container options or load from file?
    private List<Container> availableContainers;
    private FillBehaviour fillBehaviour;

    public BoxFitter() {
        this.availableContainers = new ArrayList<>();
    }

    public void calculateFitBoxInContainer(){
        fillBehaviour = new BasicAlgorithm();
        setupContainers();
    }
    public void calculateFitBoxInContainer(FillBehaviour algo){
        fillBehaviour = fillBehaviour;
        setupContainers();
    }
    private void setupContainers(){
        this.availableContainers.add(VolumeObjectFactory.createContainer(120,80,100));
        this.availableContainers.add(VolumeObjectFactory.createContainer(150,100,120));
        this.availableContainers.add(VolumeObjectFactory.createContainer(210,200,150));
        System.out.println("Added sample containers");
    }

    public List<Container> fillContainersMax(int height, int width, int length, int amount) {
        Box samplebox = new Box(length,width,height);
        List<Container> filledContainers = new ArrayList<>();
        for (Container c : availableContainers) {
            filledContainers.add(fillBehaviour.fillContainer(c,samplebox,amount));
        }
        return filledContainers;
    }
    public List<Container> getSampleData() {
        setupContainers();
        Box samplebox = new Box(70,100,50);
        List<Container> filledContainers = new ArrayList<>();
        filledContainers.add(availableContainers.get(2));
        filledContainers.add(availableContainers.get(2));
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

}
