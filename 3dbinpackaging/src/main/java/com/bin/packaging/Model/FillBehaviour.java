/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging.Model;

/**
 *
 * Created by Wannes Fransen.
 */
public interface FillBehaviour {
    Box fillContainer(Box container, Column samplebox, int amount);
}
