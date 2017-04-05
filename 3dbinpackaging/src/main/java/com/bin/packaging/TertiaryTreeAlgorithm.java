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
        this.container = container;
        recursiveSubspaceallocator(VolumeObjectFactory.createSubspace(container), samplebox);

        return container;
    }

    private void recursiveSubspaceallocator(Subspace subspace, Box box) {
        System.out.println("\n################################");
        System.out.println("Subspace: \t"+subspace.getCoordinate().getCoordinate_x()+" x  \t"+subspace.getCoordinate().getCoordinate_y()+" x \t" + subspace.getCoordinate().getCoordinate_z());
        System.out.println("size: \t\t" + subspace.getLength() + " x \t" + subspace.getWidth() + " x \t" + subspace.getHeight());
        box = calculateLowestSetup(subspace, box);
        //TODO: sanity check to place box
        if (subspace.getCoordinate().getCoordinate_x()+box.getLength()<=subspace.getLength() &&
        subspace.getCoordinate().getCoordinate_y()+box.getWidth()<=subspace.getWidth() &&
                subspace.getCoordinate().getCoordinate_z()+box.getHeight()<=subspace.getHeight()) {
            container.addItem(
                    LocationFactory.createCoordinate(
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z()),
                    VolumeObjectFactory.createBox(box.getLength(), box.getWidth(), box.getHeight()));
            calculateSubspacing(subspace, box, longestSideHelperFunction(subspace));
        }
    }

    private void calculateSubspacing(Subspace subspace, Box box, String[] longestFirst) {
        Subspace sub1 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0,0,0),
                subspace.getLength(),subspace.getWidth(),subspace.getHeight());
        Subspace sub2 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0,0,0),
                subspace.getLength(),subspace.getWidth(),subspace.getHeight()) ;
        Subspace sub3 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0,0,0),
                subspace.getLength(),subspace.getWidth(),subspace.getHeight());

        boolean sub1canBeMade = true,sub2canBeMade= true,sub3canBeMade= true;

        switch (longestFirst[0]) {
            case "length":
                if (longestFirst[1].equals("width")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z()+box.getHeight(),
                            box.getLength(),
                            box.getWidth(),
                            subspace.getHeight()-box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y()+box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth()-box.getWidth(),
                            subspace.getHeight());
                } else {
                    //good job, this part works (this method call at least)
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y()+box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth()-box.getWidth(),
                            box.getHeight());
                    //good job, this part works (this method call at least)
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z()+box.getHeight(),
                            box.getLength(),
                            subspace.getWidth(),
                            subspace.getHeight()-box.getHeight());
                }
                sub3canBeMade = configureSubspaceHelper(
                        sub3,
                        subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_z(),
                        subspace.getLength()-box.getLength(),
                        subspace.getWidth(),
                        subspace.getHeight());
                break;
            case "width":
                if (longestFirst[1].equals("length")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z()+box.getHeight(),
                            box.getLength(),
                            box.getWidth(),
                            subspace.getHeight()-box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x()+box.getLength(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength()-box.getLength(),
                            box.getWidth(),
                            subspace.getHeight());
                } else {
                    //this one dies after first subspacing
                    sub1canBeMade = configureSubspaceHelper(
                        sub1,
                        subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_z(),
                        subspace.getLength() - box.getLength(),
                        box.getWidth(),
                        box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z() + box.getHeight(),
                            subspace.getLength(),
                            box.getWidth(),
                            subspace.getHeight()-box.getHeight());

                }
                sub3canBeMade = configureSubspaceHelper(
                    sub3,
                    subspace.getCoordinate().getCoordinate_x(),
                    subspace.getCoordinate().getCoordinate_y()+box.getWidth(),
                    subspace.getCoordinate().getCoordinate_z(),
                    subspace.getLength(),
                    subspace.getWidth()-box.getWidth(),
                    subspace.getHeight());

                break;

            case "height":
                if (longestFirst[1].equals("length")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y()+box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth()-box.getWidth(),
                            box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength()-box.getLength(),
                            subspace.getWidth(),
                            box.getHeight());
                } else {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength() - box.getLength(),
                            box.getWidth(),
                            box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y()+ box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength(),
                            subspace.getWidth()-box.getWidth(),
                            box.getHeight());
                }
                sub3canBeMade = configureSubspaceHelper(
                        sub3,
                        subspace.getCoordinate().getCoordinate_x(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_z()+ box.getHeight(),
                        subspace.getLength(),
                        subspace.getWidth(),
                        subspace.getHeight()-box.getHeight());
                break;
        }
        if (sub1canBeMade){recursiveSubspaceallocator(sub1,box);}
        if (sub2canBeMade){recursiveSubspaceallocator(sub2,box);}
        if (sub3canBeMade){recursiveSubspaceallocator(sub3,box);}
    }
    private boolean configureSubspaceHelper(Subspace subspace,int x, int y, int z, int l, int w, int h){
        if (l<=0 ||w<=0 || h<=0){return false;}
        subspace.getCoordinate().setCoordinate_x(x);
        subspace.getCoordinate().setCoordinate_y(y);
        subspace.getCoordinate().setCoordinate_z(z);
        subspace.setLength(l);
        subspace.setWidth(w);
        subspace.setHeight(h);
        return true;
    }
}
