package com.bin.packaging.Extra;

import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.Model.TertiaryTreeAlgorithm;
import com.bin.packaging.PackagingFacade;

import java.util.Map;

/**
 * Created by wannes on 10/07/2017.
 */
public class Test {
    public static void main(String[] args) {

        PackagingFacade f = new PackagingFacade(new TertiaryTreeAlgorithm(),new OnlyTwoTypes());

        f.setBoxSize(80,80,80,0,0,0);
        Map map = f.getTranslatedSetup(15,29,259,153,6);

        System.out.print(map);
    }
}
