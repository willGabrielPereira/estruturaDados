package matriz;

public class Main {

	public static void main(String[] args) {
		MatrizAdjacencia matriz = new MatrizAdjacencia(6);
		matriz.inserirAresta(1, 4);
		matriz.inserirAresta(2, 4);
		matriz.inserirAresta(2, 3);
		matriz.inserirAresta(3, 4);
		matriz.inserirAresta(5, 4);
		matriz.inserirAresta(5, 6);
		matriz.inserirAresta(4, 6);
		
		System.out.println(matriz.toString());
	}

}
