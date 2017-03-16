package it.peruvianit.test.util;

import static org.junit.Assert.fail;

import org.junit.Test;

import it.peruvianit.commons.cryptography.EncryptorAdapter;

public class EncryptorAdapterTest {

	@Test
	public void test() {
		
		try {
			EncryptorAdapter encryptorAdapter = new EncryptorAdapter();
			
			System.out.println(encryptorAdapter.encrypt("12345678"));
			
			System.out.println(encryptorAdapter.checkPassword("12345678", "2Kk/qXpM2wujSxtMUct0FJZzEM8r+6OA"));
		} catch (Exception e) {
			fail("problemi con l'invio dell'email");
		}
	}
}
