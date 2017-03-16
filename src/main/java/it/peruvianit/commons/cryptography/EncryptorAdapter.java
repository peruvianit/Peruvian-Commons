/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.cryptography;

import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 * <p>Classe che utilizza la libreria jasypt per la encriptazione e desencriptazione .</p>
 * 
 * @since 1.0
 *
 */
public class EncryptorAdapter {
   private BasicPasswordEncryptor encryptor;
   

	/**
    * <p>Construisce una nuova {@code EncryptorAdapter}.</p>
    */
   public EncryptorAdapter() {
      encryptor = new BasicPasswordEncryptor();
   }

   /**
	 * <p>Ritorna sempre una stringa diversa encriptada.</p>
	 * 
	 * <pre>
	 * 	EncryptorAdapter encryptorAdapter = new EncryptorAdapter();
	 *	System.out.println(encryptorAdapter.encrypt("12345678"));
	 *  
	 *  result : "/p+TDeIoGSwKcgzcFrQw0J3efJYSnedi"
	 * </pre>
	 * @param message Stringa da criptare.
	 * 
	 * @return Stringa encriptada
	 * 
	 * @since 1.0
	 */
   public String encrypt(String message) {
      return encryptor.encryptPassword(message);
   }

   /**
	 * <p>Ritorna se la stringa {@code plaonPassword} corresponde a la stringa encriptada.</p>
	 * 
	 * <pre>
	 * 	EncryptorAdapter encryptorAdapter = new EncryptorAdapter();
	 *	System.out.println(encryptorAdapter.checkPassword("12345678", "2Kk/qXpM2wujSxtMUct0FJZzEM8r+6OA"));
	 *  
	 *  result : "true"
	 * </pre>
	 * @param plainPassword Stringa in input per controllare.
	 * @param encryptedPassword Stringa encriptada.
	 * 
	 * @return Esito del check password
	 * 
	 * @since 1.0
	 */
   public boolean checkPassword(String plainPassword, String encryptedPassword) {
      return encryptor.checkPassword(plainPassword, encryptedPassword);
   }
}