package com.bin.packaging;

import java.util.List;
import java.util.Map;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {
    public static void main(String[] args) {

        PackagingFacade facade = new PackagingFacade(
                new TertiaryTreeAlgorithm(),new OnlyTwoTypes());
        /*ContainerSetup cs = facade.calculateSetup(40,80,80,65);
        cs = facade.calculateSetup(20,40,20,65);
        cs = facade.calculateSetup(20,30,40,65);
        cs = facade.calculateSetup(20,25,40,65);*/
        Container c = facade.getSpecificLoadedContainer(ContainerType.SMALLEST,20,40,20,65);

        Map<Container,Integer> temp = Translator.convertFromContainerSetup(null);

        System.out.println(temp);
    }
}
