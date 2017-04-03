package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public abstract class AlgorithmCommonMethods implements FillBehaviour{
    protected Box turnBox(int counter, Box box){
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
}
