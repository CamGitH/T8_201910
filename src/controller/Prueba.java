package controller;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

//Basado en:
//https://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html

public class Prueba extends DefaultHandler {

	private Hashtable tags;

	static public void main(String[] args) throws Exception{
		String filename = "./data/Central-WashingtonDC-OpenStreetMap.xml";
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		    
		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new Prueba());
		xmlReader.parse(filename);
	}

	
	public void startDocument() throws SAXException {
		tags = new Hashtable();
	}

	int v = 0;
	int a = 0;
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		String key = localName;
		Object value = tags.get(key);
		

		if (value == null) {
			tags.put(key, new Integer(1));
			
		} else {
			int count = ((Integer) value).intValue();
			count++;
			tags.put(key, new Integer(count));
		}
		
		boolean sirve = false;
		String s = "";
		if(key.equals("way")) {
			s.concat("IDway "+atts.getValue(0)+" Camino de nodos:");
		}
		
		if(qName.equals("nd")){
			s.concat(atts.getValue(0));
		}
		if(qName.equals("tag")&&atts.getValue(0).equals("highway")){
			a+=1;
			s.concat(atts.getValue(0)+"arco#"+a);
			sirve = true;
		}
		if(sirve){
			System.out.println(s);
		}
		if(qName.equals("node")){
			v+=1;
			System.out.println("vertice#"+v);
			System.out.println("ID "+atts.getValue(0));
			System.out.println("LAT "+atts.getValue(1));
			System.out.println("LON "+atts.getValue(2));
			
			//TODO Guardar el vertice
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
            throws SAXException {
		//System.out.println(localName);
	}

	public void endDocument() throws SAXException {
		Enumeration e = tags.keys();
		
		for(Object o: tags.keySet()) {
			String tag = (String) o;
			int count = ((Integer) tags.get(tag)).intValue();
			System.out.println("Local Name \"" + tag + "\" occurs " + count + " times");
		}
	}
}