package com.bin.packaging.Extra;

import com.bin.packaging.Model.Box;
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

        Map<Box,Integer> temp = facade.getTranslatedSetup(9,27,259,72,6);

        System.out.println(temp);
    }
}
