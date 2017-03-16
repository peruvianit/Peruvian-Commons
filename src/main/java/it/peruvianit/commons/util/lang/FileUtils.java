/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util.lang;

import java.io.File;

import it.peruvianit.commons.exception.PeruvianCommonsException;

/**
 * <p>Aiuto per lavorare con i File.</p>
 * 
 * <p>I metodi di questa clase, non consentono {null @code} come input</p>
 * 
 * @since 1.0
 *
 */
public class FileUtils {
	/**
	 * <p>Ritorna una eccezione generica {@code PeruvianCommonsException} se
	 * un path della collezione non esiste sul FileSystem</p>
	 * 
	 * @param pathDirectories Collezione {@code pathDirectories} per verificare l'esistenza della
	 * 						  cartella.
	 * 
	 * @throws PeruvianCommonsException Errore nel controllo dell'esistenza del {@code path} sul fileSystem.
	 * @since 1.0
	 */
	public static void checkDirecctory(String ... pathDirectories){
		for (String path : pathDirectories) {
			File file = new File(path);
			
			if (file.exists()) {
			    if (!file.isDirectory()) {
			        throw new PeruvianCommonsException("Non è una Directory : " + path);
			    }
			}else{
				throw new PeruvianCommonsException("Path inesistente : " + path);
			}
		}
	}
}
