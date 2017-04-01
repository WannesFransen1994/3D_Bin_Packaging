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
    private BoxFitter fitter = new BoxFitter();

    public List<Container> getFitterSampleData() {
        return fitter.getSampleData();
    }
}
