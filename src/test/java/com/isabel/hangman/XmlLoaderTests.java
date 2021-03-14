package com.isabel.hangman;

import com.isabel.hangman.utils.XmlLoader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlLoaderTests {
    @Test
    void ShouldReadWordsFromXmlFile() {
        XmlLoader xmlLoader = new XmlLoader();
        List<String> expected = Arrays.asList("DELL", "DELIVER", "TECHNOLOGY", "CUSTOMER", "CLOUD",
                "COMPUTER", "SERVER", "ADVANCED", "STORAGE", "SOLLUTIONS", "COMMITMENT", "DIVERSITY",
                "ENGAGEMENT", "COMMUNITY", "MILESTONE");
        List<String> result = xmlLoader.readWordsFromXml("classpath:hangman.xml");
        assertEquals(expected, result);
    }
}
