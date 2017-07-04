package com.bin.packaging.Model;

import java.util.List;

/**
 * Created by Wannes Fransen.
 */
public interface CalculateBehaviour {
    BoxSetup calculateSetup(List<Box> bigSmall, int amount);
}
