/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util;

import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;

/**
 * <p>Classe che serve per la popolazione dinamica dei oggetti.</p>
 * 
 * @since 1.0
 *
 */
public class PopulatorUtil {
	
	/**
     * <p>Construisce una nuova {@code PopulatorUtil}.</p>
     */
	public PopulatorUtil(){};
	
	/**
	 * <p>Ritorna un oggetto generico, con il caricamento dinamico dei attributi.</p>
	 * 
	 * @param object Classe da caricare dinamicamente.
	 * 
	 * @return T Classe generica.
	 * 
	 * @since 1.0
	 */
	public static <T> T populateBean (Class<T> object){
		PopulatorBuilder builder = new PopulatorBuilder(); 
		Populator populator = builder.build();
		return (T) populator.populateBean(object);
	}
}
