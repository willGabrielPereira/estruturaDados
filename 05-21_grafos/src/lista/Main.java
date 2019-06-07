package lista;

import java.util.Arrays;

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
		
		l.inserirArestaFim(1, 2);
		l.inserirArestaFim(2, 1);
		l.inserirArestaFim(2, 3);
		l.inserirArestaFim(3, 2);
		l.inserirArestaFim(1, 4);
		l.inserirArestaFim(4, 1);
		l.inserirArestaFim(3, 4);
		l.inserirArestaFim(4, 3);
		
		System.out.println(l.mostrarLista());

		//System.out.println(l.grafoCompleto());
		
		int[][] m = l.montarMatrizIncidencia();
		
		System.out.println();

	}

}
