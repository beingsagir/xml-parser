package org.fancyfrog.xml_parser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

/**
 * Dom Operation
 * 
 * @author Sagiruddin Mondal
 * @since v1.0
 */
public class DomOperation {
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
        try {
        
        File fXmlFile = new File("d:\\input.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);
    			
    	doc.getDocumentElement().normalize();

    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    	NodeList nList = doc.getElementsByTagName("staff");
    	System.out.println("----------------------------");

    	for (int temp = 0; temp < nList.getLength(); temp++) {
    		Node nNode = nList.item(temp);    				
    		System.out.println("\nCurrent Element :" + nNode.getNodeName());   				
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			System.out.println("Staff id : " + eElement.getAttribute("id"));
    			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
    			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
    			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
    			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

    		}
    	}
        } catch (Exception e) {
    	e.printStackTrace();
        }
      }
    			
}

