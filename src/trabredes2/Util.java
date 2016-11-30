package trabredes2;

public class Util {
	public static void imprimeVetor(Integer[] vet) {
		for(int i=0;i<vet.length;i++){
			System.out.print(vet[i]);
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
