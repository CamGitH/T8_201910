package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import model.estructuras.Graph;
import model.estructuras.LinkedList;
import model.estructuras.Vertice;
import uniandes.cupi2.club.mundo.FacturaException;
import view.View;

public class Controller {

	private View view;

	private Graph grafo;

	private Prueba prueba;

	public Controller() {

		view = new View();
		prueba = new Prueba();
		grafo = new Graph();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		Controller controller = new Controller();

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 0:
				try {
					prueba.cargarTodo();
					grafo = prueba.crearGrafo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Numero de arcos = "+ grafo.darListaArcos().size());
				System.out.println("Numero de vertices = "+grafo.darListaNodos().size());
				break;

			case 1:
				view.printMessage("Introduzca la direccion a buscar");
				String direccion = sc.nextLine();
				//view.printMessage(controller.buscarPorDireccionLinear(direccion));

			case 2:
				view.printMessage("Introduzca la direccion a buscar");
				String direccion2 = sc.nextLine();
				//view.printMessage(controller.buscarPorDireccionChaning(direccion2));

			case 3:	
				fin=true;
				sc.close();
				break;
			}
		}

	}
	/**
	 * Se hace un text con el formato JSON, que luego se usa para leer el grafo cambiando .txt por .json
	 */
	public void hacerJson(){
		ArrayList<Vertice<Long, Object>> lista = new ArrayList<>();
		lista = grafo.darListaNodos();
		PrintWriter pw;
	
			File file = new File("./data/recibos", "grafo.txt");

			try {
				pw = new PrintWriter(file);
				pw.write("{");
				for (int i = 0; i < lista.size(); i++) {
					pw.write(lista.get(i).toString());
				}
				pw.write("}");
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}


//		public void loadGrafo() {
//			Gson gson = new Gson();
//			JsonReader reader;
//	
//			try {
//	
//				reader = new JsonReader(new FileReader("./grafo.json"));
//				readFiles(gson, reader);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//	
//		}

//		private void readFiles(Gson pGson, JsonReader pReader){
//			
//	
//			Vertice[] lista = pGson.fromJson(pReader, Vertice[].class);
//			System.out.println(lista.length);
//			for(int i = 0; i<lista.length;i++){
//				Vertice
//				grafo.addVertex(lista[i].darID(), lista[i].darInfo());
//			}
//			System.out.println("-------------------");
//			
//			
//		}
}





