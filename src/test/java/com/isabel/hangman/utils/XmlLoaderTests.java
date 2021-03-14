package com.isabel.hangman.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlLoaderTests {
    @Test
    void ShouldReadWordsFromXmlFile() {
        XmlLoader xmlLoader = new XmlLoader();
        List<String> expected = Arrays.asList("DELL", "DELIVER", "TECHNOLOGY", "CUSTOMER", "CLOUD",
                "COMPUTER", "SERVER", "ADVANCED", "STORAGE", "SOLLUTIONS", "COMMITMENT", "DIVERSITY",
                "ENGAGEMENT", "COMMUNITY", "MILESTONE");
        List<String> result = new ArrayList<>();
        try {
            result = xmlLoader.readWordsFromXml("classpath:hangman.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected, result);
    }

    @Test
    void ShouldThrowExceptionWhenExceptionToReadFile() {
        XmlLoader xmlLoader = new XmlLoader();
        assertThrows(Exception.class, () -> {
            xmlLoader.readWordsFromXml("classpath:teste.xml");
        });
    }
}
