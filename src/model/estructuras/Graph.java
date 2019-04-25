package model.estructuras;
import java.awt.List;
import java.io.Serializable;

import java.util.Iterator;

public class Graph<K,V,A> implements IGraph<K, V, A> {

	private Vertice<K, V> raiz;
	//numero de vertices 
	int v;
	//numero de arcos
	int e;
	
	/*
	 * constructor
	 */
	public void graph() {
		v =0;
		e =0;
	}

	/*
	 * retorna el numero de vertices
	 */
	public int V() {
		return v;
	}

	/*
	 * retorna el numero de arcos
	 */
	public int E() {
		return e;
	}

	/*
	 * Adiciona un v�rtice con un Id �nico.
	 * El v�rtice tiene la informaci�n InfoVertex
	 */
	public void addVertex(K idVertex, V infoVertex) {
		Vertice<K, V> a = new Vertice<>();
		a.vertice(infoVertex, idVertex);
		v++;		
	}

	/*
	 * Adiciona el arco No dirigido entre el vertice IdVertexIni y 
	 * el vertice IdVertexFin. El arco tiene la informaci�n infoArc
	 */
	public void addEdge(K idVertexIni, K idVertexFin, A infoArc) {
		Vertice<K, V> K
		Arco<K, V, A> a = new Arco<Graph.K, Graph.V, Graph.A>(pOrigen, pDestino, pInfoArco)
		
	}

	public Vertice<K, V> getV (Vertice<K, V> x){
		int cont =0;
		while (cont!=v){
			raiz.
		}	
		return null;
	}
	
	/*
	 * Obtener la informaci�n de un v�rtice
	 */
	public V getInfoVertex(K idVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Modificar la informaci�n del v�rtice 
	 */
	public void setInfoVertex(K idVertex, V infoVertex) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Obtener la informaci�n de un arco
	 */
	public A getInfoArc(K idVertexIni, K idVertexFin) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *Modificar la informaci�n del arco entre los v�rtices idVertexIni e idVertexFin 
	 */
	public void setInfoArc(K idVertexIni, K idVertexFin, A infoArc) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Retorna los identificadores de los v�rtices adyacentes a idVertex
	 */
	public Iterator<K> adj(K idVertex) {
		// TODO Auto-generated method stub
		return null;
	}


}

