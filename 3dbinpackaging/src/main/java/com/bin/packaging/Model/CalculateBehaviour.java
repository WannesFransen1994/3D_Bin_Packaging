package com.bin.packaging.Model;

/**
 * Created by Wannes Fransen.
 */
public interface CalculateBehaviour {
    ContainerSetup calculateSetup(ContSetupCalculater contSetupCalculater, int length, int width, int height, int amount);
}
