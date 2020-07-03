package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWorldAnalyzer {

    final String PATH = "/home/silviu/Documents/Codecool/oop_module/SI5/filepartreader-testing-with-junit" +
            "-silviurdr/src/main/java/com/codecool/resources/example.txt";


    FilePartReader fpr = new FilePartReader();

    public FileWorldAnalyzer(FilePartReader fpr) {

    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> wordsSortedAlph = new ArrayList(Arrays.asList(fpr.readLines(PATH, 1, 1).split(" ")));
        wordsSortedAlph.sort(String::compareToIgnoreCase);
        return wordsSortedAlph;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> selectedWordsList = new ArrayList(Arrays.asList(fpr.readLines(PATH, 3, 3).split(" ")));
        List<String> wordsSubstring = selectedWordsList.stream()
                .filter(w -> w.contains(subString))
                .collect(Collectors.toList());
        return wordsSubstring;
    }

    public List<String> getStringWhichPalindromes() throws IOException {
        List<String> selectedLine = new ArrayList(Arrays.asList(fpr.readLines(PATH, 2, 3).split(" ")));
        List<String> wordsPalindrome = selectedLine.stream()
                .filter(w -> w.length() > 1)
                .filter(w -> w.equals(new StringBuilder().append(w).reverse().toString()))
                .collect(Collectors.toList());
        return wordsPalindrome;
    }

}
