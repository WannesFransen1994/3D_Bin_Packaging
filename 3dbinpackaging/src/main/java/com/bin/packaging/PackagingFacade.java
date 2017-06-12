/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import com.bin.packaging.Model.*;
import com.bin.packaging.Extra.*;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Wannes Fransen.
 */
public class PackagingFacade {
    final double SAFETY_MARGIN= 1.05;
    private BoxFitter fitter;
    private ContSetupCalculater contSetupCalculater;

    public PackagingFacade(FillBehaviour fillBehaviour, CalculateBehaviour calculateBehaviour) {
        fitter = new BoxFitter();
        fitter.setFillBehaviour(fillBehaviour);
        contSetupCalculater = new ContSetupCalculater(this);
        contSetupCalculater.setCalculateBehaviour(calculateBehaviour);
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

    public Map<Container,Integer> getTranslatedSetup(int length, int width, int height, int amount, int pockets){
        length = calculateLength(length);
        width = calculateWidth(width);
        height = calculateHeighth(height,pockets);
        amount = calculateAmount(amount);
        return TranslatorContainersetup.convertFromContainerSetup(calculateSetup(length, width, height, amount));
    }

    //TODO: clean up constructor box and work with 1 sample box.
    //TODO: Move this to the box constructor.
    public int calculateHeighth(int height,int pockets){
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

    public int calculateAmount(int amount){
        if (amount%2==1){
            return (amount+1)/2;
        }
        return amount/2;
    }
}
