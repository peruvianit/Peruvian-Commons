/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.exception;

/**
 * <p>Lancia una exception quando il sistema invia una email.</p>
 *
 * <p>Il errore originale è wrappato all'interno di questo.</p>
 *
 *<pre>
 * public void foo() {
 *   try {
 *     // invio email
 *   } catch (Exception ex) {
 *     throw new PeruvianMailException("TODO", ex);
 *   }
 * }
 * </pre>
 * <p>#NotThreadSafe#</p>
 * @since 1.0
 */
public class PeruvianMailException extends RuntimeException {
	/**
	 * @see java.io.Serializable
	 */
	private static final long serialVersionUID = 4064605798689582965L;


	/**
     * <p>Construisce una nuova {@code PeruvianMailException} senza specificare
     * un messaggio.</p>
     */
	public PeruvianMailException() {
	}

	/**
     * <p>Construisce una nuova {@code PeruvianMailException} con 
     * un messaggio.</p>
     * 
     * @param message Dettaglio del messaggio
     * @since 1.0
     */
	public PeruvianMailException(final String message) {
		super(message);
	}

	/**
     * <p>Construisce una nuova {@code PeruvianMailException} con 
     * {@code Throwable} nidificato.</p>
     * 
     * @param cause Il {@code Exception} o {@code Error} che causa
     * questo Exception para essere lanciato
     * @since 1.0
     */
	public PeruvianMailException(final Throwable cause) {
		super(cause);
	}

	/**
     * <p>Construisce una nuova {@code PeruvianMailException} con
     * un messagio e {@code Throwable} nidificato.</p>
     * 
     * @param message Dettaglio del messaggio
     * @param cause Il {@code Exception} o {@code Error} che causa
     * questo Exception para essere lanciato
     * @since 1.0
     */
	public PeruvianMailException(final String message, final Throwable cause) {
		super(message, cause);
	}
}