package com.codecool;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilePartReaderTest {


    public FilePartReader fpr;
    final String PATH = "/home/silviu/Documents/Codecool/oop_module/SI5/filepartreader-testing-with-junit" +
            "-silviurdr/src/main/java/com/codecool/resources/example.txt";

    @BeforeEach
    public void before() {
        fpr = new FilePartReader();
    }


    @Nested
    @DisplayName("Testing if the arguments are of the correct type")
    class Arguments {

        @DisplayName("Path argument is a String?")
        @Test
        public void testIsPathArgumentString() {
            fpr.setup("something", 3, 4);
            Assert.assertTrue(fpr.getFilePath() instanceof String);
        }

        @DisplayName("fromLine argument is an Integer?")
        @Test
        public void testIsFromLineArgumentInteger() {
            fpr.setup("something", 5, 6);
            Assert.assertTrue(fpr.getFromLine() instanceof Integer);
        }

        @DisplayName("toLine argument is an Integer?")
        @Test
        public void testIsToLineArgumentInteger() {
            fpr.setup("something", 3, 6);
            Assert.assertTrue(fpr.getToLine() instanceof Integer);
        }
    }

    @DisplayName("Test if toLine argument is smaller than fromLine argument")
    @Test
    public void testIsToLineSmallerThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("somePath", 5, 3));
    }

    @DisplayName("Test if fromLine is smaller than one")
    @Test
    public void testIsFromLineSmallerThan1() {
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("somePath", 0, 4));
    }

    @DisplayName("Is the reader opening the file and showing its content as a String")
    @Test
    public void testFileRead() throws IOException {

        String actual = fpr.read(PATH);
        String expected = "Where are we going and\n" +
                "There is a high level of so much wow water in the noon here\n" +
                "You can flyog over that dog if he doesn't barkog\n" +
                "The glass was full earlier now it's only foolish\n";
        assertEquals(expected, actual);
    }

    @DisplayName("Is the reader returned a string with only the requested lines")
    @Test
    public void testFileReadLines() throws IOException {

        String actual = fpr.readLines(PATH, 1, 2);
        String expected = "Where are we going and\nThere is a high level of so much wow water in the noon here";
        assertEquals(expected, actual);
    }

}
