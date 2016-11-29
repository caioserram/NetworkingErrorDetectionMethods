package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.CRC;
import trabredes2.Qualquernometemporario;



public class CRCTest {

	@Test
	public void test() {
		//polinomio 10010101
		final Integer[] vetor = {1,1,1,0,0,0,0,1};//B5AE
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[1, 0, 0, 0, 1, 0, 0, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void SimuladorCRCtest() {
		//polinomio 10010101
	}
}
