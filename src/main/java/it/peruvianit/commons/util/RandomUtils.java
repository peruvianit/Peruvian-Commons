/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.util;

/**
 * <p>Aiuto per la generazione Random.</p>
 * 
 * @since 1.0
 *
 */
public class RandomUtils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**
	 * <p>Ritorna una stringa {@code Ramdon} con la lunghezza del parametro {@code count}.</p>
	 * 
	 * @param count Lunghezza della stringa da generare.
	 * 
	 * @return Una stringa alphanumerica.
	 * 
	 * @since 1.0
	 */
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
