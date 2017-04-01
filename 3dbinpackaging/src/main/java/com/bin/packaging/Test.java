package com.bin.packaging;

import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {
    public static void main(String[] args) {
        BoxFitter boxFitter = new BoxFitter();
        boxFitter.setFillBehaviour(new BasicAlgorithm());

        List<Container> list = boxFitter.fillContainersMax(40,40,50,100);
        System.out.println(list);
    }
}
