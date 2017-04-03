package com.bin.packaging;

/**
 * Created by erowan on 03/04/2017.
 */
public class TertiaryTreeAlgorithm extends AlgorithmCommonMethods {
    //This scenario (Type1 Container & Type2 container): Width is always the smallest!
    //You place a block, orientation is based on following rules:
    //Rule n°1 -> With the following orientation, it has to fit as much as possible in the volume of the subspace/Container
    //     ==> most important rule! My calculation is based on modulo and you calculate the remaining unused space.
    //     ==> This is a value that has to be as small as possible
    //Rule n°2 -> If the orientation doesn't matter (same results no matter how you turn the blcok):
    //  Choose the orientation with the minimal length
    //  Choose the orientation with the minimal height
    //  Choose the orientation with the minimal width
    //    (in the paper they say width before height, but their subspaces + box are orientated differently)
    //We choose to make the first subspace like this:
    //  Shortest dimension (width) -> stretch Object length & height out as fas as this dimension allows
    //As for the second subspace:
    //  The subspace length = Object length
    //  The subspace height = Container height - object height
    //  The subspace width  = Container width
    //As for the third subspace:
    //  The subspace length = Container length - object length
    //  The subspace height = Container height
    //  The subspace width  = Container width

    //That was a recursive function.. Good job!
    //Now you have to keep in mind that some subspaces (which are too small) are destroyed.
    //  You want to test if these subspaces are worth "Combining". But this is an extra
    @Override
    public Container fillContainer(Container container, Box samplebox, int amount) {


        return null;
    }
    private void recursiveSubspaceallocator(VolumeObject subspace, Box samplebox){

    }
}
