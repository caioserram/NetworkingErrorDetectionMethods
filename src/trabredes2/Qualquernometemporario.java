/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabredes2;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.IntStream;

/**
 *
 * @author caios_000
 */
public class Qualquernometemporario {

    private static Scanner teclado;
    
    public static void main(String[] args) {
        Random gerador = new Random(System.currentTimeMillis());
        teclado = new Scanner(System.in);
        int rand;
        System.out.println("Digite o tamanho da mensagem em bytes: ");
        int tamanho = teclado.nextInt();
        Integer[] msg = new Integer[tamanho*8];
        for(int i=0; i<msg.length ; i++){
            rand = gerador.nextInt(100);
            msg[i] = rand > 65 ? 1 : 0;
        } 
        System.out.print("Msg: ");
        System.out.println("");
        imprimeVetor(msg);
        Integer[]chechsumMensagem = Checksum.executa(msg);
        System.out.print("resultado: ");
        imprimeVetor(chechsumMensagem);
    } 
    
    public static void imprimeVetor(Integer[]vet){
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
}
