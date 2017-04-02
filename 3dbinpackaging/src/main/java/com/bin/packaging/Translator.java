package com.bin.packaging;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erowan on 02/04/2017.
 */
public class Translator {

    public static Map<Container,Integer> convertFromContainerSetup(ContainerSetup setup){
        Map<Container,Integer> containerAmountMap = new HashMap<>();
        boolean start = true;
        boolean addme = true;
        Container objectToAdd=null;
        for (Container cs: setup.getContainersSetup().keySet()) {
            if (start==true){containerAmountMap.put(cs, 1);start = false;continue;}
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
            if (addme==true && containerAmountMap.containsKey(objectToAdd)==false){containerAmountMap.put(objectToAdd,1);addme=false;}
            else if (addme==true && containerAmountMap.containsKey(objectToAdd)==true){containerAmountMap.put(objectToAdd,containerAmountMap.get(objectToAdd)+1);addme=false;}
        }
        return containerAmountMap;
    }
}
