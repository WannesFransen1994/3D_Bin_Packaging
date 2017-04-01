package com.bin.packaging;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {

    public static void main(String[] args) {
        PackagingFacade f = new PackagingFacade();
        System.out.println(f.getFitterSampleData());
        System.out.println(f.getFitterSampleData().get(0));
        //System.out.println(f.getFitterSampleData());


    }
}
