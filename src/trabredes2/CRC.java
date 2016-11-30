package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(String polinomio) {
		Integer[] temp = Util.hexToBinary(polinomio);
		this.polinomio = temp;
	}

	public Integer[] executa(Integer[] msg) {
		int tamMsg = msg.length;
		Integer[] crc = new Integer[8];
		Integer[] msgMultiplicada = new Integer[tamMsg + crc.length];
		boolean msg0 = msgnula(msg);

		// m�todo equivalente a multiplica��o de polin�mios pelo tamanho do
		// polin�mio gerador
		for (int i = 0; i < tamMsg; i++) {
			msgMultiplicada[i] = msg[i];
		}
		//Util.imprimeVetor(msgMultiplicada);
		// padding
		for (int i = tamMsg ; i < (tamMsg + crc.length); i++) {
			msgMultiplicada[i] = 0;
		}
		int ponto1 = 0;
		int j = 0;
		if (!msg0) {
			while (msgMultiplicada[ponto1] != 1) {
				ponto1++;
			}
			while (ponto1 <= msgMultiplicada.length - polinomio.length && !msg0) {
				// posicionamento da vari�vel ponto1 no primeiro �ndice 1 da
				// mensagem
				j = 0;				
				// realiza��o do xOR entre o polinomio gerador e a mensagem
				for (int i = ponto1; i < ponto1 + polinomio.length; i++) {
					msgMultiplicada[i] = getxOR(msgMultiplicada[i], j);
					j++;
				}
				msg0 = msgnula(msgMultiplicada);
				while (msgMultiplicada[ponto1] != 1 && !msg0) {
					ponto1++;
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

	private boolean msgnula(Integer[] msg) {
		for (int i = 0; i < msg.length; i++) {
			if (msg[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private Integer getxOR(Integer msgMultiplicadaIndex, int i) {
		Integer xORResult = msgMultiplicadaIndex == polinomio[i] ? 0 : 1;
		return xORResult;

	}
}
