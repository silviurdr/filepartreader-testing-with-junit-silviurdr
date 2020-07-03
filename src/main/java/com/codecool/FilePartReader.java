package com.codecool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -34;
        this.toLine = -100;
    }


    public Integer getFromLine() {
        return fromLine;
    }


    public Integer getToLine() {
        return toLine;
    }


    public String getFilePath() {
        return filePath;
    }

    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("From line should always be bigger the to line!");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read(String filePath) throws IOException {

        List<String> fileWords = new ArrayList<String>();

        File file = new File(filePath.trim());
        file.setReadable(true);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            fileWords.add(line);
        }

        String stringRead = fileWords.stream()
                .collect(Collectors.joining("\n"));

        return stringRead;
    }

    public String readLines(String filePath, int fromLine, int toLine) throws IOException {

        String requestedLines;
        Stream<String> stream = Files.lines(Paths.get(filePath));
        requestedLines = stream
                .skip(fromLine - 1)
                .limit(toLine - fromLine + 1)
                .collect(Collectors.joining("\n"));

        return requestedLines;
    }


}
