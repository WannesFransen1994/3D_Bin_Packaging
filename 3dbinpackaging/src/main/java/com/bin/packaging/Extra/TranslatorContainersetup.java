package com.bin.packaging.Extra;

import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.ContainerSetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class TranslatorContainersetup {

    public static Map<Container,Integer> convertFromContainerSetup(ContainerSetup setup){
        Map<Container,Integer> containerAmountMap = new HashMap<>();
        boolean start = true;
        boolean addme = true;
        Container objectToAdd=null;
        for (Container cs: setup.getContainersSetup().keySet()) {
            if (start){containerAmountMap.put(cs, 1);start = false;continue;}
            for (Container container:containerAmountMap.keySet()){
                if (cs.equals(container)){
                    objectToAdd = container;
                    addme = true;
                    break;
                }else{
                    objectToAdd = cs;
                    addme = true;
                    break;
                }
            }
            if (addme && !containerAmountMap.containsKey(objectToAdd)){containerAmountMap.put(objectToAdd,1);addme=false;}
            else if (addme && containerAmountMap.containsKey(objectToAdd)){containerAmountMap.put(objectToAdd,containerAmountMap.get(objectToAdd)+1);addme=false;}
        }
        return containerAmountMap;
    }
}
