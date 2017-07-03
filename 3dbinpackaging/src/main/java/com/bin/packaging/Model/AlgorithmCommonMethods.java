package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wannes Fransen.
 */
abstract class AlgorithmCommonMethods implements FillBehaviour {
    private void turnBox(int counter, Column box) {
        if (counter % 2 == 0) {
            box.turnZaxis();
        } else {
            box.turnXaxis();
        }
    }

    private int moduloCalculateLostSpace(VolumeObject volumeObject, Column box) {
        int lostHeight = 1, lostWidth = 1, lostLength = 1;
        if (volumeObject.getHeight() % box.height != 0) {
            lostHeight = volumeObject.getHeight() % box.height;
        }
        if (volumeObject.getWidth() % box.width != 0) {
            lostWidth = volumeObject.getWidth() % box.width;
        }
        if (volumeObject.getLength() % box.length != 0) {
            lostLength = volumeObject.getLength() % box.length;
        }

        return lostHeight * lostLength * lostWidth;
    }

    Column calculateLowestSetup(VolumeObject subspace, Column column) {
        int counter = 1, lowest, lost;
        List<Column> lowestBoxSetups = new ArrayList<>();
        lowestBoxSetups.add(VolumeObjectFactory.createColumn(column));
        lowest = moduloCalculateLostSpace(subspace, column);
        while (counter <= 7) {
            turnBox(counter, column);
            counter++;
            if (subspace.getWidth() >= column.getWidth() && subspace.getHeight() >= column.getHeight() && subspace.getLength() >= column.getLength()) {
                lost = moduloCalculateLostSpace(subspace, column);
                if (lost <= lowest) {
                    if (lost < lowest) {
                        lowestBoxSetups = new ArrayList<>();
                    }

                    lowest = moduloCalculateLostSpace(subspace, column);
                    lowestBoxSetups.add(VolumeObjectFactory.createColumn(column));
                }
            }
        }
        return calculateBestSetup(subspace, lowestBoxSetups);
    }

    private Column calculateBestSetup(VolumeObject subspace, List<Column> bestSetups) {
        String[] mostImportant = longestSideHelperFunction(subspace);
        Column bestfit = bestSetups.get(0);
        switch (mostImportant[0]) {
            case "length":
                for (Column box : bestSetups) {
                    if (box.getLength() < bestfit.getLength()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("width") && box.getLength() == bestfit.getLength() && box.getWidth() < bestfit.getWidth()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("height") && box.getLength() == bestfit.getLength() && box.getHeight() < bestfit.getHeight()) {
                        bestfit = box;
                    }
                }
                break;
            case "width":
                for (Column box : bestSetups) {
                    if (box.getWidth() < bestfit.getWidth()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("length") && box.getWidth() == bestfit.getWidth() && box.getLength() < bestfit.getLength()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("height") && box.getWidth() == bestfit.getWidth() && box.getHeight() < bestfit.getHeight()) {
                        bestfit = box;
                    }
                }
                break;
            case "height":
                for (Column box : bestSetups) {
                    if (box.getHeight() < bestfit.getHeight()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("length") && box.getHeight() == bestfit.getHeight() && box.getLength() < bestfit.getLength()) {
                        bestfit = box;
                    } else if (mostImportant[1].equals("height") && box.getHeight() == bestfit.getHeight() && box.getWidth() < bestfit.getWidth()) {
                        bestfit = box;
                    }
                }
                break;
        }
        return bestfit;
    }

    //TODO: review this horror-code....
    String[] longestSideHelperFunction(VolumeObject subspace) {
        String[] importantList = new String[3];
        if (subspace.getLength() > subspace.getWidth() && subspace.getLength() > subspace.getHeight()) {
            //Most important is minimal length
            importantList[0] = "length";
            if (subspace.getWidth() > subspace.getHeight()) {
                importantList[1] = "width";
            } else {
                importantList[1] = "height";
            }
        } else if (subspace.getWidth() > subspace.getLength() && subspace.getWidth() > subspace.getHeight()) {
            //Most important is minimal width
            importantList[0] = "width";
            if (subspace.getLength() > subspace.getHeight()) {
                importantList[1] = "length";
            } else {
                importantList[1] = "height";
            }
        } else {
            //Most important is minimal height
            importantList[0] = "height";
            if (subspace.getWidth() > subspace.getLength()) {
                importantList[1] = "width";
            } else {
                importantList[1] = "length";
            }
        }
        return importantList;
    }


}
