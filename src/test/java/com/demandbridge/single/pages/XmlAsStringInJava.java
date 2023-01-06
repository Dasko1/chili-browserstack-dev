package com.demandbridge.single.pages;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class XmlAsStringInJava {

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {

        // Our XML file for this example
        File xmlFile = new File("00-X0045J-1.xml");
        // File xmlFile1 = new File("00-X00248-2_doc_highres.pdf");

        // Let's get XML file as String using BufferedReader FileReader uses platform's default character encoding
        // if you need to specify a different encoding, use InputStreamReader
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null){
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xml2String = sb.toString();
        System.out.println("XML to String using BufferedReader : ");
        System.out.println(xml2String);

        bufReader.close();
    }
}

