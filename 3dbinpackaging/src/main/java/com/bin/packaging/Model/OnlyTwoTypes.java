package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wannes Fransen.
 */
public class OnlyTwoTypes implements CalculateBehaviour {
    @Override
    public BoxSetup calculateSetup(List<Box> bigSmall, int amount) {
        List<BoxSetup> list = makeSetups(bigSmall, calculateAmount(amount));
        return calculateBestSetup(list);
    }

    private List<BoxSetup> makeSetups(List<Box> bigSmall, int amount) {
        int counter = 0, number = amount;
        List<BoxSetup> setups = new ArrayList<>();
        List<Box> boxes;
        Box biggest = bigSmall.get(0),smallest = bigSmall.get(0);

        for (Box box : bigSmall) {
            if (box.getVolume() < smallest.getVolume()){
                smallest = box;
            }
            if (box.getVolume() > biggest.getVolume()){
                biggest = box;
            }
        }

        //this value is the maximum amount of big boxes we'll need to pack all of the columns.
        //If it fits in 6 big boxes, we'll only have to calculate all setups until 6big and 0 small boxes.
        //This value determines the max amount of iterations.
        int maxAmountBoxes = amount / biggest.getAmountOfItems();

        if (amount % biggest.getAmountOfItems() != 0) {
            maxAmountBoxes++;
        }
        while (counter <= maxAmountBoxes) {
            number = amount;
            boxes = new ArrayList<>();
            while (number > 0) {
                if (number > smallest.getAmountOfItems()) {
                    for (int i = 0; (i < counter && number > 0); i++) {
                        if (number <= biggest.getAmountOfItems()) {
                            boxes.add(VolumeObjectFactory.copyBoxAmountItems(biggest,number));
                            number = 0;
                            break;
                        }
                        boxes.add(VolumeObjectFactory.copyBoxAmountItems(biggest,biggest.getAmountOfItems()));
                        number -= biggest.getAmountOfItems();
                    }
                    if (number > smallest.getAmountOfItems()) {
                        boxes.add(VolumeObjectFactory.copyBoxAmountItems(smallest,smallest.getAmountOfItems()));
                        number -= smallest.getAmountOfItems();
                    } else if (number > 0) {
                        boxes.add(VolumeObjectFactory.copyBoxAmountItems(smallest,number));
                        number = 0;
                    }
                } else {
                    boxes.add(VolumeObjectFactory.copyBoxAmountItems(smallest,number));
                    break;
                }
            }
            setups.add(new BoxSetup(boxes));
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

    public static int calculateAmount(int amount) {
        if (amount % 2 == 1) {
            return (amount + 1) / 2;
        }
        return amount / 2;
    }
}
