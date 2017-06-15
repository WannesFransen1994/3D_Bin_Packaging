package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wannes Fransen.
 */
public class OnlyTwoTypes implements CalculateBehaviour {
    @Override
    public BoxSetup calculateSetup(int length, int width, int height, int amount) {
        List<BoxSetup> list = makeSetups(length, width, height, amount);
        return calculateBestSetup(list);
    }

    private List<BoxSetup> makeSetups(int length, int width, int height, int amount){
        List<BoxSetup> setups = new ArrayList<>();
        int counter=0,number = amount, maxcount;
        List<Box> containers;
        Box biggest = BoxSetup.getLoadedContainer(BoxType.BIGGEST,length,width,height,number);
        Box smallest = BoxSetup.getLoadedContainer(BoxType.SMALLEST,length,width,height,number);

        maxcount = amount/ biggest.getAmountOfItems();

        if (amount%biggest.getAmountOfItems()!=0){maxcount++;}
        while(counter<=maxcount){
            number = amount;
            containers = new ArrayList<>();
            while(number > 0){
                if (number>smallest.getAmountOfItems()){
                    for (int i=0;(i<counter && number>0);i++){
                        if (number<=biggest.getAmountOfItems()){
                            containers.add(BoxSetup.getLoadedContainer(BoxType.BIGGEST,length,width,height,number));
                            number=0;
                            break;
                        }
                        containers.add(BoxSetup.getLoadedContainer(BoxType.BIGGEST,length,width,height,number));
                        number-= biggest.getAmountOfItems();
                    }
                    if (number>smallest.getAmountOfItems()) {
                        containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST,length,width,height,number));
                        number -= smallest.getAmountOfItems();
                    }else if (number > 0){
                        containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST,length,width,height,number));
                        number = 0;
                    }
                }else {
                    containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST,length,width,height,number));
                    break;
                }
            }
            setups.add(new BoxSetup(containers));
            counter++;
        }
        return setups;
    }

    private BoxSetup calculateBestSetup(List<BoxSetup> setups) {
        BoxSetup lowest = setups.get(0);
        for (BoxSetup cs : setups) {
            if (cs.getLostSpace() < lowest.getLostSpace()) {
                lowest = cs;
            }
        }
        return lowest;
    }
}
