package com.bin.packaging.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wannes Fransen.
 * Algorithm explained by Bram Vanderbruggen.
 */
public class TertiaryTreeAlgorithm extends AlgorithmCommonMethods {
    private Box container;
    private int amount;
    private List<Subspace> unused;

    @Override
    public Box fillContainer(Box container, Column samplebox, int amount) {
        this.unused = new ArrayList<>();
        this.container = container;
        this.amount = amount;
        recursiveSubspaceallocator(VolumeObjectFactory.createSubspace(container), samplebox);
        List<Subspace> templist = new ArrayList<>(calculateCombinedSubspaceZAxis(unused));
        for (Subspace s : templist) {
            recursiveSubspaceallocator(s, samplebox);
        }
        templist = new ArrayList<>(calculateCombinedSubspaceYAxis(unused));
        for (Subspace s : templist) {
            recursiveSubspaceallocator(s, samplebox);
        }
        templist = new ArrayList<>(calculateCombinedSubspaceXAxis(unused));
        for (Subspace s : templist) {
            recursiveSubspaceallocator(s, samplebox);
        }

        return VolumeObjectFactory.createContainer(container);
    }

    private void recursiveSubspaceallocator(Subspace subspace, Column box) {
        box = calculateLowestSetup(subspace, box);
        if (box.getLength() <= subspace.getLength() && box.getWidth() <= subspace.getWidth() &&
                box.getHeight() <= subspace.getHeight() && amount > 0) {
            amount--;
            container.addItem(
                    LocationFactory.createCoordinate(
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z()),
                    VolumeObjectFactory.createBox(box.getLength(), box.getWidth(), box.getHeight()));
            allocateNewSubspaces(subspace, box, longestSideHelperFunction(subspace));
        } else {
            unused.add(subspace);
        }
    }

