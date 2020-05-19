import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		Floyd algorithm = new Floyd();
		Integer[][] graph;
		
		graph = new Integer[4][4];
				
		algorithm.setPlace("Mixco", "Antigua",  30); //Se agrega al dict
		algorithm.setPlace("Antigua", "Escuintla",  25); //Se agrega al dict
		algorithm.setPlace("Escuintla", "SantaLucia",  15); //Se agrega al dict
		
		algorithm.setMatrix(); //Se agregan a la matriz
		algorithm.floydAlgorithm();
		
		String center = algorithm.graphCenter(); /*Se calcula el centro*/
		
		/*Se espera que el centro sea SantaLucia, pues es el único que no tiene distancia infinita*/
		assertEquals("SantaLucia", center);
	}

}
