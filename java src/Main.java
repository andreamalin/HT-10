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
		Boolean seguir = true;
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
			
			while(seguir){		/*Defensiva para pedir la opcion*/
				String opcion_pos = scan.next();
				try{
					opcion = Integer.parseInt(opcion_pos);
					if (opcion>=1 || opcion<=4) {
						seguir = false;
					} else {
						System.out.println("Ingrese un numero dentro del rango");
					}
				} catch (Exception e){
					System.out.println("Ingreso invalido");		
				}				
			}
			seguir = true;


			if (opcion==1) {
				/*Se pide*/
				System.out.println("\nIngrese el nombre de la ciudad de origen");
				String origen = scan.next();
				System.out.println("Ingrese el nombre de la ciudad de destino");
				String destino = scan.next();
				/*Se muestra*/
				System.out.println(algorithm.shortestPath(origen, destino));
			} else if (opcion==2) {
				/*Se muestra*/
				System.out.println(algorithm.graphCenter());
			} else if (opcion==3) {
				/*Se pide*/
				System.out.println("\nIngrese el nombre de la ciudad de origen");
				String origen = scan.next();
				System.out.println("Ingrese el nombre de la ciudad de destino");
				String destino = scan.next();
				System.out.println("Ingrese la distancia en km para llegar del origen al destino");

				while(seguir){		/*Defensiva para pedir la opcion*/
					String distancia_pos = scan.next();
					try{
						Integer distancia = Integer.parseInt(distancia_pos);
						algorithm.setPlace(origen, destino, distancia); //Se agrega al vector
						seguir = false;
					} catch (Exception e){
						System.out.println("Ingreso invalido");		
					}				
				}
				seguir = true;

				/*Se muestra*/
				algorithm.setMatrix();							//Se modifica la matriz con el nuevo destino
				algorithm.floydAlgorithm();						//Se realiza nuevamente el algoritmo de floyd
				algorithm.showMatrix();							//Se muestra en pantalla
			}
		}
		System.out.println("__________________________________________\nGRACIAS POR USAR EL PROGRAMA :D");
	}
}