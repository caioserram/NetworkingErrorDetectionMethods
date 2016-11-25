package trabredes2;

public class Util {
	public static void imprimeVetor(Integer[] vet) {
		int cont = 0;
		while (cont < vet.length) {
			for (int i = cont; i < vet.length + cont; i++) {
				System.out.print(vet[i] + " ");
			}
			cont += vet.length;
			if (vet.length > 8) {
				System.out.println("");
			}
		}
		System.out.println("");

	}
	
	public static Integer[] hexToBinary(String hex) {
		Integer inteiro = Integer.parseInt(hex,16);
		String bin = Integer.toBinaryString(inteiro);
		char[] arrayValores = bin.toCharArray();
		Integer[] valorInteiros = new Integer[bin.length()];
		for (int i = 0; i < arrayValores.length; i++) 
		{
			valorInteiros[i] = Integer
					.parseInt(String.valueOf(arrayValores[i]));
		}
	    return valorInteiros;
	}   
}
