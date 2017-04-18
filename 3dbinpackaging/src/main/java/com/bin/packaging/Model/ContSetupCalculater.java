package com.bin.packaging.Model;

import com.bin.packaging.PackagingFacade;

/**
 * Created by Wannes Fransen.
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

    Container getLoadedContainer(ContainerType type, int length, int width, int height, int amount){
        return facade.getSpecificLoadedContainer(type, length, width, height, amount);
    }
}
