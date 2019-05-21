package lista;

public class Main {

	public static void main(String[] args) {
		ListaAdjacencia l = new ListaAdjacencia(5);
		l.inserirArestaFim(1, 2);
		l.inserirArestaFim(1, 3);
		l.inserirArestaFim(2, 1);
		l.inserirArestaFim(2, 3);
		l.inserirArestaFim(3, 1);
		l.inserirArestaFim(3, 2);
		l.inserirArestaFim(3, 4);
		l.inserirArestaFim(3, 5);
		l.inserirArestaFim(4, 3);
		l.inserirArestaFim(5, 3);
		
		l.mostrarLista();
		
		System.out.println();
		
		l.removerAresta(1, 3);
		l.removerAresta(3, 1);
		l.mostrarLista();
		//System.out.println(l.getLista());
		
		
	}

}
