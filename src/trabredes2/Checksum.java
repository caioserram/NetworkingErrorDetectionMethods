package trabredes2;

public class Checksum {

	public static int getResult(int valor) {
		switch (valor) {
		case 1:
			return 1;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return 0;

		}
	}

	public static int getCarry(int valor) {
		switch (valor) {
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 1;
		default:
			return 0;
		}
	}

	public static Integer[] somaC1(Integer[] pt1Msg, Integer[] pt2Msg) {
		Integer[] resultadoSomaC1 = new Integer[8];
		Integer[] vetorUnitarioSomaCarry = { 0, 0, 0, 0, 0, 0, 0, 1 };
		int result = 0;
		int carry = 0;
		int valor = 0;
		for (int i = 7; i >= 0; i--) {
			int valor1 = pt1Msg[i].intValue();
			int valor2 = pt2Msg[i].intValue();
			valor = valor1 + valor2 + carry;
			result = getResult(valor);
			carry = getCarry(valor);
			resultadoSomaC1[i] = result;

			if (i == 0 && carry == 1) {
				result = 0;
				carry = 0;
				valor = 0;
				for (int j = 7; j >= 0; j--) {
					
					valor = resultadoSomaC1[j].intValue() + vetorUnitarioSomaCarry[j].intValue() + carry;
					result = getResult(valor);
					carry = getCarry(valor);
					resultadoSomaC1[j] = result;
				}
			}
		}
		return resultadoSomaC1;
	}
	
	public static Integer[] executa(Integer[] msg) {
		Integer[] valorChecksum = new Integer[8];
		Integer[] pt1Msg = new Integer[8];
		Integer[] pt2Msg = new Integer[8];
		Integer[] resSomaC1 = new Integer[8];
		int nBitsUtilizados = pt1Msg.length + pt2Msg.length;
		int tamMsg = msg.length;
		int j = 0;
		// Esse loop armazena os valores referentes aos 2 bytes finais da
		// mensagem
		// formando o primeiro passo do cálculo de Checksum
		// i = 8º byte menos significativo j= índice das partes da mensagem.
		for (int i = tamMsg - 8; i < tamMsg; i++) {
			pt1Msg[j] = msg[i];
			pt2Msg[j] = msg[i - 8];
			j++;
		}
		while (nBitsUtilizados < tamMsg) {
			j = 0;
			while (j < 8) {
				pt2Msg[j] = msg[tamMsg - (nBitsUtilizados + 8) + j];
				j++;
				nBitsUtilizados += 8;
			}
		}
		for (int i = 0; i < 8; i++) {
			valorChecksum[i] = resSomaC1[i] == 0 ? 1 : 0;
		}
		return valorChecksum;
	}
}
