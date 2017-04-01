package com.bin.packaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class TestFitter {
    private VolumeObjectFactory factory = new VolumeObjectFactory();

    public List<Container> getSampleData() {
        Box samplebox = factory.createBox(70,100,50);
        List<Container> filledContainers = new ArrayList<>();
        filledContainers.add(factory.createContainer(ContainerType.SAMPLE_CONTAINER));
        filledContainers.add(factory.createContainer(ContainerType.SAMPLE_CONTAINER));
        filledContainers.get(0).addItem(new Coordinate(70, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(140, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 100, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(70, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(140, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 200, 0),samplebox);
        filledContainers.get(0).addItem(new Coordinate(70, 100, 50),samplebox);
        samplebox.turnXaxis();
        filledContainers.get(0).addItem(new Coordinate(140, 100, 70),samplebox);
        filledContainers.get(0).addItem(new Coordinate(210, 100, 70),samplebox);
        filledContainers.get(1).addItem(new Coordinate(70, 100, 0),samplebox);
        return filledContainers;
    }


}
