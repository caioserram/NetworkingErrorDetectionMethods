package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(String polinomio) {
		Integer[] temp = Util.hexToBinary(polinomio);
		this.polinomio = temp;
	}

	public Integer[] executa(Integer[] msg) {
		int tamMsg = msg.length;
		int j = 0;
		Integer[] msgMultiplicada = new Integer[tamMsg + 8];
		int ponto1 = 0;
		Integer[] crc = new Integer[8];
		// m�todo equivalente a multiplica��o de polin�mios pelo tamanho do
		// polin�mio gerador

		for (int i = 0; i < tamMsg; i++) {
			msgMultiplicada[i] = msg[i];
		}

		for (int i = tamMsg - 1; i < tamMsg + crc.length; i++) {
			msgMultiplicada[i] = 0;
		}
		Util.imprimeVetor(msgMultiplicada);
		while (ponto1 <= msgMultiplicada.length - polinomio.length) {

			j = 0;
			// realiza��o do xOR entre o polinomio gerador e a mensagem
			for (int i = ponto1; i < ponto1 + polinomio.length; i++) {
				msgMultiplicada[i] = getxOR(msgMultiplicada[i], j);
				j++;
			}

			// posicionamento da vari�vel ponto1 no primeiro �ndice 1 da
			// mensagem
			
			while (msgMultiplicada[ponto1] != 1) {
				ponto1++;
				if(ponto1>=msgMultiplicada.length){
					break;
				}
			}

		}
		j = 0;

		// crc pega os �ltimos 8 bits da mensagemMultilplicada
		for (int i = msgMultiplicada.length - crc.length; i < msgMultiplicada.length; i++) {
			crc[j] = msgMultiplicada[i];
			j++;
		}
		return crc;
	}

	private Integer getxOR(Integer msgMultiplicadaIndex, int i) {
		Integer xORResult = msgMultiplicadaIndex == polinomio[i] ? 0 : 1;
		return xORResult;

	}
}
