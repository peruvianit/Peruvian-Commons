/**
 * 
 * @author Sergio Arellano Diaz
 *
 */
package it.peruvianit.commons.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import it.peruvianit.commons.bean.BeanMessageEmail;
import it.peruvianit.commons.exception.PeruvianMailException;

/**
 * <p>Classe per l'invio di Email. Alla creazione della istanza è necessario utilizzare il
 * costruttore con i paramtri di configurazione del server Smtp.</p>
 * 
 * <pre>
 * public SendMail(String hostName, Integer port, String username, String password) {
 * 		super();
 *		this.hostName = hostName;
 *		this.port = port;
 *		this.username = username;
 *		this.password = password;
 *	}
 * </pre>
 * 
 * <p>Dopo se potra procedere l'invio dell'email utilizzando {@link SendMail#sendMessage(BeanMessageEmail)} 
 * con tutto il contenuto dall'email incapsualato nel parametro {@link BeanMessageEmail}.</p>
 * 
 * @see BeanMessageEmail
 * @since 1.0
 *
 */
public class SendMail {
	private String hostName;
	private Integer port;
	private String username;
	private String password;
	
	/**
     * <p>Construisce una nuova {@code SendEmail} con la configurazione del server Smtp.</p>
     * 
     * @param hostName server host del Smtp
     * @param port port di comunicazione con il server Smtp.
     * @param username Username per il accesso del server Smtp.
     * @param password password per il accesso del server Smtp.
     *                       
     * @since 1.0                      
     */
	public SendMail(String hostName, Integer port, String username, String password) {
		super();
		this.hostName = hostName;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	/**
     * <p>Construisce una nuova {@code SendEmail} con la configurazione del server Smtp.</p>
     * 
     * @param beanMessageEmail Bean che serve per encapsular tutta l'informazione necessaria per inviare l'email.
     *                       
     * @since 1.0
     * @see BeanMessageEmail                     
     */
	public void sendMessage(BeanMessageEmail beanMessageEmail) {	
		String templateEmail = beanMessageEmail.getDirectoryTemplateEmail();
		HtmlEmail email = new HtmlEmail();
		
		email.setHostName(this.hostName);
		email.setSmtpPort(this.port);
		email.setAuthenticator(new DefaultAuthenticator(this.username, this.password));
		email.setSSLOnConnect(true);
		
		try {			
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);			
			cfg.setDirectoryForTemplateLoading(beanMessageEmail.getFileTemplate());			
			Template template = cfg.getTemplate(templateEmail);
			
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
       
	        Writer out = new StringWriter();
	        template.process(beanMessageEmail.getMsg(), out);
			
			email.setFrom(beanMessageEmail.getFrom());		
			email.setSubject(beanMessageEmail.getSubject());
			email.setHtmlMsg(out.toString());
			email.addTo(beanMessageEmail.getTo());
			email.send();
			
		} catch (EmailException eMailEx) {
			throw new PeruvianMailException("Invio email non riuscito, controllare parametri del Sistema", eMailEx);
		} catch (IOException ioEx) {
			throw new PeruvianMailException("Problemi con la apertura del file : {name : " + templateEmail + "}", ioEx);
		} catch (TemplateException tEx) {
			throw new PeruvianMailException("Problemi con il template : " + templateEmail + "}", tEx);
		}
	}
}