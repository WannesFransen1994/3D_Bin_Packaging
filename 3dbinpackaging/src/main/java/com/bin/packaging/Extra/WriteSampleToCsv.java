package com.bin.packaging.Extra;

import com.bin.packaging.Model.BasicAlgorithm;
import com.bin.packaging.Model.Container;
import com.bin.packaging.Model.Coordinate;
import com.bin.packaging.Model.OnlyTwoTypes;
import com.bin.packaging.PackagingFacade;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Wannes Fransen.
 * Configured by Sarah de Wilde.
 */
class WriteSampleToCsv {

    public static void main(String[] args) {
        PackagingFacade f = new PackagingFacade(new BasicAlgorithm(),new OnlyTwoTypes());
        List<Container> data = f.getMaxLoadedContainers(50,80,40,15);

        String fileName = "csvtest.csv";
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(new FileOutputStream(fileName, false));

        } catch(FileNotFoundException fnfe) {
            System.out.println("error opening file" + fileName);
            System.exit(0);
        }

        //getFitterSampleData -> array van containers
        int i = 1;
        String delim = ";";
        String newLine = "\n";


        for (Container c: data
             ) {
            outputStream.append("Container " + i);
            outputStream.append(newLine);
            outputStream.append(String.valueOf(c.getLength()));
            outputStream.append(delim);
            outputStream.append(String.valueOf(c.getWidth()));
            outputStream.append(delim);
            outputStream.append(String.valueOf(c.getHeight()));
            outputStream.append(newLine);

            for (Coordinate coord : c.getItems().keySet()) {
                outputStream.append(String.valueOf(coord.getCoordinate_x()));
                outputStream.append(delim);
                outputStream.append(String.valueOf(coord.getCoordinate_y()));
                outputStream.append(delim);
                outputStream.append(String.valueOf(coord.getCoordinate_z()));
                outputStream.append(delim);
                outputStream.append(String.valueOf(c.getItems().get(coord).getLength()));
                outputStream.append(delim);
                outputStream.append(String.valueOf(c.getItems().get(coord).getWidth()));
                outputStream.append(delim);
                outputStream.append(String.valueOf(c.getItems().get(coord).getHeight()));

                outputStream.append(newLine);
            }
            outputStream.append(newLine);
            i++;
        }
        outputStream.close();
    }
}
