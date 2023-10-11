import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
	
	@Test
	public void testCaesarEncryption() {
		assertEquals("[,]\"#'_^_-", CryptoManager.caesarEncryption("ARCHIMEDES", 90));
	}
	
	@Test
	public void testCaesarDecryption() {
		assertEquals("CAESAR CIPHER", CryptoManager.caesarDecryption("JHLZHY'JPWOLY", 7));
	}
	
	@Test
	public void testBellasoEncryption() {
		assertEquals("KR_OR", CryptoManager.bellasoEncryption("HELLO", "CMSC"));
		assertEquals("The selected string is not in bounds, Try again." , CryptoManager.bellasoEncryption("!%4A[\\~%%!", "CMSC"));
		assertEquals("XXIK[[", CryptoManager.bellasoEncryption("ROBERT", "FIG"));
	}
	
	@Test
	public void testBellasoDecryption() {
		assertEquals("ROBERT", CryptoManager.bellasoDecryption("XXIK[[", "FIG"));
	}

}
