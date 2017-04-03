package com.bin.packaging;

import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public interface CalculateBehaviour {
    ContainerSetup calculateSetup(ContSetupCalculater contSetupCalculater, int length, int width, int height, int amount);
}
