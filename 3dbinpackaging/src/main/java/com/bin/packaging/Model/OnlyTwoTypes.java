package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wannes Fransen.
 */
public class OnlyTwoTypes implements CalculateBehaviour {
    @Override
    public BoxSetup calculateSetup(Column c, int amount) {
        List<BoxSetup> list = makeSetups(c, calculateAmount(amount));
        return calculateBestSetup(list);
    }

    private List<BoxSetup> makeSetups(Column c, int amount) {
        List<BoxSetup> setups = new ArrayList<>();
        int counter = 0, number = amount, maxcount;
        List<Box> containers;
        Box biggest = BoxSetup.getLoadedContainer(BoxType.BIGGEST, c, number);
        Box smallest = BoxSetup.getLoadedContainer(BoxType.SMALLEST, c, number);

        maxcount = amount / biggest.getAmountOfItems();

        if (amount % biggest.getAmountOfItems() != 0) {
            maxcount++;
        }
        while (counter <= maxcount) {
            number = amount;
            containers = new ArrayList<>();
            while (number > 0) {
                if (number > smallest.getAmountOfItems()) {
                    for (int i = 0; (i < counter && number > 0); i++) {
                        if (number <= biggest.getAmountOfItems()) {
                            containers.add(BoxSetup.getLoadedContainer(BoxType.BIGGEST, c, number));
                            number = 0;
                            break;
                        }
                        containers.add(BoxSetup.getLoadedContainer(BoxType.BIGGEST, c, number));
                        number -= biggest.getAmountOfItems();
                    }
                    if (number > smallest.getAmountOfItems()) {
                        containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST, c, number));
                        number -= smallest.getAmountOfItems();
                    } else if (number > 0) {
                        containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST, c, number));
                        number = 0;
                    }
                } else {
                    containers.add(BoxSetup.getLoadedContainer(BoxType.SMALLEST, c, number));
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

    public int calculateAmount(int amount) {
        if (amount % 2 == 1) {
            return (amount + 1) / 2;
        }
        return amount / 2;
    }
}
