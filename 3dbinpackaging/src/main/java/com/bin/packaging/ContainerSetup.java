package com.bin.packaging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erowan on 01/04/2017.
 */
public class ContainerSetup {
    private Map<Container,Float> containersSetup;
    private float lostSpace;

    public ContainerSetup(List<Container> containers) {
        lostSpace = 0;
        this.containersSetup = sortContainers(containers);
    }

    private Map<Container,Float> sortContainers(List<Container> containers){
        containersSetup = new HashMap<>();
        for (Container c:containers) {
            float lost = c.getVolume()-(c.getVolume()*c.getFilled());
            containersSetup.put(c,lost);
            lostSpace += lost;
        }
        return containersSetup;
    }

    public Map<Container, Float> getContainersSetup() {
        return containersSetup;
    }

    public float getLostSpace() {
        return lostSpace;
    }
}
