package projeto3;
import java.util.Random;
public class Algoritmo {
	public static Random r = new Random();
	
	public static void main(String[] args) {
		final int TAM = 1000;
		int[] vet = new int[TAM];
		
		for(int x=0; x<TAM; x++) {
			vet[x] = r.nextInt(2000);
		}
		long tempoInicio = System.currentTimeMillis();

		int procura = 1000;
		int[] achou = new int[2];
		for(int i=0; i<TAM; i++) {
			for(int j=0; j<TAM; j++) {
				if(vet[i]+vet[j] == procura) {
					achou[0] = vet[i];
					achou[1] = vet[j];
					break;
				}
			}
		}
		
		System.out.println(achou[0]+" "+achou[1]);
		
		
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio)+"ms");
	}
}
