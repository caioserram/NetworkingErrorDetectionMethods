package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(Integer[] polinomio) {
		this.polinomio = polinomio;
	}

	public Integer[] executa(Integer[] msg) {
		// Integer[]vet = new Integer[];
		int i;
		int j;
		int k;
		i = 0;
		j = 0;
		k = 0;
		while (i < msg.length) {
			while (msg[i] != 0) {
				i++;
			}
			for (k = 0; k < pGerador.length; k++) {
				// rever
				int a = msg[i] ^ pGerador[j];
			}
		}

		return msg;

	}

}
