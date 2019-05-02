package controller;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import model.estructuras.ArregloDinamico;
import model.estructuras.Grafox;
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

	public void startDocument() throws SAXException {

	}

	boolean sirve;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		if(qName.equals("nd")){
			long x = Long.parseLong(atts.getValue(0));
			cola.enqueue(x);
		}
		if(qName.equals("tag")&&atts.getValue(0).equals("highway")){
			sirve = true;
		}

		if(qName.equals("node")){
			Vertecss vertice = new Vertecss(Double.parseDouble(atts.getValue(1)), Double.parseDouble(atts.getValue(2)), Long.parseLong(atts.getValue(0)));
			listaVertices.add(vertice);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(sirve){
			listaArcos.add(cola);
			for(int i = 0; i<cola.size();i++){
				cola.dequeue();
			}
		}
		sirve = false;
	}

	public void endDocument() throws SAXException {
		System.out.println("Arcos"+listaArcos.size());
		System.out.println("Vertices"+listaVertices.size()+"\n");
		//		System.out.println(listaVertices.getLast().getId());
		//		System.out.println(listaVertices.getLast().getLatitud());
		//		System.out.println(listaVertices.getLast().getLongitud()+"\n");
		//		System.out.println(listaArcos.getFirst().darElemento(0));

	}

	public void creaVertices() throws Exception{
		for(int i = 0; i<listaVertices.size();i++){
			grafo.addVertex(listaVertices.get(i).getId(), listaVertices.get(i).getLatitud(), listaVertices.get(i).getLongitud());
		}

	}

	public <A, K, V> void creaArcos() throws Exception{
		long primero = 0;
		long segundo = 0;
		for(int i =0; i<listaArcos.size();i++){
			Queue<Long> cola = listaArcos.get(i);
			primero =  cola.dequeue();
			while(!cola.isEmpty()){
				
				segundo = cola.dequeue();
				
				if(primero!=0 && segundo!=0){
					grafo.addEdge(primero, segundo, 1);
				}
				primero = segundo;
				if(!cola.isEmpty()){
					segundo = cola.dequeue();
				}
			}
		}
	}

	public <K, V, A> Graph<Long, Double, Double> crearGrafo() throws Exception{
		creaVertices();
		creaArcos();
		System.out.println(grafo.darListaArcos().size());
		System.out.println(grafo.darListaNodos().size());
		return grafo;
	}
}