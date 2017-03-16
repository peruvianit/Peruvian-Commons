/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.util;

import com.google.gson.GsonBuilder;

/**
 * <p>Classe che serve per fare il parsing da un oogetto a un JSON .</p>
 * 
 * @since 1.0
 *
 */
public final class GsonUtils {
	
	/**
     * <p>Construisce una nuova {@code GsonUtil}.</p>
     */
	public GsonUtils(){};
	
	/**
	 * <p>Ritorna una stringa Json in formato Pretty.</p>
	 * 
	 * @param object Classe da fare il parsing.
	 * 
	 * @return String Json in formato pretty.
	 * 
	 * @since 1.0
	 */
	public static String objToJsonPrettyPrinting (final Object object){
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
	
	/**
	 * <p>Ritorna un stringa Json.</p>
	 * 
	 * @param object Classe da fare il parsing.
	 * 
	 * @return String Json inline.
	 * 
	 * @since 1.0
	 */
	public static String objToJson (final Object object){
		return new GsonBuilder().create().toJson(object);
	}
}
