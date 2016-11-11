package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.CRC;

public class CRCTest {

	@Test
	public void test() {
		//polinomio 10010101
		Integer[] polinomio = {1,0,0,1,0,1,0,0,0,1,0,0,1,1,0,1,0};
		CRC crc = new CRC(polinomio);
		final Integer[] vetor = {1,0,1,1,0,1,0,1};//B5AE
		assertEquals("[1, 0, 1, 0, 1, 0, 0, 0]",Arrays.toString(crc.executa(vetor)));
	}
}
