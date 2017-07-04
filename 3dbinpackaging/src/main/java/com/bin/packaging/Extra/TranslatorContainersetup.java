package com.bin.packaging.Extra;

import com.bin.packaging.Model.Box;
import com.bin.packaging.Model.BoxSetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class TranslatorContainersetup {

    public static Map<Box, Integer> convertFromContainerSetup(BoxSetup setup) {
        Map<Box, Integer> containerAmountMap = new HashMap<>();
        boolean start = true;
        boolean addme = true;
        Box objectToAdd = null;
        for (Box cs : setup.getBoxSetup().keySet()) {
            if (start) {
                containerAmountMap.put(cs, 1);
                start = false;
                continue;
            }
            for (Box container : containerAmountMap.keySet()) {
                if (cs.equals(container)) {
                    objectToAdd = container;
                    addme = true;
                    break;
                } else {
                    objectToAdd = cs;
                    addme = true;
                    break;
                }
            }
            if (addme && !containerAmountMap.containsKey(objectToAdd)) {
                containerAmountMap.put(objectToAdd, 1);
                addme = false;
            } else if (addme && containerAmountMap.containsKey(objectToAdd)) {
                containerAmountMap.put(objectToAdd, containerAmountMap.get(objectToAdd) + 1);
                addme = false;
            }
        }
        return containerAmountMap;
    }
}
