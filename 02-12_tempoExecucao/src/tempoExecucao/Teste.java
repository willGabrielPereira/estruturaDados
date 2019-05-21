/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempoExecucao;
import java.util.*;
/**
 *
 * @author julia.rosa
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random gerador = new Random();
        int TAM = 10;
        int V[] = new int[TAM];
        int np, achou = 0, i=0;
        
        for(int i1 =0; i1<TAM;i1++){
            V[i1]=gerador.nextInt(TAM);
        }
        
        System.out.println("Digite número a ser buscado no vetor: ");
        np = -9;
        int totalComparacoes = 0;
        long inicio = System.currentTimeMillis();
        while(i<TAM){
            totalComparacoes++;
            if(V[i]==np){
                achou = 1;
                break;
            }
            i++;
        }
        if(achou ==1){
            System.out.println("Número encontrado na posição: "+i);
        }else{
            System.out.println("Número não encontrado!");
            long fim = System.currentTimeMillis() - inicio;
            System.out.println("Tempo de execução = "+fim);
            System.out.println("Total comparações = "+totalComparacoes);
        }
    }
    
}
