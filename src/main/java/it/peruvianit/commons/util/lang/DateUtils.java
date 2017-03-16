/**
 * 
 * @author Sergio Arellano Diaz
 *
 */

package it.peruvianit.commons.util.lang;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>Aiuto per lavorare con le Date.</p>
 * 
 * @since 1.0
 *
 */
public final class DateUtils {
	
	/**
	 * <p>Ritorna una numero {@code Long} della data in secondi dal 1 gennaio del 1971.</p>
	 * 
	 * @return tempo in secondi dal 1 Gennaio 1971.
	 * 
	 * @since 1.0
	 */
	public static Long getCurrentTimeUTC(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();		
	}
	
	/**
	 * <p>Ritorna una nuova {@code Date} con dei secondi aggiunti alla Data in input.</p>
	 * 
	 * @param date Data in input.
	 * @param seconds numero in secondi per aggiungere alla {@code date} in input.
	 * 
	 * @return una nuova data con il incremento dei secondi.
	 * @since 1.0
	 */
	public static Date addSeconds(Date date, int seconds){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		
		return calendar.getTime();
	}
}
