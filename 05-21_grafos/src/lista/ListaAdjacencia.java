package lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
	
		//	TOSTRING JÁ GERA POR RECURSIVIDADE TODA A SEQUENCIA DE LIGAÇÕES DO VÉRTICE
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
	
	//	CONSTRUTOR INSERE AUTOMATICAMENTE NUMEROS DENTRO DA LISTA
	public ListaAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		this.listaAdj = new vertice[qtdVertices];
		for(int i=0; i<qtdVertices; i++) {
			listaAdj[i] = new vertice(i+1);
			listaAdj[i].prox = null;
		}
	}
	
	//	INSERE ARESTA NO FINAL DA SEQUENCIA DE LIGAÇÕES
	public void inserirArestaFim(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		v.qtdAresta++;
		while(v.prox!=null) {
			v = v.prox;
		}
		v.prox = new vertice(destino);
	}
	
	//	INSERE ARESTA NO INICIO DA SEQUENCA DE LIGAÇÕES, PORÉM LOGO ATRÁS DO VÉRTICE PRINCIPAL
	/*
	 * ex: insere vertice 5, na sequencia 2->3
	 * 2->3->null
	 * 2->5->3->null
	*/
	public void inserirArestaInicio(int origem, int destino) {
		vertice novo = new vertice(destino);
		novo.prox = listaAdj[origem-1].prox;
		listaAdj[origem-1].prox = novo;
		listaAdj[origem-1].qtdAresta++;
	}
	
	//	INSERE ARESTA BIDIRECIONALMENTE PELO INICIO
	public void inserirArestaBidirecional(int origem, int destino) {
		this.inserirArestaInicio(origem, destino);
		this.inserirArestaInicio(destino, origem);
	}
	
	//	REMOVE ARESTA BIDIRECIONALMENTE
	public void removerArestaBidirecional(int origem, int destino) {
		this.removerAresta(origem, destino);
		this.removerAresta(destino, origem);
	}
	
	//	REMOVE ARESTA
	public void removerAresta(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		vertice ant = v;
		while(v.prox!=null) {
			if(v.prox.num == destino) {
				ant = v;
				v = v.prox.prox;
				ant.prox = v;
				listaAdj[origem-1].qtdAresta--;
				break;
			}else {
				v = v.prox;
			}
		}
	}
	
	//	VERIFICA SE A SEQUENCIA DE LIGAÇÕES ESTÁ VAZIA
	public boolean verticeVazio(int vertice) {		
		return (listaAdj[vertice].prox == null);
	}
	
	//	VERIFICA SE EXISTE ARESTA ENTRE TAL DOIS VERTICES
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
	
	//	BUSCA POR LARGURA
	public Stack<Integer> buscaPorLargura(int raiz) {
		Stack<Integer> visitado = new Stack<Integer>();
		int vertice;
		
		visitado.push(listaAdj[raiz-1].num);
		
		List<vertice> fila = new ArrayList<vertice>();
		fila.add(listaAdj[raiz-1]);
		
		while(!fila.isEmpty()) {
			vertice = fila.get(0).num;
			vertice v = listaAdj[vertice-1];
			
			while(v != null) {
				if(!visitado.contains(v.num)) {
					visitado.push(v.num);
					fila.add(v);
				}
				v = v.prox;
			}
			fila.remove(0);
		}
		
		return visitado;
	}
	
	//	GERA GRAFO COMPLETO
	public boolean grafoCompleto() {
		boolean comp = true;
		for(int i=1; i<=this.qtdVertices; i++) {
			for(int j=1; j<=this.qtdVertices; j++) {
				comp = (comp && existeAresta(i, j));
			}
		}
		return comp;
	}
	
	//	CALCULA A QUANTIDADE DE ARESTAS POSSÍVEIS
	public int qtdArestas(int vertices) {
		if(vertices <= 2) {
			return 1;
		}else {
			return (vertices-1)+qtdArestas(vertices-1);
		}
	}
	
	//	GERA MATRIZ DE ADJACENCIA
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
	
	//	GERA MATRIZ DE INCIDENCIA
	public int[][] montarMatrizIncidencia(){
		MatrizAdjacencia m = montarMatrizAdj();
		return m.montarMatrizIncidencia();
	}
	
	//	MESMA FUNÇÃO QUE TOSTRING
	public String mostrarLista() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<qtdVertices; i++) {
			sb.append("qnt: "+listaAdj[i].qtdAresta+" | ");
			sb.append(listaAdj[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	//	TOSTRING DO VERTICE
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
