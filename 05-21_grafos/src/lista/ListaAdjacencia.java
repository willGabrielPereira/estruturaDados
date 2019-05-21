package lista;

public class ListaAdjacencia {
	protected class vertice{
		int num;
		vertice prox;
		
		public vertice() {}
		public vertice(int num) {
			this.num = num;
		}
		
		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			b.append(num);
			b.append(" -> ");
			b.append(prox);
			return b.toString();
		}
	}
	
	private vertice listaAdj[];
	private int qtdVertices;
	
	public ListaAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		this.listaAdj = new vertice[qtdVertices];
		for(int i=0; i<qtdVertices; i++) {
			listaAdj[i] = new vertice(i+1);
			listaAdj[i].prox = null;
		}
	}
	
	public void inserirAresta(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		while(v.prox!=null) {
			v = v.prox;
		}
		v.prox = new vertice(destino);
	}
	
	public void removerAresta(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		vertice ant = v;
		while(v.prox!=null) {
			if(v.prox.num == destino) {
				ant = v;
				v = v.prox.prox;
				ant.prox = v;
				break;
			}else {
				v = v.prox;
			}
		}
	}
	
	public void mostrarLista() {
		for(int i=0; i<qtdVertices; i++) {
			System.out.println(listaAdj[i].toString());
		}
	}
	
	public vertice[] getLista() {
		return listaAdj;
	}
	
	public int getQtdVertices() {
		return qtdVertices;
	}
}
