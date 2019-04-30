package model.estructuras;

/**



 * 2019-01-23



 * Estructura de Datos Arreglo Dinamico de Strings.



 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.



 * Tomado del taller #1 Estructuras de Datos 2019-1 Universidad de los Andes



 * @author Fernando De la Rosa



 *



 */



public class ArregloDinamico<T> implements IArregloDinamico<T> {



	/**



	 * Capacidad maxima del arreglo



	 */



    private int tamanoMax;



	/**



	 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)



	 */



    private int tamanoAct;



    /**



     * Arreglo de elementos de tamaNo maximo



     */



    private T elementos[ ];







    /**



     * Construir un arreglo con la capacidad maxima inicial.



     * @param max Capacidad maxima inicial



     */



	@SuppressWarnings("unchecked")



	public ArregloDinamico( int max )



    {



           elementos = (T[]) new Comparable[max];



           tamanoMax = max;



           tamanoAct = 0;



    }



    



	@SuppressWarnings("unchecked")



	public void agregar( T dato )



    {



           if ( tamanoAct == tamanoMax )



           {  // caso de arreglo lleno (aumentar tamaNo)



                tamanoMax = 2 * tamanoMax;



                T [ ] copia = elementos;



                elementos = (T[]) new Comparable[tamanoMax];



                for ( int i = 0; i < tamanoAct; i++)



                {



                 	 elementos[i] = copia[i];



                } 



        	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);



           }	



           elementos[tamanoAct] = dato;



           tamanoAct++;



   }







	public int darTamano() {



		// TODO implementar



		return tamanoAct;



	}







	public T darElemento(int i) {



		



		T elemento = elementos[i];



		



		return elemento;



	}







	public T buscar(T dato) {



		// TODO implementar



		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.



		T elemento = null;



		for(int i = 0; i<darTamano();i++){



			if(elementos[i].toString().compareTo(dato.toString())==0){



				elemento = dato;



				break;



			}



		}



		return elemento;



	}







	public T eliminar(T dato) {



		// TODO implementar



		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.



		T elemento = null;



		int i = 0;



		for(i = 0; i<darTamano();i++){



			if(elementos[i].toString().compareTo(dato.toString())==0){



				elemento = dato;



				elementos[i] = null;



				for(int j = i; j<darTamano(); j++){



					elementos[j]=elementos[j+1];



				}



				break;



			}



		}



			tamanoAct--;



		return elemento;



	}



}