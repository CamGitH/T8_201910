package model.estructuras;

/*
 *Clase del nodo
 */
public class NodoLinkedList<T> {

	private T elemento;

	private NodoLinkedList<T> anterior;

	private NodoLinkedList<T> siguiente;
	
	int pos;

	public NodoLinkedList( T pElemento, int ppos )
	{
		pos = ppos;
		elemento = pElemento;
		anterior = null;
		siguiente = null;

	}

	public T darElemento( )
	{
		return elemento;
	}
	
	public NodoLinkedList<T> darAnterior(){
		return anterior;
	}
	
	public NodoLinkedList<T> darSiguiente(){
		return siguiente;
	}
	
	public int darPos(){
		return pos;
	}
	
	public void cambiarAnterior(NodoLinkedList<T> ultimo){
		anterior =  ultimo;
	}
	
	public void cambiarSiguiente(NodoLinkedList<T> n){
		siguiente =  n;
	}
	
}