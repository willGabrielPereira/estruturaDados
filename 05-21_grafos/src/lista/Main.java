package lista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		ListaAdjacencia l = new ListaAdjacencia(4);
		/*l.inserirArestaFim(1, 2);
		l.inserirArestaFim(1, 3);
		l.inserirArestaFim(2, 1);
		l.inserirArestaFim(2, 3);
		l.inserirArestaFim(3, 1);
		l.inserirArestaFim(3, 2);
		l.inserirArestaFim(3, 4);
		l.inserirArestaFim(3, 5);
		l.inserirArestaFim(4, 3);
		l.inserirArestaFim(5, 3);
		
		System.out.println(l.mostrarLista());
		
		System.out.println();
		
		l.removerAresta(1, 3);
		l.removerAresta(3, 1);
		System.out.println(l.mostrarLista());
		//System.out.println(l.getLista());*/
		
		l.inserirArestaFim(1, 2, 0);
		l.inserirArestaFim(2, 1, 0);
		l.inserirArestaFim(1, 4,0);
		l.inserirArestaFim(4, 1,0);
		l.inserirArestaFim(3, 4,0);
		l.inserirArestaFim(4, 3,0);
		l.inserirArestaFim(3, 1,0);
		
		System.out.println(l.toString());

		//System.out.println(l.grafoCompleto());
		
		//int[][] m = l.montarMatrizIncidencia();
		
		System.out.println();

		List<Integer> st = l.buscaPorProfundidade(1);
		System.out.println(st);

		System.out.println();
		
		
		//System.out.println(l.grafoConexo(st.peek(), 1));
		
	}

}
