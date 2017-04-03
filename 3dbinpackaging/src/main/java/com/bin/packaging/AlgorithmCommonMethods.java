package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public abstract class AlgorithmCommonMethods implements FillBehaviour{
    private Box turnBox(int counter, Box box){
        if (counter % 2 == 0) {
            box.turnZaxis();
        }else {
            box.turnXaxis();
        }
        return box;
    }

    protected int moduloCalculateLostSpace(VolumeObject volumeObject, Box box){
        int lostHeight = 1, lostWidth = 1 ,lostLength = 1;
        if (volumeObject.getHeight()%box.height!=0){
            lostHeight = volumeObject.getHeight()%box.height;
        }
        if (volumeObject.getWidth()%box.width!=0){
            lostWidth  = volumeObject.getWidth()%box.width;
        }
        if (volumeObject.getLength()%box.length!=0){
            lostLength = volumeObject.getLength()%box.length;
        }

        return lostHeight*lostLength*lostWidth;
    }

    protected Box calculateLowestSetup(VolumeObject subspace, Box box){
        int counter = 1,lowest;
        Box lowestBoxSetup = VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight());
        lowest = moduloCalculateLostSpace(subspace,box);
        while (counter<=6){
            turnBox(counter,box);
            counter ++;
            if (moduloCalculateLostSpace(subspace,box)<lowest){
                lowest=moduloCalculateLostSpace(subspace,box);
                lowestBoxSetup = VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight());
            }
        }
        return lowestBoxSetup;
    }
}
