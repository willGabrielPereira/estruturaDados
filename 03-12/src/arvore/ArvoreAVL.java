package arvore;

import java.util.*;

public class ArvoreAVL {

    private static class ARVORE {

        int num, altd, alte;
        public ARVORE dir, esq;

    }

    public static ARVORE inserir(ARVORE aux, int num) {
        //o objeto novo é um objeto auxiliar
        ARVORE novo;
        if (aux == null) {
            novo = new ARVORE();
            novo.num = num;
            novo.altd = 0;
            novo.alte = 0;
            novo.esq = null;
            novo.dir = null;
            aux = novo;
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
            if (aux.esq.altd > aux.esq.alte) {
                aux.alte = aux.esq.altd + 1;
            } else {
                aux.alte = aux.esq.alte + 1;
            }
           // aux = balanceamento(aux);
        } else {
            aux.dir = inserir(aux.dir, num);
            if (aux.dir.altd > aux.dir.alte) {
                aux.altd = aux.dir.altd + 1;
            } else {
                aux.altd = aux.dir.alte + 1;
            }
            //aux = balanceamento(aux);
        }
        return aux;
    }

    public static ARVORE balanceamento(ARVORE aux) {
        int d, df;
        d = aux.altd - aux.alte;
        if (d == 2) {
            df = aux.dir.altd - aux.dir.alte;
            if (df >= 0) {
                aux = rotacao_esquerda(aux);
            } else {
                aux.dir = rotacao_direita(aux.dir);
                aux = rotacao_esquerda(aux);
            }
        } else if (d == -2) {
            df = aux.esq.altd - aux.esq.alte;
            if (df <= 0) {
                aux = rotacao_direita(aux);
            } else {
                aux.esq = rotacao_esquerda(aux.esq);
                aux = rotacao_direita(aux);
            }
        }
        return aux;
    }

    public static ARVORE rotacao_esquerda(ARVORE aux) {
        ARVORE aux1, aux2;
        aux1 = aux.dir;
        aux2 = aux1.esq;
        aux.dir = aux2;
        aux1.esq = aux;
        if (aux.dir == null) {
            aux.altd = 0;
        } else if (aux.dir.alte > aux.dir.altd) {
            aux.altd = aux.dir.alte + 1;
        } else {
            aux.altd = aux.dir.altd + 1;
        }
        if (aux1.esq.alte > aux1.esq.altd) {
            aux1.alte = aux1.esq.alte + 1;
        } else {
            aux1.alte = aux1.esq.altd + 1;
        }
        return aux1;
    }

    public static ARVORE rotacao_direita(ARVORE aux) {
        ARVORE aux1, aux2;
        aux1 = aux.esq;
        aux2 = aux1.dir;
        aux.esq = aux2;
        aux1.dir = aux;
        if (aux.esq == null) {
            aux.alte = 0;
        } else if (aux.esq.alte > aux.esq.altd) {
            aux.alte = aux.esq.alte + 1;
        } else {
            aux.alte = aux.esq.altd + 1;
        }
        if (aux1.dir.alte > aux1.dir.altd) {
            aux1.altd = aux1.dir.alte + 1;
        } else {
            aux1.altd = aux1.dir.altd + 1;
        }
        return aux1;
    }

    public static void exibiremordem(ARVORE aux) {
        if (aux != null) {
            exibiremordem(aux.esq);
            System.out.println(aux.num + " ");
            exibiremordem(aux.dir);
        }
    }

    public static void exibirpreordem(ARVORE aux) {
        if (aux != null) {
            System.out.print(aux.num + " ");
            exibirpreordem(aux.esq);
            exibirpreordem(aux.dir);
        }
    }

    public static void exibirposordem(ARVORE aux) {
        if (aux != null) {
            exibirposordem(aux.esq);
            exibirposordem(aux.dir);
            System.out.print(aux.num + " ");
        }
    }
    //M�TODO DE BUSCA EM LARGURA QUE MOSTRA OS ELEMENTOS POR N�VEL BREADTH-FIRST SEARCH

    public static void buscarLargura(ARVORE raiz) {
        Queue<ARVORE> q = new LinkedList<ARVORE>();
        if (raiz == null) {
            return;
        }
        q.add(raiz);
        while (!q.isEmpty()) {
            ARVORE n = (ARVORE) q.remove();
            System.out.print(" " + n.num);
            if (n.esq != null) {
                q.add(n.esq);
            }
            if (n.dir != null) {
                q.add(n.dir);
            }
        }
    }
    /**
     * @param raiz
     * @return se maior que 1 ou menor que -1, não é avl por não estar
     * balanceada
     */
    public static int verificaAvl(ARVORE raiz) {
        ARVORE aux = raiz;
        if (aux.dir != null && aux.esq != null) {
            return verificaAvl(aux.dir) - verificaAvl(aux.esq);
        } else {
            if (aux.dir != null) {
                return 1+verificaAvl(aux.dir);
            }
            if (aux.esq != null) {
                return 1+verificaAvl(aux.esq);
            }
            return 0;
        }
    }
    
    public static void main(String[] args) {
        ARVORE a = null;
        a = inserir(a, 10);
        a = inserir(a, 11);
        a = inserir(a, 12);
        a = inserir(a, 13);
        System.out.println(ArvoreAVL.verificaAvl(a));
        //exibirpreordem(a);
        //exibiremordem(a);
    }

}
