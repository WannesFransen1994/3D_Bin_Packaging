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


    public void calculateFitBoxInContainer(){
        fillBehaviour = new BasicAlgorithm();
        setupContainers();
    }
    public void calculateFitBoxInContainer(FillBehaviour algo){
        fillBehaviour = fillBehaviour;
        setupContainers();
    }
    private void setupContainers(){
        this.availableContainers.add(new Container(120,80,100));
        this.availableContainers.add(new Container(150,100,120));
    }

    public List<Container> fillContainersMax(int height, int width, int length, int amount) {
        Box samplebox = new Box(length,width,height);
        List<Container> filledContainers = new ArrayList<>();
        for (Container c : availableContainers) {
            filledContainers.add(fillBehaviour.fillContainer(c,samplebox,amount));
        }
        return filledContainers;
    }
}
