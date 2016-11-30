package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.CRC;



public class CRCTest {

	@Test
	public void startsWithOneTest() {
		//polinomio 10010101
		final Integer[] vetor = {1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0};//B5AE
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 1, 1, 0, 1, 0, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void startsWithZeroTest() {
		//polinomio 10010101
		final Integer[] vetor = {0,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0};//35AE
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[1, 1, 0, 0, 0, 0, 0, 1]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void AllOneTest() {
		final Integer[] vetor = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//FFFF
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 0, 1, 1, 0, 0, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void AllZeroTest() {
		final Integer[] vetor = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//B5AE
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void ErrorTest() {
		final Integer[] vetor = {1,0,0,0,1,0,1,1,1,0,0,1,1,0,0,0};//B5AE
		String polinomio = "121";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0]",Arrays.toString(crc.executa(vetor)));
	}
}
