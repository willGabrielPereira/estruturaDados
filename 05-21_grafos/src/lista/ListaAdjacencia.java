package lista;

import matriz.MatrizAdjacencia;

public class ListaAdjacencia {
	protected class vertice{
		int num;
		int qtdAresta = 0;
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
	
	public void inserirArestaFim(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		v.qtdAresta++;
		while(v.prox!=null) {
			v = v.prox;
		}
		v.prox = new vertice(destino);
	}
	
	public void inserirArestaInicio(int origem, int destino) {
		vertice novo = new vertice(destino);
		novo.prox = listaAdj[origem-1].prox;
		listaAdj[origem-1].prox = novo;
		listaAdj[origem-1].qtdAresta++;
	}
	
	public void inserirArestaBidirecional(int origem, int destino) {
		this.inserirArestaInicio(origem, destino);
		this.inserirArestaInicio(destino, origem);
	}
	
	public void removerArestaBidirecional(int origem, int destino) {
		this.removerAresta(origem, destino);
		this.removerAresta(destino, origem);
	}
	
	public void removerAresta(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		vertice ant = v;
		v.qtdAresta--;
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
	
	public boolean verticeVazio(int vertice) {
		if(listaAdj[vertice].prox != null) {
			return true;
		}
		return false;
	}
	public boolean existeAresta(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		while(v!=null){
			if(v.num == destino) {
				return true;
			}
			v = v.prox;
		}
		return false;
	}
	
	public boolean grafoCompleto() {
		boolean comp = true;
		for(int i=1; i<=this.qtdVertices; i++) {
			for(int j=1; j<=this.qtdVertices; j++) {
				comp = (comp && existeAresta(i, j));
			}
		}
		return comp;
	}
	
	public int qtdArestas(int vertices) {
		if(vertices <= 2) {
			return 1;
		}else {
			return (vertices-1)+qtdArestas(vertices-1);
		}
	}
	
	public MatrizAdjacencia montarMatrizAdj() {
		MatrizAdjacencia maAdj = new MatrizAdjacencia(qtdVertices);
		
		for(int i=0; i<qtdVertices; i++) {
			vertice v = listaAdj[i];
			while(v!=null){
				if(v.num != listaAdj[i].num) {
					maAdj.inserirAresta(listaAdj[i].num, v.num);
				}
				v = v.prox;
			}
		}
		
		return maAdj;
	}
	
	public int[][] montarMatrizIncidencia(){
		MatrizAdjacencia m = montarMatrizAdj();
		return m.montarMatrizIncidencia();
	}
	
	public String mostrarLista() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<qtdVertices; i++) {
			sb.append("qnt: "+listaAdj[i].qtdAresta+" | ");
			sb.append(listaAdj[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String mostrarVertice(int vertice) {
		return listaAdj[vertice].toString();
	}
	
	public vertice getVertice(int vertice) {
		return listaAdj[vertice];
	}
	
	public vertice[] getLista() {
		return listaAdj;
	}
	
	public int getQtdVertices() {
		return qtdVertices;
	}
}
