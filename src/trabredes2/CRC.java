package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(Integer[] polinomio) {
		this.polinomio = polinomio;
	}
	
	public Integer[] executa(Integer[] msg) {
		int tamMsg = msg.length;
		int j = 0;
		Integer[] msgMultiplicada = new Integer[tamMsg+8];
		int ponto1= 0;
		Integer[] crc = new Integer[8];
		//m�todo equivalente a multiplica��o de polin�mios pelo tamanho do polin�mio gerador
		for(int i=0;i<tamMsg+crc.length;i++){
			if(i<tamMsg)
				msgMultiplicada[i]=msg[i];
			else{
				msgMultiplicada[i]=0;
			}
		}		
		while(ponto1 <= msgMultiplicada.length-polinomio.length){
			j=0;
			//realiza��o do xOR entre o polinomio gerador e a mensagem
			for(int i=ponto1;i<ponto1+polinomio.length;i++){
				msgMultiplicada[i] = getxOR(msgMultiplicada[i],j);
				j++;
			}
			//posicionamento da vari�vel ponto1 no primeiro �ndice 1 da mensagem
			while(msgMultiplicada[ponto1]!=1){
				ponto1++;
			}
		}
		j=0;

		//crc pega os �ltimos 8 bits da mensagemMultilplicada
		for(int i=msgMultiplicada.length-crc.length;i<msgMultiplicada.length;i++){
			crc[j]=msgMultiplicada[i];
			j++;
		}
		return crc;
	}
	
	private Integer getxOR(Integer msgMultiplicadaIndex,int i) {
		Integer xORResult = msgMultiplicadaIndex == polinomio[i] ? 0:1;
		return xORResult;
				
	}
}
