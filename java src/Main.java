/**********************************************************
*Main.java   		      	Fecha de creacion: 26 de marzo
*                           Ultima fecha de modificacion: 30 de marzo
*                           
*Clase encargada de interactuar con el usuario
*
*@author Andrea Amaya #19357
**********************************************************/
import java.util.*;
import java.io.*; 

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer opcion = 0;
		Floyd algorithm = new Floyd(); //Instanciamos el algoritmo

		System.out.println("__________________________________________\n          B I E N V E N I D O\n__________________________________________");


		//Defensiva archivo de texto
		try {
			Scanner r = new Scanner(new File("guategrafo.txt")); 
			while (r.hasNextLine()) {
				String txt = r.nextLine(); //Mientras hayan lineas por leer se meten a la variable txt
				String[] word = txt.split("\\s+");

				algorithm.setPlace(word[0], word[1],  Integer.parseInt(word[2])); //Se agrega al vector
			}
			algorithm.setMatrix();
			r.close();	
		} catch (Exception e) { //Se muestra la razon de error por la que no se encuentra el doc
			e.printStackTrace();
		}		

		//Desde que ingresa se muestra la matriz ingresada y la generada por el algoritmo de floyd
		System.out.println("__________________________________________\n            MATRIZ INGRESADA	\n__________________________________________");
		algorithm.showMatrix();
		System.out.println("__________________________________________\n     MATRIZ CON EL ALGORITMO DE FLOYD\n__________________________________________");
		algorithm.floydAlgorithm();
		algorithm.showMatrix();

		while(opcion!=4){
			//Se muestra el menu de opciones
			System.out.println("__________________________________________");
			System.out.println("\n1. Pedir ruta mas corta\n2. Ciudad en el centro del grafo\n3. Modificar grafo\n4. Salir"); 
			System.out.println("__________________________________________");
			opcion = scan.nextInt();

			if (opcion==1) {
				System.out.println("\nIngrese el nombre de la ciudad de origen");
				String origen = scan.next();
				System.out.println("Ingrese el nombre de la ciudad de destino");
				String destino = scan.next();

				
				System.out.println(algorithm.shortestPath(origen, destino));
			}
		}
	}
}