package com.bin.packaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class ContSetupCalculater {
    private CalculateBehaviour calculateBehaviour;
    private BoxFitter fitter;

    public ContSetupCalculater(BoxFitter fitter) {
        this.fitter = fitter;
    }

    public void setCalculateBehaviour(CalculateBehaviour calculateBehaviour) {
        this.calculateBehaviour = calculateBehaviour;
    }

    public List<ContainerSetup> makeSetups(int length, int width, int height, int amount){
        List<ContainerSetup> setups = new ArrayList<>();
        int counter=0,number = amount, maxcount;
        boolean outOfItems = false;
        Container biggest = fitter.fillContainer(ContainerType.BIGGEST,length,width,height,number);
        Container smallest = fitter.fillContainer(ContainerType.SMALLEST,length,width,height,number);
        List<Container> containers;
        maxcount = amount/biggest.getAmountOfItems();
        if (amount%biggest.getAmountOfItems()!=0){maxcount++;}
        while(counter<=maxcount){
            number = amount;
            containers = new ArrayList<>();
            while(!outOfItems && number != 0){
                if (number>smallest.getAmountOfItems()){
                    for (int i=0;i<counter;i++){
                        if (number<=biggest.getAmountOfItems()){
                            containers.add(fitter.fillContainer(ContainerType.BIGGEST,length,width,height,number));
                            outOfItems=true;
                            number=0;
                            break;
                        }
                        containers.add(fitter.fillContainer(ContainerType.BIGGEST,length,width,height,number));
                        number-= biggest.getAmountOfItems();
                    }
                    if (number>smallest.getAmountOfItems()) {
                        containers.add(fitter.fillContainer(ContainerType.SMALLEST,length,width,height,number));
                        number -= smallest.getAmountOfItems();
                    }else if (number != 0){
                        containers.add(fitter.fillContainer(ContainerType.SMALLEST,length,width,height,number));
                        number = 0;
                        outOfItems = true;
                    }
                }else {
                    containers.add(fitter.fillContainer(ContainerType.SMALLEST,length,width,height,number));
                    outOfItems=true;
                    number=0;
                    break;
                }
                if (number==0){outOfItems=true;}
            }
            setups.add(new ContainerSetup(containers));
            outOfItems=false;
            counter++;
        }
        return setups;
    }

    public ContainerSetup calculateBestSetup(int length, int width, int height, int amount) {
        List<ContainerSetup> setups = makeSetups(length, width, height, amount);
        ContainerSetup lowest = setups.get(0);
        for (ContainerSetup cs: setups) {
            if (cs.getLostSpace()<lowest.getLostSpace()){
                lowest = cs;
            }
        }
        return lowest;
    }
}
