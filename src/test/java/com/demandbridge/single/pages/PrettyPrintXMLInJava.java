package com.demandbridge.single.pages;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;

public class PrettyPrintXMLInJava {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new FileInputStream("C:\\Users\\ADaskalopoulos\\Downloads\\00-X004JC-1.xml"));
        prettyPrint(doc);
    }

    public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out);

        FileWriter myWriter = new FileWriter("C:\\Users\\ADaskalopoulos\\Downloads\\00-X004JC-1.xml");
        myWriter.write(String.valueOf(out));
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
}

