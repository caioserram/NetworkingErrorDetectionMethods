package trabredes2;

import java.util.Random;

public class MessageManager {
	
	public static Integer[] geraMensagem(int tamanho, long seed) {
		Random gerador = new Random(seed);
        Integer[] msg = new Integer[tamanho*8];
        for(int i=0; i<msg.length ; i++){
            msg[i] = gerador.nextInt(100) > 65 ? 1 : 0;
        }
//        Util.imprimeVetor(msg);
		return msg;
	}
	
	public static Integer[] insereErro(Integer[] msg ,double probabilidade,long seed){
		Random gerador = new Random(seed);
		int contagemErros = 0;
		Integer[] msgComErros = new Integer[msg.length];
		for(int i = 0; i<msgComErros.length;i++){
			msgComErros[i] = 0;
		}
		while(contagemErros<=0){
			for(int i=0;i<msg.length;i++){
				double randomDouble = gerador.nextDouble();
				if(randomDouble<=probabilidade){
					if(msg[i]==0){
						msgComErros[i] =0;
					}
					else{
						msgComErros[i] =1;
					}
					contagemErros++;
				}
			}
		}
		//System.out.println(msgComErros.length-msg.length);
		return msgComErros;
	}

	public static boolean comparaVetor(Integer[] vet1, Integer[] vet2) {

		for(int i=0;i<vet1.length;i++){
			if(vet1[i] != vet2[i]){
				return false;
			}
		}
		return true;
	}
	
}
