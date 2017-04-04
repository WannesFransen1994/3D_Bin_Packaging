package com.bin.packaging;

import java.util.ArrayList;
import java.util.List;

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
        int counter = 1,lowest,lost;
        List<Box> lowestBoxSetups = new ArrayList<>();
        lowestBoxSetups.add(VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight()));
        lowest = moduloCalculateLostSpace(subspace,box);
        while (counter<=6){
            turnBox(counter,box);
            counter ++;
            lost=moduloCalculateLostSpace(subspace,box);
            if (lost<=lowest){
                if (lost<lowest){lowestBoxSetups = new ArrayList<>();}
                lowest=moduloCalculateLostSpace(subspace,box);
                lowestBoxSetups.add(VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight()));
            }
        }
        return calculateBestSetup(subspace,lowestBoxSetups);
    }

    private Box calculateBestSetup(VolumeObject subspace, List<Box> bestSetups){
        String[] mostImportant = longestSideHelperFunction(subspace);
        Box bestfit = bestSetups.get(0);
        switch (mostImportant[0]){
            case "length":
                for (Box box:bestSetups) {
                    if (box.getLength()<bestfit.getLength()){
                        bestfit=box;
                        continue;
                    }else if (mostImportant[1].equals("width") && box.getLength() == bestfit.getLength() && box.getWidth()<bestfit.getWidth()){
                        bestfit=box;
                        continue;
                    } else if (mostImportant[1].equals("height") && box.getLength() == bestfit.getLength() && box.getHeight()<bestfit.getHeight()){
                        bestfit=box;
                        continue;
                    }
                }
            break;
            case "width":
                for (Box box:bestSetups) {
                    if (box.getWidth()<bestfit.getWidth()){
                        bestfit=box;
                        continue;
                    }else if (mostImportant[1].equals("length") && box.getWidth() == bestfit.getWidth() && box.getLength()<bestfit.getLength()){
                        bestfit=box;
                        continue;
                    } else if (mostImportant[1].equals("height") && box.getWidth() == bestfit.getWidth() && box.getHeight()<bestfit.getHeight()){
                        bestfit=box;
                        continue;
                    }
                }
                break;
            case "height":
                for (Box box:bestSetups) {
                    if (box.getHeight()<bestfit.getHeight()){
                        bestfit=box;
                        continue;
                    }else if (mostImportant[1].equals("length") && box.getHeight() == bestfit.getHeight() && box.getLength()<bestfit.getLength()){
                        bestfit=box;
                        continue;
                    } else if (mostImportant[1].equals("height") && box.getHeight() == bestfit.getHeight() && box.getWidth()<bestfit.getWidth()){
                        bestfit=box;
                        continue;
                    }
                }
                break;
        }
        return bestfit;
    }
//TODO: review this horror-code....
    private String[] longestSideHelperFunction(VolumeObject subspace){
        String[] importantList = new String[3];
        if (subspace.getLength()> subspace.getWidth() && subspace.getLength() > subspace.getHeight()){
            //Most important is minimal length
            importantList[0]="length";
            if (subspace.getWidth()>subspace.getHeight()){
                importantList[1]="width";
            }else {importantList[1]="height";}
        }else if (subspace.getWidth()> subspace.getLength() && subspace.getWidth() > subspace.getHeight()){
            //Most important is minimal width
            importantList[0]="width";
            if (subspace.getLength()>subspace.getHeight()){
                importantList[1]="length";
            }else {importantList[1]="height";}
        }else {
            //Most important is minimal height
            importantList[0]="height";
            if (subspace.getWidth()>subspace.getLength()){
                importantList[1]="width";
            }else {importantList[1]="length";}
        }
        return importantList;
    }


}
