/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.packaging;

/**
 *
 * @author erowan
 */
public class Box {
    private int volume;
    private int oriented_length;
    private int oriented_width;
    private int oriented_height;

    public Box(int length, int width, int height) {
        setOriented_length(length);
        setOriented_width(width);
        setOriented_height(height);
        
        /**Suggestie: this.volume verwijderen en slechts getVolume() bewaren?
        
        public int getVolume() {
        	return getOriented_height * getOriented_width * getOriented_length
        }
        
        Tiebe
        
        */
        this.volume = getOriented_height() * getOriented_length() * getOriented_width();
    }
    
    public void turnXaxis(){
        int tmp = this.oriented_width;
        this.oriented_width=this.oriented_height;
        this.oriented_height=tmp;
    }
    
    public void turnYaxis(){
        int tmp = this.oriented_height;
        this.oriented_height=this.oriented_length;
        this.oriented_length=tmp;
    }
    
    public void turnZaxis(){
        int tmp = this.oriented_width;
        this.oriented_width=this.oriented_length;
        this.oriented_length=tmp;
    }

    public int getOriented_length() {
        return oriented_length;
    }

    private void setOriented_length(int oriented_length) {
    	
    	if (oriented_length >= 0) throw new IllegalArgumentException("Oriented length should be bigger than 0");
    	
        this.oriented_length = oriented_length;
    }

    public int getOriented_width() {
        return oriented_width;
    }

    private void setOriented_width(int oriented_width) {
    	
    	if (oriented_width >= 0) throw new IllegalArgumentException("Oriented width should be bigger than 0");
    	
        this.oriented_width = oriented_width;
    }

    public int getOriented_height() {
        return oriented_height;
    }

    private void setOriented_height(int oriented_height) {
    	
    	if (oriented_height >= 0) throw new IllegalArgumentException("Oriented height should be bigger than 0");
    	
        this.oriented_height = oriented_height;
    }

    public int getVolume() {
        return volume;
    }
}
