package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWorldAnalyzerTest {

    FileWorldAnalyzer fwa;
    FilePartReader fpr;
    final String PATH = "/home/silviu/Documents/Codecool/oop_module/SI5/filepartreader-testing-with-junit" +
            "-silviurdr/src/main/java/com/codecool/resources/example.txt";

    @BeforeEach
    public void before() {
        fpr = new FilePartReader();
        fwa = new FileWorldAnalyzer(fpr);
    }

    @DisplayName("Is the analyzer displaying the words sorted alphabetically")
    @Test
    public void testIsGetWordsOrderedAlpabetically() throws IOException {
        List<String> expected = Arrays.asList("and", "are", "going", "we", "Where");
        List<String> actual = fwa.getWordsOrderedAlphabetically();
        assertEquals(expected, actual);
    }

    @DisplayName("Is the analyzer selecting only the words that contain the substring")
    @Test
    public void testIsGetWordsContainingSubstring() throws IOException {
        List<String> expected = Arrays.asList("flyog", "dog", "barkog");
        List<String> actual = fwa.getWordsContainingSubstring("og");
        assertEquals(expected, actual);
    }

    @DisplayName("Is the analyzer showing the palindrome words")
    @Test
    public void testIsGetStringWhichPalindromes() throws IOException {
        List<String> expected = Arrays.asList("level", "wow", "noon");
        List<String> actual = fwa.getStringWhichPalindromes();
        assertEquals(expected, actual);
    }

}
