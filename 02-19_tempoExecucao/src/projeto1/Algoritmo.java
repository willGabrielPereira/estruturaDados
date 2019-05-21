package projeto1;
import java.util.Random;
public class Algoritmo {
	public static Random r = new Random();
	
	public static void main(String[] args) {
		final int TAM = 100000;
		int[] vet = new int[TAM];
		
		for(int x=0; x<TAM; x++) {
			vet[x] = r.nextInt(11);
		}
		long tempoInicio = System.currentTimeMillis();
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM-1; j++) {
				if(vet[j] > vet[j+1]) {
					int aux = vet[j];
					vet[j] = vet[j+1];
					vet[j+1] = aux;
				}
			}
		}
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio)+"ms");
	}
}