    private void allocateNewSubspaces(Subspace subspace, Column box, String[] longestFirst) {
        Subspace sub1 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0, 0, 0),
                subspace.getLength(), subspace.getWidth(), subspace.getHeight());
        Subspace sub2 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0, 0, 0),
                subspace.getLength(), subspace.getWidth(), subspace.getHeight());
        Subspace sub3 = VolumeObjectFactory.createSubspace(
                LocationFactory.createCoordinate(0, 0, 0),
                subspace.getLength(), subspace.getWidth(), subspace.getHeight());

        boolean sub1canBeMade = true, sub2canBeMade = true, sub3canBeMade = true;

        switch (longestFirst[0]) {
            case "length":
                if (longestFirst[1].equals("width")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z() + box.getHeight(),
                            box.getLength(),
                            box.getWidth(),
                            subspace.getHeight() - box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y() + box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth() - box.getWidth(),
                            subspace.getHeight());
                } else {
                    //good job, this part works (this method call at least)
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y() + box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth() - box.getWidth(),
                            box.getHeight());
                    //good job, this part works (this method call at least)
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z() + box.getHeight(),
                            box.getLength(),
                            subspace.getWidth(),
                            subspace.getHeight() - box.getHeight());
                }
                sub3canBeMade = configureSubspaceHelper(
                        sub3,
                        subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_z(),
                        subspace.getLength() - box.getLength(),
                        subspace.getWidth(),
                        subspace.getHeight());
                break;
            case "width":
                if (longestFirst[1].equals("length")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z() + box.getHeight(),
                            box.getLength(),
                            box.getWidth(),
                            subspace.getHeight() - box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength() - box.getLength(),
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
                            subspace.getHeight() - box.getHeight());

                }
                sub3canBeMade = configureSubspaceHelper(
                        sub3,
                        subspace.getCoordinate().getCoordinate_x(),
                        subspace.getCoordinate().getCoordinate_y() + box.getWidth(),
                        subspace.getCoordinate().getCoordinate_z(),
                        subspace.getLength(),
                        subspace.getWidth() - box.getWidth(),
                        subspace.getHeight());

                break;

            case "height":
                if (longestFirst[1].equals("length")) {
                    sub1canBeMade = configureSubspaceHelper(
                            sub1,
                            subspace.getCoordinate().getCoordinate_x(),
                            subspace.getCoordinate().getCoordinate_y() + box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            box.getLength(),
                            subspace.getWidth() - box.getWidth(),
                            box.getHeight());
                    sub2canBeMade = configureSubspaceHelper(
                            sub2,
                            subspace.getCoordinate().getCoordinate_x() + box.getLength(),
                            subspace.getCoordinate().getCoordinate_y(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength() - box.getLength(),
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
                            subspace.getCoordinate().getCoordinate_y() + box.getWidth(),
                            subspace.getCoordinate().getCoordinate_z(),
                            subspace.getLength(),
                            subspace.getWidth() - box.getWidth(),
                            box.getHeight());
                }
                sub3canBeMade = configureSubspaceHelper(
                        sub3,
                        subspace.getCoordinate().getCoordinate_x(),
                        subspace.getCoordinate().getCoordinate_y(),
                        subspace.getCoordinate().getCoordinate_z() + box.getHeight(),
                        subspace.getLength(),
                        subspace.getWidth(),
                        subspace.getHeight() - box.getHeight());
                break;
        }
        if (sub1canBeMade) {
            recursiveSubspaceallocator(sub1, box);
        }
        if (sub2canBeMade) {
            recursiveSubspaceallocator(sub2, box);
        }
        if (sub3canBeMade) {
            recursiveSubspaceallocator(sub3, box);
        }
    }

    private boolean configureSubspaceHelper(Subspace subspace, int x, int y, int z, int l, int w, int h) {
        if (l <= 0 || w <= 0 || h <= 0) {
            return false;
        }
        subspace.getCoordinate().setCoordinate_x(x);
        subspace.getCoordinate().setCoordinate_y(y);
        subspace.getCoordinate().setCoordinate_z(z);
        subspace.setLength(l);
        subspace.setWidth(w);
        subspace.setHeight(h);
        return true;
    }

    private List<Subspace> calculateCombinedSubspaceZAxis(List<Subspace> subspaces) {
        List<Subspace> newlist = new ArrayList<>();
        for (int i = subspaces.size() - 1; i >= 0; i--) {
            if (subspaces.get(i).getCoordinate().getCoordinate_z() == 0) {
                newlist.add(subspaces.get(i));
                subspaces.remove(i);
            }
        }
        for (Subspace expandableSubspace : newlist) {
            for (int i = subspaces.size() - 1; i >= 0; i--) {
                if (comparisonHelperFunction(expandableSubspace, subspaces.get(i), "Z")) {
                    expandableSubspace.setHeight(expandableSubspace.getHeight() + subspaces.get(i).getHeight());
                    subspaces.remove(i);
                    i = subspaces.size() - 1;
                }
            }
        }
        if (newlist.size() != 0) {
            unused = subspaces;
            return newlist;
        }
        return subspaces;
    }

    private List<Subspace> calculateCombinedSubspaceYAxis(List<Subspace> subspaces) {
        List<Subspace> newlist = new ArrayList<>();
        for (int i = subspaces.size() - 1; i >= 0; i--) {
            if (subspaces.get(i).getCoordinate().getCoordinate_y() == 0) {
                newlist.add(subspaces.get(i));
                subspaces.remove(i);
            }
        }
        for (Subspace expandableSubspace : newlist) {
            for (int i = subspaces.size() - 1; i >= 0; i--) {
                if (comparisonHelperFunction(expandableSubspace, subspaces.get(i), "Y")) {
                    expandableSubspace.setWidth(expandableSubspace.getWidth() + subspaces.get(i).getWidth());
                    subspaces.remove(i);
                    i = subspaces.size() - 1;
                }
            }
        }
        if (newlist.size() != 0) {
            unused = subspaces;
            return newlist;
        }
        return subspaces;
    }

    private List<Subspace> calculateCombinedSubspaceXAxis(List<Subspace> subspaces) {
        //The elements in the list "subspacesThatWillExpand" will.. expand, first in the Z axis, then Y axis, then X axis
        List<Subspace> newlist = new ArrayList<>();
        for (int i = subspaces.size() - 1; i >= 0; i--) {
            if (subspaces.get(i).getCoordinate().getCoordinate_x() == 0) {
                newlist.add(subspaces.get(i));
                subspaces.remove(i);
            }
        }
        for (Subspace expandableSubspace : newlist) {
            for (int i = subspaces.size() - 1; i >= 0; i--) {
                if (comparisonHelperFunction(expandableSubspace, subspaces.get(i), "X")) {
                    expandableSubspace.setLength(expandableSubspace.getLength() + subspaces.get(i).getLength());
                    subspaces.remove(i);
                    i = subspaces.size() - 1;
                }
            }
        }
        if (newlist.size() != 0) {
            unused = subspaces;
            return newlist;
        }
        return subspaces;
    }

    private boolean comparisonHelperFunction(Subspace expandable, Subspace remainder, String axis) {
        switch (axis) {
            case "X":
                if (expandable.getCoordinate().getCoordinate_z() == remainder.getCoordinate().getCoordinate_z()
                        && expandable.getCoordinate().getCoordinate_y() == remainder.getCoordinate().getCoordinate_y()
                        && (expandable.getCoordinate().getCoordinate_x() + expandable.getLength()) == remainder.getCoordinate().getCoordinate_x()) {
                    return true;
                }
                break;
            case "Z":
                if (expandable.getCoordinate().getCoordinate_x() == remainder.getCoordinate().getCoordinate_x()
                        && expandable.getCoordinate().getCoordinate_y() == remainder.getCoordinate().getCoordinate_y()
                        && (expandable.getCoordinate().getCoordinate_z() + expandable.getHeight()) == remainder.getCoordinate().getCoordinate_z()) {
                    return true;
                }
                break;
            case "Y":
                if (expandable.getCoordinate().getCoordinate_x() == remainder.getCoordinate().getCoordinate_x()
                        && expandable.getCoordinate().getCoordinate_z() == remainder.getCoordinate().getCoordinate_z()
                        && (expandable.getCoordinate().getCoordinate_y() + expandable.getWidth()) == remainder.getCoordinate().getCoordinate_y()) {
                    return true;
                }
                break;
        }
        return false;
    }

}
