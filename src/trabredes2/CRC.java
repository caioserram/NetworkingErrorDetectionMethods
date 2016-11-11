package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(Integer[] polinomio) {
		this.polinomio = polinomio;
	}

	public static void imprimeVetor(Integer[] vet) {
		int cont = 0;
		while (cont < vet.length) {
			for (int i = cont; i < 8 + cont; i++) {
				System.out.print(vet[i] + " ");
			}
			cont += 8;
			if (vet.length > 8) {
				System.out.println("");
			}
		}
		System.out.println("");

	}
	
	public Integer[] executa(Integer[] msg) {
		int tamMsg = msg.length;
		int j = 0;
		Integer[] msgMultiplicada = new Integer[tamMsg+8];
		int ponto1= 0;
		Integer[] crc = new Integer[8];
		//método equivalente a multiplicação de polinômios pelo tamanho do polinômio gerador
		for(int i=0;i<tamMsg+8;i++){
			if(i<tamMsg)
				msgMultiplicada[i]=msg[i];
			else{
				msgMultiplicada[i]=0;
			}
		}		
		while(ponto1 < msgMultiplicada.length-8){
			j=0;
			//realização do xOR entre o polinomio gerador e a mensagem
			for(int i=ponto1;i<ponto1+8;i++){
				msgMultiplicada[i] = getxOR(msgMultiplicada[i],j);
				j++;
			}
			//posicionamento da variável ponto1 no primeiro índice 1 da mensagem
			while(msgMultiplicada[ponto1]!=1){
				ponto1++;
			}
		}
		j=0;

		//crc pega os últimos 8 bits da mensagemMultilplicada
		for(int i=msgMultiplicada.length-8;i<msgMultiplicada.length;i++){
			crc[j]=msgMultiplicada[i];
			j++;
		}
		return crc;
	}
	
	private Integer getxOR(Integer msgMultiplicada,int i) {
		Integer xORResult = msgMultiplicada == polinomio[i]? 0:1;
		return xORResult;
				
	}
}
