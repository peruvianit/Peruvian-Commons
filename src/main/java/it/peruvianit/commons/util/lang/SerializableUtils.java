/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util.lang;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import it.peruvianit.commons.exception.PeruvianCommonsException;

/**
 * <p>Aiuto per lavorare con le classi Serializabili.</p>
 * 
 * <p>I metodi di questa clase, non consentono {@code null} come input</p>
 * 
 * @since 1.0
 *
 */
public class SerializableUtils {
	
	/**
	 * <p>Ritorna una eccezione generica {@code PeruvianCommonsException} se
	 * la serializzazione non va a buon fine.</p>
	 * 
	 * @param path Cartella dove sarà creato il oggetto serializzato.
	 * @param fileName Nome del file da creare.
	 * @param object Oggetto da serializzare.
	 * 
	 * @throws PeruvianCommonsException Errore al momento della creazione e salvataggio nel
	 *      							fileSystem del oggetto serializzato.
	 * @since 1.0
	 */
	public static void serialize(String path, String fileName, Object object){
		String pathFile = path + "\\" + fileName;
		try(
			OutputStream file = new FileOutputStream(pathFile + "\\" + fileName + "-" + UUID.randomUUID().toString() + ".ser");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
		){
			output.writeObject(object);
		}catch (Exception e) {
			throw new PeruvianCommonsException("Problemi per serializzare : " + pathFile);
		}
	}
	
	/**
	 * <p>Ritorna una eccezione generica {@code PeruvianCommonsException} se
	 * la deserializzazione non va a buon fine.</p>
	 * 
	 * @param pathFile percorso completo del file da serializzare
	 * 
	 * @return Oggetto deserializzato
	 * 
	 * @throws PeruvianCommonsException Errore al momento della deserializzazione.
	 * @since 1.0
	 */
	public static Object deserialize(String pathFile) {
		try(
		    InputStream file = new FileInputStream(pathFile);
		    InputStream buffer = new BufferedInputStream(file);
		    ObjectInput input = new ObjectInputStream(buffer);
		){
			return input.readObject();
		}catch (Exception e) {
			throw new PeruvianCommonsException(e);
		}
	}
}
