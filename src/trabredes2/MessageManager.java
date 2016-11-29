package trabredes2;

import java.util.Random;

public class MessageManager {
	
	public static Integer[] geraMensagem(int tamanho, int seed) {
		Random gerador = new Random(seed);
        Integer[] msg = new Integer[tamanho*8];
        for(int i=0; i<msg.length ; i++){
            msg[i] = gerador.nextInt(100) > 65 ? 1 : 0;
        }
		return msg;
	}
	
	public static Integer[] insereErro(Integer[] msg ,double probabilidade,int seed){
		Random gerador = new Random(seed);
		int contagemErros = 0;
		Integer[] msgComErros = new Integer[msg.length];
		while(contagemErros<=0){
			for(int i=1;i<msg.length;i++){
				double randomDouble = gerador.nextDouble();
				if(randomDouble<=probabilidade){
					msgComErros[i] = msg[i] == 0?1:0;
					contagemErros++;
				}
			}
		}
		return msgComErros;
	}

	public static boolean comparaVetor(Integer[] vet1, Integer[] vet2) {

		for(int i=0;i<vet1.length;i++){
			if(vet1[i] != vet2[i]){
				return true;
			}
		}
		return false;
	}
	
}
