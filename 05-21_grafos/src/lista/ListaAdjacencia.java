package lista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import matriz.MatrizAdjacencia;

public class ListaAdjacencia {
	
	protected class vertice{
		int num;
		int qtdAresta = 0;
		vertice prox;
		float distancia;
		
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
	
	/**
	 * Construtor da lista
	 * gera automaticamente os numeros de cada vertice
	 * @param qtdVertices quantidade de vertices
	 */
	public ListaAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		this.listaAdj = new vertice[qtdVertices];
		for(int i=0; i<qtdVertices; i++) {
			listaAdj[i] = new vertice(i+1);
			listaAdj[i].prox = null;
		}
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<qtdVertices; i++) {
			sb.append("qnt de vertices: "+listaAdj[i].qtdAresta+" | ");
			sb.append(listaAdj[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	

	/**
	 * ToString do vertice
	 * @param vertice
	 * @return
	 */
	public String mostrarVertice(int vertice) {
		return listaAdj[vertice-1].toString();
	}

	
	/**
	 * Insere aresta no final da lista de adjacencia de tal vertice
	 * 
	 * ex: insere vertice 5, na sequencia 2->3
	 * 2->3->null
	 * 2->3->5->null
	 * 
	 * @param origem vertice inicial
	 * @param destino vertice final
	 * @param distancia distancia entre as arestas
	 */
	public void inserirArestaFim(int origem, int destino, float distancia) {
		vertice v = listaAdj[origem-1];
		v.qtdAresta++;
		while(v.prox!=null) {
			v = v.prox;
		}
		v.prox = new vertice(destino);
		v.prox.distancia = distancia;
	}
	
	/**
	 * Insere areta no inicio da lista de adjacencia do vertice
	 * 
	 * ex: insere vertice 5, na sequencia 2->3
	 * 2->3->null
	 * 2->5->3->null
	 * 
	 * @param origem vertice inicial
	 * @param destino vertice final
	 * @param distancia distancia entre as arestas
	 */
	public void inserirArestaInicio(int origem, int destino, float distancia) {
		vertice novo = new vertice(destino);
		novo.prox = listaAdj[origem-1].prox;
		listaAdj[origem-1].prox = novo;
		listaAdj[origem-1].qtdAresta++;
		novo.distancia = distancia;
	}


	/**
	 * Inserção de aresta bidirecional
	 * insere vertice no inicio
	 * 
	 * @param origem aresta 1
	 * @param destino aresta 2
	 * @param distancia distancia entre as arestas
	 */
	public void inserirArestaBidirecional(int origem, int destino, int distancia) {
		this.inserirArestaInicio(origem, destino, distancia);
		this.inserirArestaInicio(destino, origem, distancia);
	}
	
	/**
	 * Remoção de aresta bidirecional
	 * @param origem vertice 1
	 * @param destino vertice 2
	 */
	public void removerArestaBidirecional(int origem, int destino) {
		this.removerAresta(origem, destino);
		this.removerAresta(destino, origem);
	}
	
	/**
	 * Remoção de aresta
	 * 
	 * @param origem vertice inicial
	 * @param destino vertice final
	 */
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
	
	/**
	 * Verifica se a lista de adjacentes de determinado vertice está vazia
	 * @param vertice valor do vertice
	 * @return
	 */
	public boolean adjacentesVazio(int vertice) {		
		return (listaAdj[vertice].prox == null);
	}
	
	/**
	 * Verifica se existe aresta entre tais dois vertices
	 * @param origem vertice inicial
	 * @param destino vertice final
	 * @return
	 */
	public boolean grafoConexo(int origem, int destino) {
		vertice v = listaAdj[origem-1];
		while(v!=null){
			if(v.num == destino) {
				return true;
			}
			v = v.prox;
		}
		return false;
	}

	/**
	 * Busca em largura
	 * retorna todos os vertices em sequencia

	 * @param raiz vertice inicial
	 * @return
	 */
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
	
	public List<Integer> buscaPorProfundidade(int raiz) {
        List<Integer> visitado = new ArrayList<>();
       
        Stack<vertice> pilha = new Stack<>();
        pilha.add(listaAdj[raiz-1]);
        List<Integer> a = new ArrayList<>(listaAdj.length);
        vertice v = listaAdj[pilha.pop().num-1];
        while (v != null) {
            if (!visitado.contains(v.num)) {
                visitado.add(v.num);
                if (v.prox != null) {
                    vertice vAux= v.prox;
                    while (vAux.prox != null) {
                        if (!pilha.contains(vAux.prox)) {
                            pilha.push(vAux.prox);
                        }
                        vAux= vAux.prox;
                    }
                    vAux= null;
                    v = listaAdj[v.prox.num-1];
                }
            } else {
                for (int i = 0; i < listaAdj.length; i++) {
                    a.add(listaAdj[i].num);
                }
                if (visitado.containsAll(a) && v.num == raiz) {
                   vertice vertice = listaAdj[visitado.get(visitado.size() - 1)];
                    while (vertice.prox != null) {
                        if (vertice.prox.num == raiz) {
                            visitado.add(v.num);
                            break;
                        }
                        vertice = vertice.prox;
                    }
                }
                a.clear();
                if (!pilha.isEmpty()) {
                    v = listaAdj[pilha.pop().num-1];
                } else {
                    break;
                }
            }
        }
        return visitado;
    }
	
	/**
	 * Acha vertice por busca linear
	 * 
	 * @param lista lista de adjacencias
	 * @param vertice vertice a ser encontrado
	 * @return vertice encontrado ou nulo
	 */
	private vertice achaVertice(List<vertice> lista, int vertice) {
		for(vertice v : lista) {
			if(v.num == vertice) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * Verifica se o grafo é um grafo completo
	 * @return true caso seja, false caso não
	 */
	public boolean verificaGrafoCompleto() {
        boolean comp = true;
        for (int i = 1; i < listaAdj.length; i++) {
            for (int j = 1; j < listaAdj.length; j++) {
                if(i!=j)
                    comp = grafoConexo(i, j);
                if(comp == false){
                    return false;
                }
            }
        }
        return comp;
    }
		
	
	/**
	 * Gera matriz de adjacencias
	 * @return matriz de adjacencias
	 */
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
	
	// CALCULA SE É EULERIANO; 1=EULERIANO, 0=SEMI-EULERIANO, -1=NÃO EULERIANO
	public int grafoEuleriano() {
		int cont = 1;
		if(listaAdj.length%2!=0) {
			cont--;
		}
		for(vertice v : listaAdj) {
			if(v.qtdAresta%2!=0) {
				cont--;
				break;
			}
		}
		
		return cont;

	}
	
	//PRIVATES
	
	private vertice voltaVertice(Stack<Integer> pilha) {
		ArrayList<Integer> v = new ArrayList<Integer>(pilha);
		
		return achaVertice(Arrays.asList(listaAdj), v.get(v.size()-3));
	}
	
	private int qtdArestas(int vertices) {
		if(vertices <= 2) {
			return 1;
		}else {
			return (vertices-1)+qtdArestas(vertices-1);
		}
	}
}
