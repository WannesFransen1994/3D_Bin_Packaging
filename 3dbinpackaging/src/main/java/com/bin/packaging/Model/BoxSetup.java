package com.bin.packaging.Model;

import com.bin.packaging.PackagingFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class BoxSetup {
    private Map<Box,Float> containersSetup;
    private float lostSpace;
    private static CalculateBehaviour calculateBehaviour;
    private static PackagingFacade facade;

    public BoxSetup(List<Box> containers) {
        lostSpace = 0;
        this.containersSetup = sortContainers(containers);
    }

    public static void setCalculateBehaviour(CalculateBehaviour c) {
        calculateBehaviour = c;
    }
    public static void setFacade(PackagingFacade f) {
        facade = f;
    }

    public static BoxSetup calculateSetup(int length, int width, int height,int pockets, int amount) {
        return calculateBehaviour.calculateSetup(
                VolumeObjectFactory.createColumn(length, width, height, pockets),
                amount);
    }

    static Box getLoadedContainer(BoxType type, Column c, int amount){
        return facade.getSpecificLoadedContainer(type, c, amount);
    }

    public Map<Box, Float> getContainersSetup() {
        return containersSetup;
    }

    public float getLostSpace() {
        return lostSpace;
    }

    private Map<Box,Float> sortContainers(List<Box> containers){
        containersSetup = new HashMap<>();
        for (Box c:containers) {
            float lost = c.getVolume()-(c.getVolume()*c.getFilled());
            containersSetup.put(c,lost);
            lostSpace += lost;
        }
        return containersSetup;
    }
}
