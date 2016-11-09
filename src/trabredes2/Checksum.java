package trabredes2;

public class Checksum{

	 public static void imprimeVetor(int[]vet){
	        int cont=0;
	        while(cont<vet.length){
	            for(int i=cont;i<8+cont;i++){
	                System.out.print(vet[i] + " ");
	            }
	            cont+=8;
	            if(vet.length > 8){
	                System.out.println("");
	            }
	        }
	        System.out.println("");

	    }
	    
	    public static int getResult(int valor){
	        switch(valor){
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
	    
	    public static int getCarry(int valor){
	        switch(valor){
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
	    
	public static int[] somaC1(int[] pt1Msg, int[] pt2Msg){
        int[] resultadoSomaC1 = new int[8];         
        int[] vetorUnitarioSomaCarry = {0,0,0,0,0,0,0,1};
        int result = 0;
        int carry = 0;
        int valor =0;
        for(int i=7;i>=0;i--){
            valor = pt1Msg[i] + pt2Msg[i] + carry;
            result = getResult(valor);
            carry = getCarry(valor);
            resultadoSomaC1[i] = result;

            if(i==0 && carry == 1){
                result = 0;
                carry = 0;
                valor =0;
                for(int j=7;j>=0;j--){
                    valor = resultadoSomaC1[j] + vetorUnitarioSomaCarry[j] + carry;
                    result = getResult(valor);
                    carry = getCarry(valor);
                    resultadoSomaC1[j] = result;
                }
            }
        }
        return resultadoSomaC1;
    }
	
	public static int[] executa (int[] msg) {
		int[] valorChecksum = new int[8];
        int[] pt1Msg = new int[8];
        int[] pt2Msg = new int[8];
        int[] resSomaC1 = new int[8];
        int nBitsUtilizados = pt1Msg.length + pt2Msg.length;
        int tamMsg = msg.length;
        int j=0;
        //Esse loop armazena os valores referentes aos 2 bytes finais da mensagem
        //formando o primeiro passo do cálculo de Checksum
        //i = 8º byte menos significativo j= índice das partes da mensagem. 
        for (int i=tamMsg-8;i<tamMsg;i++){
            pt1Msg[j] = msg[i];
            pt2Msg[j] = msg[i-8];
            j++;
        }
        System.out.println("");
        System.out.print("1: ");
        imprimeVetor(pt1Msg);
        System.out.print("2: ");
        imprimeVetor(pt2Msg);
        resSomaC1 = somaC1(pt1Msg,pt2Msg);
        System.out.print("3: ");
        imprimeVetor(resSomaC1);
        System.out.println("");
        while(nBitsUtilizados<tamMsg){
           j=0;
            while(j<8){
                pt2Msg[j] = msg[tamMsg-(nBitsUtilizados+8)+j];
                j++;
            }
            nBitsUtilizados+=8;
            System.out.print("1: ");
            imprimeVetor(resSomaC1);
            resSomaC1 = somaC1(resSomaC1,pt2Msg);
            System.out.print("2: ");
            imprimeVetor(pt2Msg);
            System.out.print("3: ");
            imprimeVetor(resSomaC1);
            System.out.println("");
        }

        for(int i=0;i<8;i++){
            valorChecksum[i] = resSomaC1[i] == 0? 1 : 0;
        }
        return valorChecksum;
	}

}
