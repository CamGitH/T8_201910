package model.estructuras;

public class Vertice<K, V> {

	private K id;
	private V infoVertice;
	boolean marcado;
	int numeroArcos =0;
	
	public void vertice( V pInfoVertice, K pId)
	{
	id = pId;
	numeroArcos=0;
	infoVertice = pInfoVertice;
	marcado = false;
	}
	
	public K darID(){
		return id;
	}
	
	public V darInfo(){
		return infoVertice;
	}
	
	public void cambiarInfo(V pInf){
		infoVertice = pInf;
	}
	
	public int darNumeroArcos(){
		return numeroArcos;
	}
	
	public boolean estaMarcado(){
		return marcado;
	}
	
	public void marcar(){
		marcado=true;
	}
	
	public void desMarcar(){
		marcado=false;
	}
}
