package model.estructuras;

import java.util.ArrayList;
import java.util.Iterator;

public interface IGraph<K, V, A> {

	void graph ( );
	
	int V();
	
	int E();
	
	void addVertex( K idVertex, V infoVertex);
	
	void addEdge(K idVertexIni, K idVertexFin, A infoArc );
	
	V getInfoVertex(K idVertex);
	
	void setInfoVertex(K idVertex, V infoVertex);
	
	A getInfoArc(K idVertexIni, K idVertexFin);
	
	void setInfoArc(K idVertexIni, K idVertexFin, A infoArc);
	
	ArrayList<K> adj(K idVertex);
}
