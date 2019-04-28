package model.estructuras;

public class Arco<K, V, A> {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Vértice desde el cual sale el arco
	 */
	private K origen;

	/**
	 * Vértice hacia el cual va el arco
	 */
	private K destino;

	/**
	 * Elemento en el arco
	 */
	private A infoArco;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del arco
	 * @param idVertexIni Vértice desde el cual sale el arco
	 * @param idVertexFin Vértice hacia donde se dirige el arco
	 * @param pInfoArco Elemento en el arco
	 */
	public Arco( K idVertexIni, K idVertexFin, A pInfoArco )
	{
		origen = idVertexIni;
		destino = idVertexFin;
		infoArco = pInfoArco;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el elemento del arco
	 * @return Elemento en el arco
	 */
	public A darInfoArco( )
	{
		return infoArco;
	}

	/**
	 * Devuelve el vértice de destino del arco
	 * @return vértice de destino del arco
	 */
	public K darVerticeDestino( )
	{
		return destino;
	}

	/**
	 * Devuelve el vértice de origen del arco
	 * @return vértice de origen del arco
	 */
	public K darVerticeOrigen( )
	{
		return origen;
	}

	public void setInf(A pInf){
		infoArco=pInf;
	}

}

