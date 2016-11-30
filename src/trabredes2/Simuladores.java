/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabredes2;

/**
 *
 * @author caios_000
 */
public class Simuladores {


	public static void main(String[] args)  {
		int tamanho = Integer.parseInt(args[1]);
		double npacotes = Double.parseDouble(args[2]);
		long seed = Long.parseLong(args[3]);// Integer.parseInt(args[3]);
		double probabilidade = Double.parseDouble(args[4]);
		double contaErro = 0;
		if (args[0].equalsIgnoreCase("csum") || args[0].equalsIgnoreCase("checksum")) {
			for (int i = 0; i < npacotes; i++) {
				Integer[] msg = MessageManager.geraMensagem(tamanho, seed++);
				Util.imprimeVetor(msg);
				Integer[] checksumMensagem = Checksum.executa(msg);
				Integer[] msgErro = MessageManager.insereErro(msg, probabilidade, seed);
				Util.imprimeVetor(msgErro);
				Integer[] checksumMensagemErro = Checksum.executa(msgErro);
				boolean erro = MessageManager.comparaVetor(checksumMensagem, checksumMensagemErro);
				if (erro) {
					contaErro++;
				}
			}
			System.out.println("Porcentagem de erros: " + (contaErro / npacotes) * 100.0+ "%");
		}
		if (args[0].equalsIgnoreCase("crc")) {
			CRC crc = new CRC(args[5]);
			for (int i = 0; i < npacotes; i++) {
				Integer[] msg = MessageManager.geraMensagem(tamanho, seed++);
				Util.imprimeVetor(msg);
				Integer[] crcMensagem = crc.executa(msg);
				//Util.imprimeVetor(crcMensagem);
				Integer[] msgErro = MessageManager.insereErro(msg, probabilidade, seed);
				Integer[] crcMensagemErro = crc.executa(msgErro);
				//Util.imprimeVetor(crcMensagemErro);
				boolean erro = MessageManager.comparaVetor(crcMensagem, crcMensagemErro);
				if (erro) {
					//System.out.print("msg: ");Util.imprimeVetor(msg);
					//System.out.print("crcmsg: ");Util.imprimeVetor(crcMensagem);
					//00011010
					//System.out.print("msgErro: ");Util.imprimeVetor(msgErro);
					//System.out.print("crcmsgErro: ");Util.imprimeVetor(crcMensagemErro);
					contaErro++;
				}
			}
			System.out.println("Porcentagem de erros: " + ((contaErro / npacotes) * 100) + "%");
		}

	}

}
