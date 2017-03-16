/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.exception;

/**
 * <p>Lancia una exception quando se genera un errore generico.</p>
 *
 * <p>Il errore originale è wrappato all'interno di questo.</p>
 *
 *<pre>
 * public void foo() {
 *   try {
 *     // fare qualcosa che lancia una exception Generica
 *   } catch (Exception ex) {
 *     throw new PeruvianCommonsException("TODO", ex);
 *   }
 * }
 * </pre>
 * <p>#NotThreadSafe#</p>
 * @since 1.0
 */
public class PeruvianCommonsException extends RuntimeException {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 4064605798689582965L;


	/**
     * <p>Construisce una nuova {@code PeruvianCommonsException} senza specificare
     * un messaggio.</p>
     */
	public PeruvianCommonsException() {
	}

	/**
     * <p>Construisce una nuova {@code PeruvianCommonsException} con 
     * un messaggio.</p>
     * 
     * @param message Dettaglio del messaggio
     * @since 1.0
     */
	public PeruvianCommonsException(final String message) {
		super(message);
	}

	/**
     * <p>Construisce una nuova {@code PeruvianCommonsException} con 
     * {@code Throwable} nidificato.</p>
     * 
     * @param cause Il {@code Exception} o {@code Error} che causa
     * questo Exception para essere lanciato
     * @since 1.0
     */
	public PeruvianCommonsException(final Throwable cause) {
		super(cause);
	}

	/**
     * <p>Construisce una nuova {@code PeruvianCommonsException} con
     * un messagio e {@code Throwable} nidificato.</p>
     * 
     * @param message Dettaglio del messaggio
     * @param cause Il {@code Exception} o {@code Error} che causa
     * questo Exception para essere lanciato
     * @since 1.0
     */
	public PeruvianCommonsException(final String message, final Throwable cause) {
		super(message, cause);
	}
}