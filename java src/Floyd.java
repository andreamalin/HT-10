import java.util.*;

public class Floyd{
	private static int infinity = -1;

	private ArrayList<Place> places = new ArrayList();
	private int size=0;

	private Integer[][] graph;
	private Integer[][] iterations;

	public void floydAlgorithm(){		
		//Se realiza la cantidad de filas en la matriz (es cuadrada)
		for (int contador=0; contador<size; contador++) {
			int actual = contador;
			Integer[] iteracion_h = graph[actual]; //Horizontal
			Integer[] iteracion_v = new Integer[size];

			for (int i=0; i<size; i++) {
				iteracion_v[i] = graph[i][actual]; //Vertical
			}

			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {		//Se trabaja la misma i el tamano del array
					if (!(i==j) && !(j==actual) && !(i==actual)) {	//Si no se esta en la diagonal ni en la iteracion
	 					if (!(iteracion_v[i]==-1 || iteracion_h[j]==-1)) { //Se revisa que ninguno sea infinito
							Integer iteracion_actual = iteracion_v[i]*iteracion_h[j];		//Se obtiene la multiplicacion de la iteracion
							Integer posicion_actual = graph[i][j];							//Se obtiene el numero actual apuntado

							//Si la iteracion actual es menor a la distancia actual o la distancia actual es infinita
							if (iteracion_actual < posicion_actual 	|| posicion_actual == -1) {
								graph[i][j] = iteracion_actual;	//Se coloca el nuevo valor
								iterations[i][j] = actual+1; //Se coloca que interacion fue
							}

						}
					}
				}
			}
		}
	}

	public void setPlace(String place1, String place2, int distance){
		places.add(new Place(place1, place2, distance)); //Se agregan los objetos Places
	}


	public void setMatrix(){
		this.size = places.get(0).getMatrixSize(); 
		graph = new Integer[size][size];	//Se realiza una matriz cuadrada
		iterations = new Integer[size][size]; //Tabla de iteraciones

		for (int i=0; i<places.size(); i++) {		//Por cada lugar agregado (del txt)
			//Se obtiene el lugar actal places.get(i)
			//Se obtiene la posicion de ese lugar getPlaceValue(place1/place2)
			//Se iguala a la distancia entre ellos
			graph[places.get(i).getPlaceValue(places.get(i).getPlace1())][places.get(i).getPlaceValue(places.get(i).getPlace2())]=places.get(i).getDistance();
		}

		//Se rellenan las iteraciones
		int contador =1;
		for (int actual=0; actual<size; actual++) {
			for (int i=0; i<size; i++) {
				iterations[i][actual]=contador; //Vertical
			}	
			contador++;		
		}
		//Se rellena la matriz con infinitos y ceros
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (i == j) {		//La diagonal
					graph[i][j] = 0;
					iterations[i][j] = 0;
				}
				if (graph[i][j] == null) {		//Si no tiene distancia es infinito
					graph[i][j] = infinity;
				}
			}
		} 

	}

	public void showMatrix(){
		int vertical = 0;
		String places_letter="";
		String info = "\nDonde>\n-1 : Distancia infinita";
		ArrayList<String> places_names = places.get(0).getHorizontal();
		
		for (String item: places_names) {
			places_letter += item.charAt(0) + "   ";
			info+="\n"+item.charAt(0)+" : "+item;
		}
		System.out.println("	   "+places_letter);


		//Se muestra fila por fila
		for (Integer[] row : graph){
		    System.out.println("	"+places_names.get(vertical).charAt(0)+ Arrays.toString(row));
		    vertical++;
		}
		System.out.println(info);
	}

	public String shortestPath(String origin, String destination){
		String visitados = "";
		Integer recorrido = 0;
		//Se revisa que exista el origen y el destino
		ArrayList<String> places_names = places.get(0).getHorizontal();
		Map<String, Integer> existing_places = places.get(0).getMap();
		
		try{
			visitados = places_names.get(iterations[existing_places.get(origin)][existing_places.get(destination)]-1);
			recorrido = graph[existing_places.get(origin)][existing_places.get(destination)];
		} catch(Exception e){
			visitados = "No hay forma de llegar";
		}
		
		if (visitados.equals(destination)) {
			visitados = "Ninguna";
		}

		return "\nCiudad intermedia> "+visitados+"\nDistancia recorrida> "+recorrido+" km";
	}


	public void addPath()
}