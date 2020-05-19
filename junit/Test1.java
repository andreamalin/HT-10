import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		Floyd algorithm = new Floyd();
		Integer[][] graph;
		
		graph = new Integer[4][4];
				
		algorithm.setPlace("Mixco", "Antigua",  30); //Se agrega al dict
		algorithm.setPlace("Antigua", "Escuintla",  25); //Se agrega al dict
		algorithm.setPlace("Escuintla", "SantaLucia",  15); //Se agrega al dict
		
		algorithm.setMatrix(); //Se agregan a la matriz
		
		Integer[][] graph_made = algorithm.getGraph();
		
		/*Se compara si la longitud es 4 (lo que confirma que se agregan)*/
		assertEquals(graph.length, graph_made.length);
	}

}
