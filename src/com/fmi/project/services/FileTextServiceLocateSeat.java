package com.fmi.project.services;

import com.fmi.project.location.LocateSeat;

import java.io.*;

public class FileTextServiceLocateSeat {
    private static FileTextServiceLocateSeat ourInstance = new FileTextServiceLocateSeat();

    private FileTextServiceLocateSeat() {
    }

    public static FileTextServiceLocateSeat getInstance() {
        return ourInstance;
    }

    public void writeTextToFile(String textToWrite, String fileNamePath) {

        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(fileNamePath));

            printWriter.println(textToWrite);

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileNamePath
     * @return
     */
    public LocateSeat readLocateSeatFromFile(String fileNamePath) {
        LocateSeat locateSeat = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            locateSeat = new LocateSeat(Boolean.parseBoolean(values[0]), values[1],
                    values[2], Boolean.parseBoolean(values[3]), values[4], Integer.parseInt(values[5]),
                    Boolean.parseBoolean(values[6]));
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locateSeat;
    }
}