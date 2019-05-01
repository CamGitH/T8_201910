package model.estructuras;

import java.util.Iterator;

/**
 * Abstract Data Type for a linked list of generic objects
 * agregar, agregarFin, getSize, delete, eliminarultimo
 * next, previous
 * @param <T>
 */
public class LinkedList<T> {

	private NodoLinkedList<T> primero;
	private NodoLinkedList<T> ultimo;
	private int tamano=0;

	public NodoLinkedList<T> darPrimero(){
		return primero;
	}

	public NodoLinkedList<T> darUltimo(){
		return ultimo;
	}

	public LinkedList()
	{
		primero = null;
		ultimo = null;
		tamano = 0;
	}

	public void agregarIni(T nuevo){
		NodoLinkedList<T> nodo = new NodoLinkedList<T>(nuevo, tamano);
		if(tamano==0){
			primero= nodo;
			ultimo= nodo;
			tamano ++;
		}
		else{
			nodo.cambiarSiguiente(primero);
			primero=nodo;
			primero.darSiguiente().cambiarAnterior(primero);
			tamano ++;
		}
	}

	/*
	 * agrega al final
	 */
	public void add(T nuevo){
		NodoLinkedList<T> nodo = new NodoLinkedList<T>(nuevo, tamano);
		if(tamano==0){

			primero= nodo;
			ultimo= nodo;
			tamano ++;
		}
		else{
			ultimo.cambiarSiguiente(nodo);
			nodo.cambiarAnterior(ultimo);
			ultimo=nodo;
			
			tamano ++;
		}
	}


	public Iterator<T> iterator() {
		return null;
	}

	public Integer getSize() {
		return tamano;
	}

	public void eliminarUltimo() throws Exception{
		if (tamano==0){
			throw new Exception("La lista no existe");
		}
		else if(tamano==1){
			primero=null;
			ultimo=null;
		}
		else{
			ultimo.darAnterior().cambiarSiguiente(null);
			ultimo= ultimo.darAnterior();
			tamano --;
		}
	}

	public void eliminarPrimero() throws Exception{
		if (tamano==0){
			throw new Exception("La lista no existe");
		}
		else if(tamano==1){
			primero=null;
			ultimo=null;
		}
		else{
			((NodoLinkedList<T>) primero).darSiguiente().cambiarAnterior(null);
			primero=primero.darSiguiente();
			tamano --;
		}
	}
	
	/*
	 * busca por tamano
	 */
	public NodoLinkedList<T> get(int busc){
		NodoLinkedList<T> ret = primero;
		for(int i=0;i<tamano ;i++){
			if (ret.darPos()==busc){
				return ret;
			}else{
				ret=ret.darSiguiente();
			}
		}
		return null;
	}
}
