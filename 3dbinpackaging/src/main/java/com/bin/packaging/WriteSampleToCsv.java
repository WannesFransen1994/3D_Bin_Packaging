package com.bin.packaging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by erowan on 01/04/2017.
 */
public class WriteSampleToCsv {

    public static void main(String[] args) {
        PackagingFacade f = new PackagingFacade();
        List<Container> data = f.getMaxLoadedContainers(20,40,25,50);

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
