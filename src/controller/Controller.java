package controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.channels.GatheringByteChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import model.data_structures.HashTableLinearProbing;
import model.data_structures.HashTableSepareteChaning;
import model.vo.VOMovingViolation;
import view.DatasetsManagerView;
import view.View;

public class Controller {


	private HashTableLinearProbing tablaLineal;
	private HashTableSepareteChaning tablaChaning;

	private HashTableLinearProbing tablaLinealMuestra;
	private HashTableSepareteChaning tablaChaningMuestra;
	private View view;

	public Controller() {

		view = new View();

		tablaLineal = new HashTableLinearProbing<>();
		tablaLineal.MetodoConstructor(10);
		tablaChaning = new HashTableSepareteChaning<>();
		tablaChaning.MetodoConstructor(10);

		tablaLinealMuestra = new HashTableLinearProbing<>();
		tablaLinealMuestra.MetodoConstructor(10);
		tablaChaningMuestra = new HashTableSepareteChaning<>();
		tablaChaningMuestra.MetodoConstructor(10);
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

				controller.loadMovingViolations();
				break;

			case 1:
				view.printMessage("Introduzca la direccion a buscar");
				String direccion = sc.nextLine();
				view.printMessage(controller.buscarPorDireccionLinear(direccion));

			case 2:
				view.printMessage("Introduzca la direccion a buscar");
				String direccion2 = sc.nextLine();
				view.printMessage(controller.buscarPorDireccionChaning(direccion2));

			case 3:	
				fin=true;
				sc.close();
				break;
			}
		}

	}

	/**
	 * Dado una dirección mostrar todas las infracciones que terminaron en accidente 
	 * en esa direccion. El resultado debe estar ordenado cronológicamente.
	 * @param direccion2 Address buscado (String)
	 * @return De cada infracción se debe mostrar: OBJECTID, LOCATION, TICKETISSUEDATE, VIOLATIONCODE y FINEAMT

	 */
	private String buscarPorDireccionChaning(String direccion) {
		VOMovingViolation[] violaciones = (VOMovingViolation[]) tablaChaning.get(direccion);
		String mensaje = "";
		for(int i = 0;i<violaciones.length;i++){
			mensaje += violaciones[i].ToString() +"\n";
		}
			return mensaje;
	}

	/**
	 * Dado una dirección mostrar todas las infracciones que terminaron en accidente 
	 * en esa direccion. El resultado debe estar ordenado cronológicamente.
	 * @param direccion Address buscado (String)
	 * @return De cada infracción se debe mostrar: OBJECTID, LOCATION, TICKETISSUEDATE, VIOLATIONCODE y FINEAMT
	 */
	private String buscarPorDireccionLinear(String direccion) {
		VOMovingViolation[] violaciones = (VOMovingViolation[]) tablaLineal.get(direccion);
		String mensaje = "";
		for(int i = 0;i<violaciones.length;i++){
			mensaje += violaciones[i].ToString() +"\n";
		}
			return mensaje;
	}

	public void generarMuestra(int n){
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_January_2018.json"));
			readFiles(gson, reader);

			VOMovingViolation[] lista = gson.fromJson(reader, VOMovingViolation[].class);
			for(int i = 0; i<n;i++){
				tablaLinealMuestra.put(lista[i].getAddressID(), lista[i]);
				tablaChaningMuestra.put(lista[i].getAddressID(), lista[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}



	}

	public HashTableLinearProbing getTablaLinealMuestra() {
		return tablaLinealMuestra;
	}


	public HashTableSepareteChaning getTablaChaningMuestra() {
		return tablaChaningMuestra;
	}

	public void loadMovingViolations() {
		Gson gson = new Gson();
		JsonReader reader;

		try {

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_January_2018.json"));
			readFiles(gson, reader);

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_February_2018.json"));
			readFiles(gson, reader);

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_March_2018.json"));
			readFiles(gson, reader);

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_April_2018.json"));
			readFiles(gson, reader);

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_May_2018.json"));
			readFiles(gson, reader);

			reader = new JsonReader(new FileReader("./data/Moving_Violations_Issued_in_June_2018.json"));
			readFiles(gson, reader);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void readFiles(Gson pGson, JsonReader pReader){
		VOMovingViolation[] lista = pGson.fromJson(pReader, VOMovingViolation[].class);
		System.out.println(lista.length);
		for(int i = 0; i<lista.length;i++){
			if(lista[i].getAddressID()==null){
				continue;
			}
			else if(lista[i].getAccidentIndicator().equals("Yes")){

				tablaLineal.put(lista[i].getAddressID(), lista[i]);
				tablaChaning.put(lista[i].getAddressID(), lista[i]);
				while(i<10000){
					tablaChaningMuestra.put(lista[i].getAddressID(), lista[i]);
					tablaLinealMuestra.put(lista[i].getAddressID(), lista[i]);
				}

			}
		}
		System.out.println(tablaLineal.size());
		System.out.println(tablaChaning.size());
		System.out.println("-------------------");
	}
}





