package matriz;

public class MatrizAdjacencia {
	private int qtdVertices;
	private int[][] G;
	
	/**
	 * Construtor da matriz
	 * @param qtdVertices quantidade de vertices
	 */
	public MatrizAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		this.G = new int[qtdVertices][qtdVertices];
	}
	
	/**
	 * Insere aresta
	 * @param origem vertice inicial
	 * @param destino vertice final
	 */
	public void inserirAresta(int origem, int destino) {
		this.G[origem-1][destino-1] = 1;
	}
	
	/**
	 * Insere aresta bidirecional
	 * @param origem vertice 1
	 * @param destino vertice 2
	 */
	public void inserirArestaBidirecional(int origem, int destino) {
		this.G[origem-1][destino-1] = 1;
		this.G[destino-1][origem-1] = 1;
	}
	
	/**
	 * Remove aresta
	 * @param origem vertice inicial
	 * @param destino vertice final
	 */
	public void removerAresta(int origem, int destino) {
		this.G[origem-1][destino-1] = 0;
	}
	
	/**
	 * Remove aresta bidirecional
	 * @param origem vertice 1
	 * @param destino vertice 2
	 */
	public void removerArestaBidirecional(int origem, int destino) {
		this.G[origem-1][destino-1] = 0;
		this.G[destino-1][origem-1] = 0;
	}
	
	/**
	 * Calcula quantidade de arestas de determinado vertice
	 * @param vertices
	 * @return
	 */
	public int qtdArestas(int vertice) {
		if(vertice <= 2) {
			return 1;
		}else {
			return (vertice-1)+qtdArestas(vertice-1);
		}
	}
	
	public int[][] montarMatrizIncidencia(){
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("	 ");
		for(int i=0; i<qtdVertices; i++) {
			sb.append((i+1)+"	");
		}
		sb.append("\n");
		for(int i=0; i<qtdVertices; i++) {
			sb.append((i+1)+"	|");
			for(int j=0; j<qtdVertices; j++) {
				sb.append(G[i][j]+"	");
			}
			sb.append("|\n");
		}
		return sb.toString();
	}
}
