package com.fmi.project.services;

import com.fmi.project.client.Agency;

import java.io.*;

public class FileTextServiceAgency {
    private static FileTextServiceAgency ourInstance = new FileTextServiceAgency();

    private FileTextServiceAgency() {
    }

    public static FileTextServiceAgency getInstance() {
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
    public Agency readAgencyFromFile(String fileNamePath) {
        Agency agency = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            int nr = 0;
            try {
                nr = Integer.parseInt(values[2].trim());
            } catch (NumberFormatException exc) {
                exc.printStackTrace();
            }
            agency = new Agency(Boolean.parseBoolean(values[0]), Boolean.parseBoolean(values[1]),
                    nr, Boolean.parseBoolean(values[3]), values[4], Integer.parseInt(values[5]),
                    Boolean.parseBoolean(values[6]), Integer.parseInt(values[7]), values[8]);
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agency;
    }
}