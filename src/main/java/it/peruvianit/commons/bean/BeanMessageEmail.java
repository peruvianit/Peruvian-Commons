/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Bean che serve per encapsular tutta l'informazione necessaria per inviare l'email.</p>
 * 
 * @since 1.0
 *
 */
public class BeanMessageEmail {
	private String from;
	private String to;
	private String subject;
	private Map<String,Object> msg = new HashMap<>();
	private List<String> addTo = new ArrayList<String>();
	
	private File fileTemplate;
	
	private String directoryTemplateEmail;
	
	/**
     * <p>Construisce una nuova {@code BeanMessageEmail}.</p>
     * 
     * @param directoryTemplateEmail IL nome del file freemarker, con estensione \'ftl\'".
     *                       
     */
	public BeanMessageEmail(String directoryTemplateEmail){
		this.directoryTemplateEmail = directoryTemplateEmail;
	};
	
	/**
     * @return  L'email che invia il messaggio.
     *                       
     */
	public String getFrom() {
		return from;
	}

	/**
     * @param from  L'email che invia il messaggio.
     *                       
     */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
     * @return  L'email che riceve il messaggio.
     *                       
     */
	public String getTo() {
		return to;
	}

	/**
     * @param to L'email che invia il messaggio.
     *                       
     */
	public void setTo(String to) {
		this.to = to;
	}

	/**
     * @return  L'oggetto del messaggio.
     *                       
     */
	public String getSubject() {
		return subject;
	}
	
	/**
     * @param subject L'oggetto del messaggio.
     *                       
     */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
     * @return  Mappa di oggetti che saranno injettati sul template Freemarker..
     *                       
     */
	public Map<String, Object> getMsg() {
		return msg;
	}
	
	/**
     * @param  msg Mappa di oggetti che saranno injettati sul template Freemarker.
     *                       
     */
	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	
	/**
     * @return  Lista di account email dove sarà inviato l'messagio
     *                       
     */
	public List<String> getAddTo() {
		return addTo;
	}
	
	/**
	 * <p>Metodo per aggiungere email a {@code addTo} </p>
	 * 
     * @param addTo  Lista di account email dove sarà inviato l'messagio
     *                       
     */
	public void setAddTo(List<String> addTo) {
		this.addTo = addTo;
	}

	/**
	 * 
     * @return Nome del template Freemarker
     *                       
     */
	public String getDirectoryTemplateEmail() {
		return directoryTemplateEmail;
	}

	/**
	 * 
     * @param directoryTemplateEmail Nome del template Freemarker
     *                       
     */
	public void setDirectoryTemplateEmail(String directoryTemplateEmail) {
		this.directoryTemplateEmail = directoryTemplateEmail;
	}

	/**
	 * 
     * @return File oggetto {@link java.io.File File} del template Freemarker
     *                       
     */
	public File getFileTemplate() {
		return fileTemplate;
	}

	/**
	 * 
     * @param fileTemplate oggetto {@link java.io.File File} del template Freemarker
     *                       
     */
	public void setFileTemplate(File fileTemplate) {
		this.fileTemplate = fileTemplate;
	}
}
