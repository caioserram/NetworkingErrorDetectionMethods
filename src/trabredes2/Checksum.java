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
	    
	public static int[] somaC1(int[] pt1, int[] pt2){
        int[] temp = new int[8];         
        int[] vet1 = {0,0,0,0,0,0,0,1};
        int result = 0;
        int carry = 0;
        int valor =0;
        for(int i=7;i>=0;i--){
            valor = pt1[i] + pt2[i] + carry;
            result = getResult(valor);
            carry = getCarry(valor);
            temp[i] = result;

            if(i==0 && carry == 1){
                result = 0;
                carry = 0;
                valor =0;
                for(int j=7;j>=0;j--){
                    valor = temp[j] + vet1[j] + carry;
                    result = getResult(valor);
                    carry = getCarry(valor);
                    temp[j] = result;
                }
            }
        }
        return temp;
    }
	
	public static int[] executa (int[] msg) {
		int[] valorChecksum = new int[8];
        int[] pt1 = new int[8];
        int[] pt2 = new int[8];
        int[] resultado = new int[8];
        int tam = pt1.length + pt2.length;
        int tamMsg = msg.length;
        int j=0;
        for (int i=tamMsg-8;i<tamMsg;i++){
            pt1[j] = msg[i];
            pt2[j] = msg[i-8];
            j++;
        }
        System.out.println("");
        System.out.print("1: ");
        imprimeVetor(pt1);
        System.out.print("2: ");
        imprimeVetor(pt2);
        resultado = somaC1(pt1,pt2);
        System.out.print("3: ");
        imprimeVetor(resultado);
        System.out.println("");
        while(tam<tamMsg){
           j=0;
            while(j<8){
                pt2[j] = msg[tamMsg-(tam+8)+j];
                j++;
            }
            tam+=8;
            System.out.print("1: ");
            imprimeVetor(resultado);
            resultado = somaC1(resultado,pt2);
            System.out.print("2: ");
            imprimeVetor(pt2);
            System.out.print("3: ");
            imprimeVetor(resultado);
            System.out.println("");
        }

        for(int i=0;i<8;i++){
            valorChecksum[i] = resultado[i] == 0? 1 : 0;
        }
        return valorChecksum;
	}

}
