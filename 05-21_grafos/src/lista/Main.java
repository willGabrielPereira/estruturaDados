package lista;

public class Main {

	public static void main(String[] args) {
		ListaAdjacencia l = new ListaAdjacencia(5);
		l.inserirAresta(1, 2);
		l.inserirAresta(1, 3);
		l.inserirAresta(2, 1);
		l.inserirAresta(2, 3);
		l.inserirAresta(3, 1);
		l.inserirAresta(3, 2);
		l.inserirAresta(3, 4);
		l.inserirAresta(3, 5);
		l.inserirAresta(4, 3);
		l.inserirAresta(5, 3);
		
		l.mostrarLista();
		
		System.out.println();
		
		l.removerAresta(1, 3);
		l.removerAresta(3, 1);
		l.mostrarLista();
		//System.out.println(l.getLista());
		
		
	}

}
