package com.bin.packaging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by erowan on 01/04/2017.
 */
public class Test {

    public static void main(String[] args) {
        PackagingFacade f = new PackagingFacade();
        System.out.println(f.getFitterSampleData());

        String fileName = "csvtest.csv";
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(new FileOutputStream(fileName, true));

        } catch(FileNotFoundException fnfe) {
            System.out.println("error opening file" + fileName);
            System.exit(0);
        }

        //getFitterSampleData -> array van containers
        int i = 1;
        String delim = ";";
        String newLine = "\n";


        for (Container c: f.getFitterSampleData()
             ) {
            outputStream.append("Container " + i);
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
