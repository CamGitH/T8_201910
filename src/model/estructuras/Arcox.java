package model.estructuras;

public class Arcox<K,A>
{

	//Atributos
	/**
	 * Id generico del segundo vertice
	 */
	private K llaveId;

	/**
	 * Peso del arco
	 */
	private A pesoArco;

	//Constructor
	/**
	 * @param pPeso peso del arco
	 * @param pLlave llave id del vertice adyacente
	 */
	public Arcox (A pPeso, K pLlave)
	{
		//se inicializan los atributos del arco
		llaveId=pLlave;
		pesoArco=pPeso;
	}
	//Metodos
	/**
	 * Retorna el Id del vertice adyacente
	 */
	public K darAdyacente()
	{
		return llaveId;
	}

	/**
	 * Retorna el Peso del arco
	 */
	public A darPeso()
	{
		return pesoArco;
	}

	/**
	 * Modificar la informacion del arco con el vertice idVertexFin
	 */
	public void setInfoArc(A infoArc)
	{
		pesoArco=infoArc;
	}
}

