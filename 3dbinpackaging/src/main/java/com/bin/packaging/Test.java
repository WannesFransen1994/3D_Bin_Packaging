package com.bin.packaging;

import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {
    public static void main(String[] args) {

        PackagingFacade facade = new PackagingFacade();
        ContainerSetup cs = facade.calculateSetup(50,80,40,20);
        System.out.println(cs);
    }
}
