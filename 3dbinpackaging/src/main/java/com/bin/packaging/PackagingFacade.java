/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import com.bin.packaging.Model.*;

import java.util.List;

/**
 *
 * Created by Wannes Fransen.
 */
public class PackagingFacade {
    private BoxFitter fitter;
    private ContSetupCalculater contSetupCalculater;

    public PackagingFacade(FillBehaviour fillBehaviour, CalculateBehaviour calculateBehaviour) {
        fitter = new BoxFitter();
        fitter.setFillBehaviour(fillBehaviour);
        contSetupCalculater = new ContSetupCalculater(this);
        contSetupCalculater.setCalculateBehaviour(calculateBehaviour);
    }

    public List<Container> getMaxLoadedContainers(int length, int width, int height) {
        return fitter.fillContainersMax(height,width,length,-1);
    }

    public List<Container> getMaxLoadedContainers(int length,int width,int height,int amount) {
        return fitter.fillContainersMax(height,width,length,amount);
    }

    public Container getSpecificLoadedContainer(ContainerType containerType,int length,int width,int height,int amount) {
        return fitter.fillContainer(containerType,length,width,height,amount);
    }

    public ContainerSetup calculateSetup(int length, int width, int height, int amount){
        return contSetupCalculater.calculateSetup(length, width, height, amount);
    }
}
