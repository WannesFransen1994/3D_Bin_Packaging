package com.bin.packaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class OnlyTwoTypes implements CalculateBehaviour {
    @Override
    public ContainerSetup calculateSetup(ContSetupCalculater contSetupCalculater, int length, int width, int height, int amount) {
        List<ContainerSetup> list = makeSetups(contSetupCalculater,length, width, height, amount);
        return calculateBestSetup(list);
    }

    public List<ContainerSetup> makeSetups(ContSetupCalculater contSetupCalculater, int length, int width, int height, int amount){
        List<ContainerSetup> setups = new ArrayList<>();
        int counter=0,number = amount, maxcount;
        boolean outOfItems = false;
        List<Container> containers;
        Container biggest = contSetupCalculater.getLoadedContainer(ContainerType.BIGGEST,length,width,height,number);
        Container smallest = contSetupCalculater.getLoadedContainer(ContainerType.SMALLEST,length,width,height,number);

        maxcount = amount/biggest.getAmountOfItems();
        if (amount%biggest.getAmountOfItems()!=0){maxcount++;}
        while(counter<=maxcount){
            number = amount;
            containers = new ArrayList<>();
            while(!outOfItems && number != 0){
                if (number>smallest.getAmountOfItems()){
                    for (int i=0;i<counter;i++){
                        if (number<=biggest.getAmountOfItems()){
                            containers.add(contSetupCalculater.getLoadedContainer(ContainerType.BIGGEST,length,width,height,number));
                            outOfItems=true;
                            number=0;
                            break;
                        }
                        containers.add(contSetupCalculater.getLoadedContainer(ContainerType.BIGGEST,length,width,height,number));
                        number-= biggest.getAmountOfItems();
                    }
                    if (number>smallest.getAmountOfItems()) {
                        containers.add(contSetupCalculater.getLoadedContainer(ContainerType.SMALLEST,length,width,height,number));
                        number -= smallest.getAmountOfItems();
                    }else if (number != 0){
                        containers.add(contSetupCalculater.getLoadedContainer(ContainerType.SMALLEST,length,width,height,number));
                        number = 0;
                        outOfItems = true;
                    }
                }else {
                    containers.add(smallest);
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

    public ContainerSetup calculateBestSetup(List<ContainerSetup> setups) {
        ContainerSetup lowest = setups.get(0);
        for (ContainerSetup cs : setups) {
            if (cs.getLostSpace() < lowest.getLostSpace()) {
                lowest = cs;
            }
        }
        return lowest;
    }
}
