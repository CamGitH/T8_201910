package model.estructuras;

public class Grafox  <K extends Comparable<K>,V,A> 
{
	//Atributos
	/**
	 * Numero de arcos en el grafo
	 */
	private int nArcos;

	/**
	 * Numero de vertices en el grafo
	 */
	private int nVertices;

	/**
	 * Arreglo de arcos y nodos
	 */
	private Verticex[] arreglo; 



	//Constructor
	public Grafox()
	{
		nArcos=0;
		nVertices=0;
		arreglo= new Verticex[100000]; //implementacion de factor de carga 0.75
	}

	//Metodos
	/**
	 * Numero de vertices en el grafo
	 * @return nVertices numero de vertices en el grafo
	 */
	public int V()
	{
		return nVertices;
	}

	/**
	 * Numero de arcos en el grafo
	 * @return nVertices numero de vertices en el grafo
	 */
	public int E()
	{
		return nArcos;
	}

	/**
	 * Adiciona un vertice con un Id unico. El vertice tiene la informacion InfoVertex
	 */
	public void addVertex( K pIdVertex, V infoVertex) //PREGUNTAR SEGUNDO PARAMETRO
	{
		double factorActual= nVertices/arreglo.length;
		int hashCalculado = pIdVertex.hashCode()& 0x7fffffff %arreglo.length; 

		if(factorActual<0.75)
		{
			if(arreglo[hashCalculado]!=null)//no es requerido un else ya que los id son unicos
			{
				arreglo[hashCalculado]=new Verticex(pIdVertex,(Comparable) infoVertex);
				nVertices++;
			}
		}
		else
		{
			reHashGrafo();
			addVertex( pIdVertex, infoVertex);
		}
	}

	/**
	 * Actualiza la posicion de todos los elementos del hashTable segun su llave y el nuevo tamano
	 */
	public void	reHashGrafo()
	{
		Verticex[] copiaHash= arreglo; //se crea un copia con los vertices actuales
		arreglo = new Verticex[arreglo.length*2];//se aumenta la tabla del HashTableLinear

		for ( int i = 0; i < copiaHash.length; i++)//se obtienen los nuevos indices 
		{
			if(copiaHash[i]!=null)
			{
				addVertex((K)copiaHash[i].darLlave(),(V)copiaHash[i].darArcos());
			}
		} 
	}
	/**
	 * Adiciona el arco No dirigido entre el vertice IdVertexIni y el vertice IdVertexFin. El arco tiene la informacion infoArc.
	 */
	public void addEdge(K idVertexIni, K idVertexFin, A infoArc )
	{
		int hashCalculado1 = idVertexIni.hashCode()& 0x7fffffff %arreglo.length; 
		int hashCalculado2 = idVertexFin.hashCode()& 0x7fffffff %arreglo.length; 

		//necesariamente ambos vertices deben existir? PREGUNTAR
		if(arreglo[hashCalculado1]!=null && arreglo[hashCalculado2]!=null)
		{
			arreglo[hashCalculado1].agregarArco(infoArc, idVertexFin); //se agrega el peso del arco y el vertice Fin como conexion al primero
			arreglo[hashCalculado2].agregarArco(infoArc, idVertexIni); //se agrega el peso del arco y el vertice Ini como conexion al segundo
		}
		//Caso en el que se crea el vertice pero este caso no aplica creo - igual lo dejo por si acaso
		//			if(arreglo[hashCalculado1]==null || arreglo[hashCalculado2]==null) ASK XD
		//			{
		//				//se crean los vertices que no han sido creados
		//				if(arreglo[hashCalculado1]==null)
		//				{
		//					arreglo[hashCalculado1]= new Vertice( idVertexIni);
		//				}
		//				if(arreglo[hashCalculado2]==null)
		//				{
		//					arreglo[hashCalculado2]= new Vertice( idVertexFin);
		//				}
		//				
		//				arreglo[hashCalculado1].agregarArco(infoArc, idVertexFin); //se agrega el peso del arco y el vertice Fin como conexion al primero
		//				arreglo[hashCalculado2].agregarArco(infoArc, idVertexIni); //se agrega el peso del arco y el vertice Ini como conexion al segundo
		//			}
	}

	/**
	 * Obtener la informacion de un vertice
	 * @param pIdVertex id del vertice
	 * @return elValor informacion del vertice
	 */
	public V getInfoVertex(K pIdVertex)
	{
		int hashCalculado = pIdVertex.hashCode()& 0x7fffffff %arreglo.length; 
		V elValor =(V) arreglo[hashCalculado].darValor();
		return elValor;
	}

	/**
	 * Modificar la informacion del vertice idVertex
	 * @param pIdVertex información
	 * @param pInfoVertex nueva informacion del vertice
	 */
	public void setInfoVertex(K pIdVertex, V pInfoVertex)
	{
		int hashCalculado = pIdVertex.hashCode()& 0x7fffffff %arreglo.length; 
		arreglo[hashCalculado].setInfoVertex((Comparable) pInfoVertex);;
	}

	/**
	 * Obtener la informacion de un arco
	 * @return infoArco null si alguno de los indices no es encontrado
	 */
	public A getInfoArc(K idVertexIni, K idVertexFin) 
	{
		int hashCalculado1 = idVertexIni.hashCode()& 0x7fffffff %arreglo.length; 
		A infoArco = null; //informacion del arco a retornas
		if(arreglo[hashCalculado1]!=null)
		{
			infoArco = (A) arreglo[hashCalculado1].darArco(idVertexFin);
		}
		return infoArco;
	}

	/**
	 * Modificar la informacion del arco entre los vertices idVertexIni eidVertexFin
	 */
	public void setInfoArc(K idVertexIni, K idVertexFin,
			A infoArc)
	{
		//se obtienen los indices de los hash
		int hashCalculado1 = idVertexIni.hashCode()& 0x7fffffff %arreglo.length; 
		int hashCalculado2 = idVertexFin.hashCode()& 0x7fffffff %arreglo.length; 
		//si ambos existen su arco es actualizado
		if(arreglo[hashCalculado1]!=null && arreglo[hashCalculado2]!=null)
		{
			arreglo[hashCalculado1].setInfoArc(idVertexFin, infoArc);
			arreglo[hashCalculado2].setInfoArc(idVertexIni, infoArc);
		}

	}

	

}

