package projeto2;
import java.util.Random;
public class Algoritmo {
	public static Random r = new Random();
	
	public static void main(String[] args) {
		final int TAM = 1000000;
		int[] vet = new int[TAM];
		
		for(int x=0; x<TAM; x++) {
			vet[x] = r.nextInt();
		}
		long tempoInicio = System.currentTimeMillis();
		
		
		quickSort(vet,0,vet.length-1);
		int[] vetor = new int[10];
		System.arraycopy(vet, vet.length-10, vetor, 0, 10);
		
		
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio)+"ms");
	}
	
	private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
               int posicaoPivo = separar(vetor, inicio, fim);
               quickSort(vetor, inicio, posicaoPivo - 1);
               quickSort(vetor, posicaoPivo + 1, fim);
        }
	}
	
	private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
               if (vetor[i] <= pivo)
                      i++;
               else if (pivo < vetor[f])
                      f--;
               else {
                      int troca = vetor[i];
                      vetor[i] = vetor[f];
                      vetor[f] = troca;
                      i++;
                      f--;
               }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
  }
}
