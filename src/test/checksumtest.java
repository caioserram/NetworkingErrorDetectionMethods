package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.Checksum;

public class checksumtest {
	@Test
	public void test() {
		final Integer[] vetor = {0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0};
		assertEquals("[1, 1 ,1, 1, 1, 1, 0, 1]",Arrays.toString(Checksum.executa(vetor)));
	}
}
