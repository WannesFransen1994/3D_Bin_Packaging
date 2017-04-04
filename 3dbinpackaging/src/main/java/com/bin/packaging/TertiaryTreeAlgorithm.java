package com.bin.packaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erowan on 03/04/2017.
 */
public class TertiaryTreeAlgorithm extends AlgorithmCommonMethods {
    /*This scenario (Type1 Container & Type2 container): Width is always the smallest!
    You place a block, orientation is based on following rules:
    Rule n°1 -> With the following orientation, it has to fit as much as possible in the volume of the subspace/Container
         ==> most important rule! My calculation is based on modulo and you calculate the remaining unused space.
         ==> This is a value that has to be as small as possible
    Rule n°2 -> If the orientation doesn't matter (same results no matter how you turn the blcok):
      Choose the orientation with the minimal length
      Choose the orientation with the minimal height
      Choose the orientation with the minimal width
        (in the paper they say width before height, but their subspaces + box are orientated differently)
    //TODO: This is a case where width is the shortest. What about other setups? (new subspaces)
    We choose to make the first subspace like this:
      Shortest dimension (width) -> stretch Object length & height out as fas as this dimension allows
    As for the second subspace:
      The subspace length = Object length
      The subspace height = Container height - object height
      The subspace width  = Container width
    As for the third subspace:
      The subspace length = Container length - object length
      The subspace height = Container height
      The subspace width  = Container width

    That was a recursive function.. Good job!
    Now you have to keep in mind that some subspaces (which are too small) are destroyed.
      You want to test if these subspaces are worth "Combining". But this is an extra
    */
    private Container container;
    private List<Subspace> unused = new ArrayList<>();
    @Override
    public Container fillContainer(Container container, Box samplebox, int amount) {
        this.container=container;
        recursiveSubspaceallocator(new Subspace(container),samplebox);

        return container;
    }
    private void recursiveSubspaceallocator(Subspace subspace, Box box){
        box = calculateLowestSetup(subspace,box);
        //TODO: sanity check to place box
        container.addItem(
                LocationFactory.createCoordinate(
                        subspace.getCoordinate().getCoordinate_x(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_y()),
                VolumeObjectFactory.createBox(box.getLength(),box.getWidth(),box.getHeight()));
        //SUBSPACE 1 hardcoded
        if (container.getWidth()<subspace.getWidth()+box.getWidth()){
            Subspace subspace1 = new Subspace(new Coordinate(
                    subspace.getLength(),
                    subspace.getWidth()+box.getWidth(),
                    subspace.getHeight()),
                    box.getLength(),
                    subspace.getWidth()-box.getWidth(),
                    box.getHeight());
        }else{//No new subspace 1?}
        int newSubx =
        int newSubx =
        int newSubx =
    }
}
