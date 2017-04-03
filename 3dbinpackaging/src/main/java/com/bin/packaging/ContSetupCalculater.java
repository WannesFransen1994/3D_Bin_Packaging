package com.bin.packaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class ContSetupCalculater {
    private CalculateBehaviour calculateBehaviour;
    private PackagingFacade facade;

    public ContSetupCalculater(PackagingFacade facade) {
        this.facade = facade;
    }

    public void setCalculateBehaviour(CalculateBehaviour calculateBehaviour) {
        this.calculateBehaviour = calculateBehaviour;
    }

    public ContainerSetup calculateSetup(int length, int width, int height, int amount) {
        return calculateBehaviour.calculateSetup(this,length,width,height,amount);
    }

    protected Container getLoadedContainer(ContainerType type,int length, int width, int height, int amount){
        return facade.getSpecificLoadedContainer(type, length, width, height, amount);
    }
}
