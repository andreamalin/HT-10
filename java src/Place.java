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
		ArrayList<String> temporal = new ArrayList<String>();

		for (String element:duplicated) { 
            if (!temporal.contains(element)) { 
  
                temporal.add(element); 
            } 
        } 
        return temporal;
	}

	public int getPlaceValue(String place){
		return places_value.get(place);
	}

	public String getPlace1(){
		return place1;
	}

	public String getPlace2(){
		return place2;
	}

	public int getDistance(){
		return distance;
	}

	public ArrayList<String> getHorizontal(){
		return names;
	}

	public Map<String, Integer> getMap(){
		return places_value;
	}
}