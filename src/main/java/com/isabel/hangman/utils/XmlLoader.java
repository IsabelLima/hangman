package com.isabel.hangman.utils;

import com.isabel.hangman.entity.Word;
import com.isabel.hangman.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Component
public class XmlLoader implements ApplicationRunner {

    @Autowired
    private WordRepository wordRepository;

    public List<String> readWordsFromXml(String filePath) throws IOException, SAXException, ParserConfigurationException {
        List<String> result = new ArrayList<>();
        try {
            InputStream inputStream = new ClassPathResource(filePath).getInputStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName("word");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                result.add(node.getFirstChild().getTextContent());
            }
        } catch (Exception e) {
            throw  e;
        }
        return  result;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> words = this.readWordsFromXml("hangman.xml");
        for (String word: words) {
            Word wordObject = new Word();
            wordObject.setWord(word);
            wordRepository.save(wordObject);
        }
    }
}
