/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util;

import java.util.UUID;

/**
 * <p>Clase del sistema con il pattern Singlenton.</p>
 * 
 * @since 1.0
 *
 */
public class SystemUtil {
	private static SystemUtil instance = null;
	
	/**
     * <p>Construisce una nuova {@code SystemUtil} in forma privata.</p>
     *  
     * <p>#Pattern Singleton#</p>
     */
	protected SystemUtil() {
	}
 
	/**
	 * <p>Ritorna una instanza {@code SystemUtil}.</p>
	 * 
	 * @return {@link SystemUtil}
	 * @since 1.0
	 */
	public static SystemUtil getInstance() {
		if (instance == null) {
			if (instance == null) {
				instance = new SystemUtil();
			}
		}
		return instance;
	}
	
	/**
	 * <p>Ritorna una codice UUID.</p>
	 * 
	 * @since 1.0
	 * @return Codice UUID generato
	 */
	public String getUID(){
		return UUID.randomUUID().toString();
	}
}