import static org.junit.Assert.*;

import org.junit.Test;

public class Test5 {

	@Test
	public void test() {
		Floyd algorithm = new Floyd();
		Integer[][] graph = {{0, 30, -1, -1}, {-1, 0, -1, -1}, {-1, -1, 0, 15}, {-1, -1, -1, 0}};
				
		algorithm.setPlace("Mixco", "Antigua",  30); //Se agrega al dict
		algorithm.setPlace("Antigua", "Escuintla",  25); //Se agrega al dict
		algorithm.setPlace("Escuintla", "SantaLucia",  15); //Se agrega al dict
		
		algorithm.setMatrix(); //Se agregan a la matriz
		algorithm.floydAlgorithm(); //Se calcula el algoritmo
		
		algorithm.setPlace("Antigua", "Escuintla", -1); //Se cambia la distancia a infinito (hay trafico)
		
		Integer[][] possible = algorithm.getGraph();	//Se obtiene
		
		
		
		/*Se verifica que la primera fila sea igual*/
		/*Si son iguales, el algoritmo si funciona*/
		assertEquals(graph[0][0], possible[0][0]);
	}

}
