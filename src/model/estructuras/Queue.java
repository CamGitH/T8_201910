package model.estructuras;

import java.util.Iterator;

public class Queue<T>  {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int tamano=0;

	/**
	 * Retorna true si la Cola esta vacia
	 * @return true si la Cola esta vacia, false de lo contrario
	 */

	public Queue( )
	{
		primero = null;
		ultimo = null;
		tamano = 0;
	}

	public boolean isEmpty(){
		if (tamano==0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size(){
		return tamano;
	}

	/**
	 * Inserta un nuevo elemento en la Cola
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void enqueue(T t) {
		Nodo<T> n = new Nodo<T>(t);
		if(isEmpty()){
			primero=n;
			ultimo=n;
		}
		else{
			
			n.cambiarSiguiente(ultimo);
			ultimo.cambiarAnterior(n);
			ultimo=n;
			
		}
		tamano++;

	}
	/**
	 * Quita y retorna el elemento agregado menos recientemente
	 * @return el elemento agregado menos recientemente
	 */
	public T dequeue(){
		Nodo<T> ret = primero;

		if(size()==1){
			primero=null;
			ultimo=null;
		}
		else{
			primero=primero.darAnterior();
			primero.cambiarSiguiente(null);
			
		}
		tamano--;
		return ret.darElemento();
	}


	/**
	 * @return the primero
	 */
	public Nodo<T> getPrimero() {
		return primero;
	}

	/**
	 * @return the ultimo
	 */
	public Nodo<T> getUltimo() {
		return ultimo;
	}


}
