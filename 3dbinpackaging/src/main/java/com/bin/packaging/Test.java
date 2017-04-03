package com.bin.packaging;

import java.util.List;
import java.util.Map;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {
    public static void main(String[] args) {

        PackagingFacade facade = new PackagingFacade(new BasicAlgorithm(),new OnlyTwoTypes());
        ContainerSetup cs = facade.calculateSetup(20,40,40,40);

        Map<Container,Integer> temp = Translator.convertFromContainerSetup(cs);

        System.out.println(temp);
    }
}
