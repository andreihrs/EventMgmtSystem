package com.fmi.project.services;

import com.fmi.project.client.Individual;

import java.io.*;

public class FileTextServiceIndividual {
    private static FileTextServiceIndividual ourInstance = new FileTextServiceIndividual();

    private FileTextServiceIndividual() {
    }

    public static FileTextServiceIndividual getInstance() {
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
    public Individual readIndividualFromFile(String fileNamePath) {
        Individual individual = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            individual = new Individual(Boolean.parseBoolean(values[0]), Boolean.parseBoolean(values[1]),
                    Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), values[4], Integer.parseInt(values[5]),
                    Integer.parseInt(values[6]), Integer.parseInt(values[7]));
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return individual;
    }
}