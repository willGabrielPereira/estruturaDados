package main;

import java.util.Scanner;

import lista.ListaAdjacencia;
import matriz.MatrizAdjacencia;

public class Main {

	public static void main(String[] args) {
		
		int tipo;
		int ponderado;
		int bid;
		int menuR = -1;
		
		StringBuilder menu1 = new StringBuilder();
		menu1.append("Qual o tipo de grafo?\n");
		menu1.append("1-Matriz\n");
		menu1.append("2-Lista");
		
		StringBuilder menu2 = new StringBuilder();
		menu2.append("Ponderado?\n");
		menu2.append("1-Sim\n");
		menu2.append("2-Não");
		
		StringBuilder menu3 = new StringBuilder();
		menu3.append("Bidirecional?\n");
		menu3.append("1-Sim\n");
		menu3.append("2-Não");
		
		StringBuilder menu = new StringBuilder();
		menu.append("0-sair\n");
		menu.append("1-Add aresta\n");
		menu.append("2-Remover aresta\n");
		menu.append("3-Mostrar grafo");
		
		StringBuilder menuLista = new StringBuilder();
		menuLista.append("4-Buscar vertice\n");
		menuLista.append("5-Grafo conexo\n");
		menuLista.append("6-Grafo completo\n");
		menuLista.append("7-Transformar em Matriz de adjacencias");
		menuLista.append("8-Grafo Euleriano\n");
		menuLista.append("9-Mostrar vertices por largura\n");
		menuLista.append("10-Mostrar verticer por profundidade");
		
		String[] deAte = {"de","até"};
		
		
		System.out.println(menu1.toString());
		tipo = ler();
		System.out.println(menu2.toString());
		ponderado = ler();
		System.out.println(menu3.toString());
		bid = ler();
		System.out.println("Quantidade de vertices: ");
		int vert = ler();
		
		ListaAdjacencia lista = new ListaAdjacencia(vert);
		MatrizAdjacencia matriz = new MatrizAdjacencia(vert);
		
		sistema:	// Marcação do loop externo
		while(menuR!=0) {
			System.out.println(menu.toString());
			if(tipo == 2) {
				System.out.println(menuLista.toString());
			}
			menuR = ler();
			
			if(tipo==2) {
				switch(menuR) {
				case 0:
					System.out.println("Saindo....!");
					break sistema;
				case 1:
					//add
					System.out.println(deAte[0]);
					int v1 = ler();
					System.out.println(deAte[1]);
					int v2 = ler();
					int dist=0;
					if(ponderado==1) {
						System.out.println("Distancia:");
						dist = ler();
					}
					
					if(bid == 2) {
						lista.inserirArestaFim(v1, v2, dist);
					}else {
						lista.inserirArestaBidirecional(v1, v2, dist);
					}
					break;
				case 2:
					//remover
					System.out.println(deAte[0]);
					v1 = ler();
					System.out.println(deAte[1]);
					v2 = ler();
					if(bid == 2) {
						lista.removerAresta(v1, v2);
					}else {
						lista.removerArestaBidirecional(v1, v2);
					}
					break;
				case 3:
					System.out.println(lista.toString());
					esperar();
					break;
				case 4:
					System.out.println("Numero do vertice:");
					v1 = ler();
					System.out.println(lista.mostrarVertice(v1));
					esperar();
					break;
				case 5:
					System.out.println(deAte[0]);
					v1 = ler();
					System.out.println(deAte[1]);
					v2 = ler();
					System.out.println(lista.grafoConexo(v1, v2));
					esperar();
					break;
				case 6:
					System.out.println(lista.verificaGrafoCompleto());
					esperar();
					break;
				case 7:
					matriz = lista.montarMatrizAdj();
					tipo = 1;
					break;
				case 8:
					int euler = lista.grafoEuleriano();
					switch(euler) {
					case -1:
						System.out.println("Não euleriano");
						break;
					case 0:
						System.out.println("Semi Euleriano");
						break;
					case 1:
						System.out.println("Euleriano");
						break;
					}
					esperar();
					break;
				case 9:
					System.out.println(deAte[0]);
					v1 = ler();
					System.out.println(lista.buscaPorLargura(v1));
					esperar();
					break;
				case 10:
					//profundidade
					System.out.println(deAte[0]);
					v1 = ler();
					System.out.println(lista.buscaPorProfundidade(v1));
					esperar();
					break;
				default:
					System.out.println("Código não reconhecido!");
				}
			}else {
				switch(menuR) {
				case 0:
					System.out.println("Saindo.....!");
					break sistema;
				case 1:
					//add
					System.out.println(deAte[0]);
					int v1 = ler();
					System.out.println(deAte[1]);
					int v2 = ler();
					
					if(bid == 2) {
						matriz.inserirAresta(v1, v2);
					}else {
						matriz.inserirArestaBidirecional(v1, v2);
					}
					break;
				case 2:
					//remover
					System.out.println(deAte[0]);
					v1 = ler();
					System.out.println(deAte[1]);
					v2 = ler();
					if(bid == 2) {
						matriz.removerAresta(v1, v2);
					}else {
						matriz.removerArestaBidirecional(v1, v2);
					}
					break;
				case 3:
					System.out.println(lista.toString());
					esperar();
					break;
				default:
					System.out.println("Código não reconhecido!");
					esperar();
				}
			}
			
		}

	}
	public static int ler() {
		Scanner ler = new Scanner(System.in);
		return Integer.parseInt(ler.nextLine());
	}
	public static void esperar() {
		System.out.print("\nClique para continuar..");
		Scanner ler = new Scanner(System.in);
		ler.nextLine();
	}

}
