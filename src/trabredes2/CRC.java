package trabredes2;

public class CRC {

	Integer[] polinomio;

	public CRC(Integer[] polinomio) {
		this.polinomio = polinomio;
	}

	public Integer[] executa(Integer[] msg) {
		// Integer[]vet = new Integer[];
		//uma opcao de vetor padronizado : 00010101
		int tamMsg = msg.length;
		Integer[] msgCopy = new Integer[tamMsg+8];
		int ponto1= 0;
		for(int i=0;i<tamMsg+8;i++){
			if(i<tamMsg)
				msgCopy[i]=msg[i];
			else{
				msgCopy[i]=0;
			}
		}			
		while(ponto1>msgCopy.length-8){
			while(msgCopy[ponto1]!=1){
				ponto1++;
			}
			for(int i=ponto1;i<ponto1+8;i++){
				msgCopy[i] = getXor(msgCopy[i],i);
			}
		}
		int j=0;
		Integer[] crc = new Integer[8];
		for(int i=msgCopy.length-1;i>msgCopy.length-8;i--){
			crc[j]=msgCopy[i];
			j++;
		}
		return crc;
	}
	
	private Integer getXor(Integer msgCopy,int i) {
		Integer xORResult = msgCopy == polinomio[i]? 0:1;
		return xORResult;
				
	}
}
