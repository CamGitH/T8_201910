package controller;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import model.estructuras.ArregloDinamico;
import model.estructuras.Graph;
import model.estructuras.NodoLinkedList;
import model.estructuras.Queue;
import model.estructuras.Vertecss;
import model.estructuras.Vertice;

import java.util.*;
import java.io.*;

//Basado en:
//https://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html


public class Prueba extends DefaultHandler {

	private LinkedList<Vertecss> listaVertices = new LinkedList<Vertecss>();

	private LinkedList<Queue> listaArcos  = new LinkedList<Queue>();

	private Queue<Long> cola = new Queue<Long>();

	private Graph grafo = new Graph<>();

	private int v;

	private int e;

	public Prueba() {
		super();
	}

	public void cargarTodo() throws Exception{
		String filename = "./data/Central-WashingtonDC-OpenStreetMap.xml";

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);

		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(new Prueba());
		xmlReader.parse(filename);
	}

	boolean sirve;
	public void startDocument() throws SAXException {
		sirve = false;
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		if(qName.equals("nd")){
			long x = Long.parseLong(atts.getValue(0));
			cola.enqueue(x);
		}

			if(qName.equals("tag")&&atts.getValue(0).equals("highway")){
				emptyStack();
			}
		
		if(qName.equals("node")){
			Vertecss vertice = new Vertecss(Double.parseDouble(atts.getValue(1)), Double.parseDouble(atts.getValue(2)), Long.parseLong(atts.getValue(0)));
			listaVertices.add(vertice);
		}
	}

	public void emptyStack(){
		if(!cola.isEmpty()){
			listaArcos.add(cola);
			for(int i = 0; i<cola.size();i++){
				long d = cola.dequeue();
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
//		if(sirve){
//			if(!cola.isEmpty()){
//				listaArcos.add(cola);
//				for(int i = 0; i<cola.size();i++){
//					cola.dequeue();
//				}
//			}
//		}
//		sirve = false;
	}

	public void endDocument() throws SAXException {

		try {
			creaVertices();
			creaArcos();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void creaVertices() throws Exception{
		for(int i = 0; i<listaVertices.size();i++){
			//System.out.println("#1::"+i);
			grafo.addVertex(listaVertices.get(i).getId(), listaVertices.get(i));
		}
	}

	public <A, K, V> void creaArcos() throws Exception{
		long primero = 0;
		long segundo = 0;
		int c = 0;
		for(int i =0; i<listaArcos.size();i++){
			System.out.println("#2:"+i);
			Queue<Long> cola = listaArcos.get(i);
			c+= cola.size();
			if(!cola.isEmpty()){
				primero =  cola.dequeue();
				while(!cola.isEmpty()){

					segundo = cola.dequeue();

					if(segundo!=0){
						grafo.addEdge(primero, segundo, 1);
					}
					primero = segundo;
					if(!cola.isEmpty()){
						segundo = cola.dequeue();
					}
				}
			}
		}
		System.out.println("c"+c);
		System.out.println(grafo.darListaArcos().size());
	}

	public <K, V, A> Graph<Long, Double, Double> crearGrafo() throws Exception{
		return grafo;
	}
}