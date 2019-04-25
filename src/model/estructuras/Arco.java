package model.estructuras;

public class Arco<K, V, A> {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Vértice desde el cual sale el arco
	 */
	private Vertice<K, V> origen;

	/**
	 * Vértice hacia el cual va el arco
	 */
	private Vertice<K, V> destino;

	/**
	 * Elemento en el arco
	 */
	private A infoArco;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del arco
	 * @param pOrigen Vértice desde el cual sale el arco
	 * @param pDestino Vértice hacia donde se dirige el arco
	 * @param pInfoArco Elemento en el arco
	 */
	public Arco( Vertice<K, V> pOrigen, Vertice<K, V> pDestino, A pInfoArco )
	{
		origen = pOrigen;
		destino = pDestino;
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
	public Vertice<K, V> darVerticeDestino( )
	{
		return destino;
	}

	/**
	 * Devuelve el vértice de origen del arco
	 * @return vértice de origen del arco
	 */
	public Vertice<K, V> darVerticeOrigen( )
	{
		return origen;
	}


}

