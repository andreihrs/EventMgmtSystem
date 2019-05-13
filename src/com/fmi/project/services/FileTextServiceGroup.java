package com.fmi.project.services;

import com.fmi.project.client.Group;

import java.io.*;

public class FileTextServiceGroup {
    private static FileTextServiceGroup ourInstance = new FileTextServiceGroup();

    private FileTextServiceGroup() {
    }

    public static FileTextServiceGroup getInstance() {
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
    public Group readGroupFromFile(String fileNamePath) {
        Group group = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            group = new Group(Boolean.parseBoolean(values[0]), Boolean.parseBoolean(values[1]),
                    Integer.parseInt(values[2]), Boolean.parseBoolean(values[3]), values[4], Integer.parseInt(values[5]),
                    Boolean.parseBoolean(values[6]), Boolean.parseBoolean(values[7]));
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return group;
    }
}