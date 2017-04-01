/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import java.util.List;

/**
 *
 * @author erowan
 */
public class PackagingFacade {
    private BoxFitter fitter;
    private TestFitter test = new TestFitter();

    public PackagingFacade() {
        fitter = new BoxFitter();
        fitter.setFillBehaviour(new BasicAlgorithm());
    }

    public List<Container> getFitterSampleData() {
        return test.getSampleData();
    }

    public List<Container> getMaxLoadedContainers(int length,int width,int height) {
        return fitter.fillContainersMax(height,width,length,-1);
    }

    public List<Container> getMaxLoadedContainers(int length,int width,int height,int amount) {
        return fitter.fillContainersMax(height,width,length,amount);
    }
}
