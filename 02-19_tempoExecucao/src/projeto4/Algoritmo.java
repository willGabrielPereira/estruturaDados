package projeto4;
import java.util.Random;
public class Algoritmo {
	public static Random r = new Random();
	
	public static void main(String[] args) {
		final int TAM = 10000;
		int[] vet = new int[TAM];
		
		for(int x=0; x<TAM; x++) {
			vet[x] = r.nextInt(2000);
		}
		long tempoInicio = System.currentTimeMillis();
		
		int k = 1000000;
		
		int ant = -1;
		int aux;
		for(int i=0; i<TAM; i++) {
			if(vet[i]<=k) {
				aux = vet[ant+1];
				vet[ant+1] = vet[i];
				vet[i] = aux;
				ant++;
			}
		}
		
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio)+"ms");
	}
}
