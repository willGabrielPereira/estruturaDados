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
	}
	
	public void inserirArestaBidirecional(int origem, int destino) {
		this.G[origem-1][destino-1] = 1;
		this.G[destino-1][origem-1] = 1;
	}
	
	public void removerAresta(int origem, int destino) {
		this.G[origem-1][destino-1] = 0;
	}
	
	public void removerArestaBidirecional(int origem, int destino) {
		this.G[origem-1][destino-1] = 0;
		this.G[destino-1][origem-1] = 0;
	}
	
	public int qtdArestas(int vertices) {
		if(vertices <= 2) {
			return 1;
		}else {
			return (vertices-1)+qtdArestas(vertices-1);
		}
	}
	
	public int[][] montarMatrizIncidencia(){
		int arest = qtdArestas(qtdVertices);
		int[][] mInc = new int[arest][qtdVertices];
		
		for(int inc=0; inc<arest; inc++) {
			
			for(int i=0; i<qtdVertices; i++) {
				for(int j=0; j<qtdVertices; j++) {
					if(G[i][j] == 1) {
						mInc[inc][i]=1;
						mInc[inc][j]=1;
					}
				}
			}
			
		}
		
		return mInc;
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
