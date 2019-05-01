package controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import model.estructuras.Graph;
import view.View;

public class Controller {



	private View view;

	private Graph grafo;

	private Prueba prueba;

	public Controller() {

		view = new View();
		prueba = new Prueba();

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
				System.out.println("Numero de arcos = "+ grafo.darListaArcos().getSize());
				System.out.println("Numero de vertices = "+grafo.darListaNodos().getSize());
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


	//	public void loadMovingViolations() {
	//		Gson gson = new Gson();
	//		JsonReader reader;
	//
	//		try {
	//
	//			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_January_2018.json"));
	//			readFiles(gson, reader);
	//
	//
	//		} catch (FileNotFoundException e) {
	//			e.printStackTrace();
	//		}
	//
	//	}

	//	private void readFiles(Gson pGson, JsonReader pReader){
	//		VOMovingViolation[] lista = pGson.fromJson(pReader, VOMovingViolation[].class);
	//		System.out.println(lista.length);
	//		for(int i = 0; i<lista.length;i++){
	//			if(lista[i].getAddressID()==null){
	//				continue;
	//			}
	//			else if(lista[i].getAccidentIndicator().equals("Yes")){
	//
	//				tablaLineal.put(lista[i].getAddressID(), lista[i]);
	//				tablaChaning.put(lista[i].getAddressID(), lista[i]);
	//				while(i<10000){
	//					tablaChaningMuestra.put(lista[i].getAddressID(), lista[i]);
	//					tablaLinealMuestra.put(lista[i].getAddressID(), lista[i]);
	//				}
	//
	//			}
	//		}
	//		System.out.println("-------------------");
	//	}
}





