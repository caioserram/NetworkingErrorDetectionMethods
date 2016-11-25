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
        teclado = new Scanner(System.in);
        System.out.println("Digite o tamanho da mensagem em bytes: ");
        int tamanho = teclado.nextInt();
        System.out.println("Digite a seed do gerador aleatório:");
        int seed = teclado.nextInt();
        Integer[] msg = MessageManager.geraMensagem(tamanho,seed); 
        System.out.print("Msg: ");
        System.out.println("");
        Util.imprimeVetor(msg);
        Integer[]chechsumMensagem = Checksum.executa(msg);
        System.out.print("resultado: ");
        Util.imprimeVetor(chechsumMensagem);
    }
    
}
