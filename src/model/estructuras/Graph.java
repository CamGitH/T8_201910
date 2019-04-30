package model.estructuras;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph<K,V,A> implements IGraph<K, V, A> {

	private Vertice<K, V> raiz;
	//numero de vertices 
	int v;
	//numero de arcos
	int e;

	ArrayList<Vertice<K, V>> nodos = new ArrayList<>();

	ArrayList<Arco<K, K, A>> arcos = new ArrayList<>();


	/*
	 * constructor
	 */
	public void graph() {
		v =0;
		e =0;
		nodos = null;
		arcos = null;
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
	 * Adiciona un vértice con un Id único.
	 * El vértice tiene la información InfoVertex
	 */
	public void addVertex(K idVertex, V infoVertex) throws Exception {
		if(v==0){
			Vertice<K, V> a = new Vertice<>();
			a.cambiarInfo(infoVertex);
			a.setId(idVertex);
			v++;
			raiz=a;
			nodos.add(a);
			
		}
		else{
			if(getInfoVertex(idVertex)!=null){
				throw new Exception("ya existe");
			}
		Vertice<K, V> a = new Vertice<>();
		a.cambiarInfo(infoVertex);
		a.setId(idVertex);
		v++;	
		nodos.add(a);
		}
	}

	/*
	 * Adiciona el arco No dirigido entre el vertice IdVertexIni y 
	 * el vertice IdVertexFin. El arco tiene la información infoArc
	 */
	public void addEdge(K idVertexIni, K idVertexFin, A infoArc) throws Exception {
		if(getInfoArc(idVertexIni, idVertexFin)!=null){
			throw new Exception("este arco ya existe");
		}else{
		Arco<K, K, A> a = new Arco(idVertexIni, idVertexFin, infoArc);
		e++;	
		arcos.add(a);
		}
	}

	/*
	 * Obtener la información de un vértice
	 */
	public V getInfoVertex(K idVertex) {
		for(int cont =0; cont<=v-1; cont ++){
			if(nodos.get(cont).darID()== idVertex){
				return nodos.get(cont).darInfo();
			}
		}
		return null;
	}

	/*
	 * Modificar la información del vértice 
	 */
	public void setInfoVertex(K idVertex, V infoVertex) {
		for(int cont =0; cont<=v-1; cont ++){
			if(nodos.get(cont)== idVertex){
				nodos.get(cont).cambiarInfo(infoVertex);
			}
		}
	}

	/*
	 * Obtener la información de un arco
	 */
	public A getInfoArc(K idVertexIni, K idVertexFin) {
		for(int cont =0; cont<=e-1; cont ++){
			if(arcos.get(cont).darVerticeOrigen()==idVertexIni&&arcos.get(cont).darVerticeDestino()==idVertexFin){
				return arcos.get(cont).darInfoArco();
			}
		}
		return null;
	}

	/*
	 *Modificar la información del arco entre los vértices idVertexIni e idVertexFin 
	 */
	public void setInfoArc(K idVertexIni, K idVertexFin, A infoArc) {
		for(int cont =0; cont<=e-1; cont ++){
			if(arcos.get(cont).darVerticeOrigen()==idVertexIni&&arcos.get(cont).darVerticeDestino()==idVertexFin){
				arcos.get(cont).setInf(infoArc);
			}
		}		
	}

	/*
	 * Retorna los identificadores de los vértices adyacentes a idVertex
	 */
	public ArrayList<K> adj(K idVertex) {
		ArrayList<K> ret = new ArrayList<>();
		for(int cont =0; cont<=v; cont ++){
			if(arcos.get(cont).darVerticeDestino()==idVertex){
				ret.add(arcos.get(cont).darVerticeOrigen());
			}
			if( arcos.get(cont).darVerticeOrigen()==idVertex){
				ret.add(arcos.get(cont).darVerticeDestino());
			}
		}
		return ret;
	}
}
