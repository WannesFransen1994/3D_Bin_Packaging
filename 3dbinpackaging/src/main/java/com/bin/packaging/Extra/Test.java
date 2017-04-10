package com.bin.packaging.Extra;

import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.ContainerSetup;
import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.Model.TertiaryTreeAlgorithm;
import com.bin.packaging.PackagingFacade;

import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
class Test {
    public static void main(String[] args) {

        PackagingFacade facade = new PackagingFacade(
                new TertiaryTreeAlgorithm(),new OnlyTwoTypes());
        ContainerSetup cs = facade.calculateSetup(50,45,20,18);

        Map<Container,Integer> temp = TranslatorContainersetup.convertFromContainerSetup(cs);

        System.out.println(temp);
    }
}
