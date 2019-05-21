package matriz;

public class MatrizAdjacencia {
	private int qtdVertices;
	private int[][] G;
	
	public MatrizAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		this.G = new int[qtdVertices][qtdVertices];
	}
	
	public void inserirAresta(int origem, int destino) {
		this.G[origem-1][destino-1] = 1;
		this.G[destino-1][origem-1] = 1;
	}
	
	public void removerAresta(int origem, int destino) {
		this.G[origem-1][destino-1] = 0;
		this.G[destino-1][origem-1] = 0;
	}
	
	public void mostrarMatriz() {
		System.out.print("	 ");
		for(int i=0; i<qtdVertices; i++) {
			System.out.print((i+1)+"	");
		}
		System.out.println();
		for(int i=0; i<qtdVertices; i++) {
			System.out.print((i+1)+"	|");
			for(int j=0; j<qtdVertices; j++) {
				System.out.print(G[i][j]+"	");
			}
			System.out.print("|\n");
		}
	}
}
