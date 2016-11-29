/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabredes2;

import java.util.Scanner;

/**
 *
 * @author caios_000
 */
public class Qualquernometemporario {

    private static Scanner teclado;
    
    public static void main(String[] args) {
    	int tamanho = Integer.parseInt(args[1]);
    	int npacotes = Integer.parseInt(args[2]);
    	int seed = Integer.parseInt(args[3]);
    	double probabilidade = Double.parseDouble(args[4]);
    	int contaErro = 0;
    	if(args[0].equalsIgnoreCase("csum") || args[0].equalsIgnoreCase("checksum")){
    		for(int i = 0;i<npacotes;i++){
    			 Integer[] msg = MessageManager.geraMensagem(tamanho,seed); 
    	         Integer[]checksumMensagem = Checksum.executa(msg);
    		}
    	}
    	if(args[0].equalsIgnoreCase("crc")){
    		CRC crc = new CRC(args[5]);
    		
    		for(int i = 0;i<npacotes;i++){
	   			Integer[] msg = MessageManager.geraMensagem(tamanho,seed); 
	   			Integer[] crcMensagem = crc.executa(msg);	   	
	   			Integer[] msgErro = MessageManager.insereErro(msg,probabilidade, seed);
	   			Integer[] crcMensagemErro = crc.executa(msgErro);
	   			boolean erro = MessageManager.comparaVetor(crcMensagem,crcMensagemErro);
	   			if (erro){
	   				contaErro++;
	   			}
    		}
    		System.out.println((contaErro/npacotes)*100);
    	}
        
    }
    
}
