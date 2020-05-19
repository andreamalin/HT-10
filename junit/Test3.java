import static org.junit.Assert.*;

import org.junit.Test;

public class Test3 {

	@Test
	public void test() {
		Floyd algorithm = new Floyd();
		Integer[][] graph = {{0, 30, 750, 11250}, {-1, 0, 25, 375}, {-1, -1, 0, 15}, {-1, -1, -1, 0}};
				
		algorithm.setPlace("Mixco", "Antigua",  30); //Se agrega al dict
		algorithm.setPlace("Antigua", "Escuintla",  25); //Se agrega al dict
		algorithm.setPlace("Escuintla", "SantaLucia",  15); //Se agrega al dict
		
		algorithm.setMatrix(); //Se agregan a la matriz
		algorithm.floydAlgorithm(); //Se calcula el algoritmo
		
		Integer[][] possible = algorithm.getGraph();	//Se obtiene
		
		
		
		/*Se verifica que la primera fila sea igual*/
		assertEquals(graph[0][0], possible[0][0]);
	}

}
