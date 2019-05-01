package model.estructuras;

/*
 *Clase del nodo
 */
public class Nodo<T> {

	private T elemento;

	private Nodo<T> anterior;

	private Nodo<T> siguiente;

	public Nodo( T pElemento )
	{
		elemento = pElemento;
		anterior = null;
		siguiente = null;

	}

	public T darElemento( )
	{
		return elemento;
	}
	
	public Nodo<T> darAnterior(){
		return anterior;
	}
	
	public Nodo<T> darSiguiente(){
		return siguiente;
	}
	
	public void cambiarAnterior(Nodo<T> ultimo){
		anterior =  ultimo;
	}
	
	public void cambiarSiguiente(Nodo<T> n){
		siguiente =  n;
	}
	
}