/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

import java.util.List;
import java.util.Map;

/**
 *
 * @author erowan
 */
public class PackagingFacade {
    BoxFitter fitter = new BoxFitter();

    public List<Container> getFitterSampleData() {
        return fitter.getSampleData();
    }
}
