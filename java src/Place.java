/**********************************************************
*Places.java   		      	Fecha de creacion: 16 de mayo
*                           Ultima fecha de modificacion: 18 de mayo
*                           
*Clase encargada de llevar el lugar dentro de la matriz de cada ciudad,
*ademas de no repetir lugares y contiene los getters de sus atributos
*
*@author Andrea Amaya #19357 
**********************************************************/
import java.util.*;

public class Place{
	private String place1;
	private String place2;
	private int distance;

	private static Map<String, Integer> places_value = new HashMap<String, Integer>();
	private static int actual = 0;
	
	private static ArrayList<String> names = new ArrayList();

	public Place(String place1, String place2, int distance){
		this.place1 = place1;
		this.place2 = place2;
		this.distance = distance;


		if (!places_value.containsKey(place1)) {
		    places_value.put(place1, actual);
		    names.add(place1);
			actual++;
		} 

		if (!places_value.containsKey(place2)) {
		    places_value.put(place2, actual);
		    names.add(place2);
			actual++;
		}
	}

	public int getMatrixSize(){
		//El tamano de la matriz, sera el tamano del dict
		return places_value.size();
	}


	private ArrayList<String> removeDuplicates(ArrayList<String> duplicated){
		//Se eliminan los valores duplicados dentro del array
		ArrayList<String> temporal = new ArrayList<String>();

		for (String element:duplicated) { 
            if (!temporal.contains(element)) { 
  
                temporal.add(element); 
            } 
        } 
        return temporal;
	}

	public int getPlaceValue(String place){
		//Se obtiene la posicion del lugar dentro del array
		return places_value.get(place);
	}

	public String getPlace1(){
		//Se obtiene el nombre de la ciudad origen
		return place1;
	}

	public String getPlace2(){
		//Se obtiene el nombre de la ciudad destino
		return place2;
	}

	public int getDistance(){
		//Se obtiene el valor del lugar (distancia)
		return distance;
	}

	public ArrayList<String> getHorizontal(){
		//Se obtienen los nombres de los lugares
		return names;
	}

	public Map<String, Integer> getMap(){
		//Se obtiene el mapa de los lugares
		return places_value;
	}
}