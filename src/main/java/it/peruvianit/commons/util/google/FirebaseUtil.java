/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util.google;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import it.peruvianit.commons.exception.PeruvianCommonsException;
import it.peruvianit.commons.util.SystemUtil;

/**
 * <p>Clase di Aiuto per lavorare con il servizio FireBase di Google con il pattern Singlenton.</p>
 * 
 * <p>In fase di sviluppo, utilizzo simplice dell'api firebase.</p>
 * 
 * <p>Il {@code pathFileKey} è il path di un file in formato json, generato dalla consola di Google Firebase.</p>
 * 
 * @since BETA
 *
 */
public class FirebaseUtil {
	private static FirebaseUtil instance = null;
	private static FirebaseDatabase database;
	
	/**
     * <p>Construisce una nuova {@code FireBaseutil} in forma privata.</p>
     *  
     * <p>#Pattern Singleton#</p>
     */
	protected FirebaseUtil() {
	}
 
	/**
	 * <p>Ritorna una instanza {@code FirebaseUtil}.</p>
	 * 
	 * @param url repository firebase. esempio : https://[DATABASE].firebaseio.com/
	 * @param pathKeyFile File in formato json generato dalla consola di Google {@code Firebase} :
	 * <pre>
	 * {
	 *   "type": "service_account",
	 *   "project_id": "[*****]",
	 *   "private_key_id": "[*****]",
	 *   "private_key": "-----BEGIN PRIVATE KEY-----\-----END PRIVATE KEY-----\n",
	 *   "client_email": "[*****]@appspot.gserviceaccount.com",
	 *   "client_id": "[*****]",
	 *   "auth_uri": "https://accounts.google.com/o/oauth2/auth",
	 *   "token_uri": "https://accounts.google.com/o/oauth2/token",
	 *   "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
	 *   "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/[*****]%40appspot.gserviceaccount.com"
	 *}
	 * </pre>
	 * 
	 * @return {@link FirebaseUtil}
	 * @throws PeruvianCommonsException Se la chiave fornita da google in formato json, non esiste sul FileSystem.
	 * @since 1.0
	 * @see it.peruvianit.commons.exception.PeruvianCommonsException
	 */
	public static FirebaseUtil getInstance(String url,String pathKeyFile) {
		if (instance == null) {
			if (instance == null) {
				instance = new FirebaseUtil();
				
				FirebaseOptions options;
				try {
					options = new FirebaseOptions.Builder()
					.setServiceAccount(new FileInputStream(pathKeyFile))
					.setDatabaseUrl(url)
					.build();
				} catch (FileNotFoundException e) {
					throw new PeruvianCommonsException("Controllare se esiste il file : " + pathKeyFile);
				}
		        FirebaseApp.initializeApp(options);
		         
		        database = FirebaseDatabase.getInstance();
			}
		}
		return instance;
	}
	
	/**
	 * <p>Inserisci un elemento al interno del repository {@code Firebase} sul nodo como {@code reference}.</p>
	 * 
	 * @param reference Nodo al interno del repoository {@code Firebase}
	 * @param object elemento che sara aggiunto in formato json al interno del repository.
	 * 
	 * @throws PeruvianCommonsException Se la chiave fornita da google in formato json, non esiste sul FileSystem.
	 * @since 1.0
	 */
	public <T> void addRow(String reference, T object){
         DatabaseReference myRef = database.getReference(reference + "/" + SystemUtil.getInstance().getUID());
         myRef.setValue(object);
	}
}