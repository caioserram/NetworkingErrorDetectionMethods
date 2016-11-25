package test;

import org.junit.Test;

import trabredes2.Util;

public class hextobinTest {

	@Test
	public void test() {
		String s="121";
		Util.imprimeVetor(Util.hexToBinary(s));
	}
	
}
