/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import com.bin.packaging.Model.*;
import com.bin.packaging.Extra.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Wannes Fransen.
 */
public class PackagingFacade {
    public PackagingFacade(FillBehaviour fillBehaviour, CalculateBehaviour calculateBehaviour) {
        Box.setFillBehaviour(fillBehaviour);
        BoxSetup.setFacade(this);
        BoxSetup.setCalculateBehaviour(calculateBehaviour);
    }

    public Box getSpecificLoadedContainer(BoxType containerType, Column c, int amount) {
        return Box.fillContainer(containerType, c, amount);
    }

    //Gets called upon by REST service
    public Map<Box, Integer> getTranslatedSetup(int length, int width, int height, int amount, int pockets) {
        return TranslatorContainersetup.convertFromContainerSetup(
                BoxSetup.calculateSetup(length, width, height, pockets, amount));
    }
}
