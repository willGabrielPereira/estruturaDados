package arvore;

public class Nodo {
	public int valor;
	public Nodo direita;
	public Nodo esquerda;
	
	
	/**
	 * @param raiz
	 * @return se maior que 1 ou menor que -1, não é avl por não estar balanceada
	 */
	public int verificaAvl(Nodo raiz) {
		Nodo aux = raiz;
		if(aux.direita!=null && aux.esquerda!=null) {
			return verificaAvl(aux.direita) - verificaAvl(aux.esquerda);
		}else {
			if(aux.direita!=null) {
				return 1+verificaAvl(aux.direita);
			}
			if(aux.esquerda!=null) {
				return 1+verificaAvl(aux.esquerda);
			}
			
			return 0;
		}
	}
	
	public Nodo excluir(Nodo raiz, int valor) {
		Nodo aux = percorre(raiz, valor);
		Nodo auxD = aux.direita;
		Nodo auxE = aux.esquerda;
		
		aux = null;
		
		raiz = inserir(raiz, auxD);
		raiz = inserir(raiz, auxE);
		
		return raiz;
	}
	
	public static Nodo percorre(Nodo raiz, int valor) {
		if(raiz.valor == valor) {
			return raiz;
		}else {
			Nodo aux = null;
			if(raiz.direita!=null) {
				aux = percorre(raiz.direita, valor);
			}
			if(aux==null) {
				return percorre(raiz.esquerda, valor);
			}
			return aux;
			
		}
	}
	
	public static boolean iguais(Nodo raiz1, Nodo raiz2) {
		Nodo aux1 = raiz1;
		Nodo aux2 = raiz2;
		
		if(aux1 == null && aux2 == null) {
			return true;
		}else {
			if(aux1.valor == aux2.valor) {
				if(Nodo.iguais(raiz1.esquerda, raiz2.esquerda) 
						&& Nodo.iguais(raiz1.direita, raiz2.direita)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static Nodo avl2Bin(Avl arvore) {
		Nodo raiz = new Nodo();
		raiz.valor = arvore.valor;
		
		if(raiz != null) {
			if(arvore.direita != null) {
				raiz.alv2BinAdd(arvore.direita){
					
				}
			}
		}
				
		return raiz;
	}
	private static Nodo alv2BinAdd(Nodo pai, Avl nodo) {
		if(pai == null) {
			pai = new Nodo();
			pai.valor = nodo.valor;
		}else {
			Nodo aux = new Nodo();
			aux.valor = nodo.valor;
			inserir(pai, aux);
			if(nodo.direita != null) {
				avl2BinAdd(Nodo.percorre(pai, aux.valor), nodo.direita);
			}
			if(nodo.esquerda != null) {
				avl2BinAdd(Nodo.percorre(pai, aux.valor), nodo.esquerda);
			}
		}
		return pai;
	}
	
	
	
}
