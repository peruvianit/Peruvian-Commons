package it.peruvianit.test.util;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import it.peruvianit.bean.ProcessBean;
import it.peruvianit.bean.SummaryGeo;
import it.peruvianit.commons.bean.BeanMessageEmail;
import it.peruvianit.commons.mail.SendMail;

public class SendEmailTest {

	@Test
	public void test() {
		
		try {
			SummaryGeo summaryGeo = new SummaryGeo();
			
			ProcessBean processBean = new ProcessBean();
			processBean.setNameProcess("Elaborazione Geo-Reverse");
			processBean.setStartProcess(1488317358097L);
			processBean.setEndProcess(1488319781346L);
			processBean.setElapsedTime(2423249L);
			
			summaryGeo.setProcessBean(processBean);
		
			summaryGeo.setRowTotal(33891);
			summaryGeo.setRowLastWorking(19525);
			summaryGeo.setRowLastSuccess(17470);
			summaryGeo.setRowLastFail(2055);
			
			summaryGeo.setRowWorking(2470);
			summaryGeo.setRowSuccess(2192);
			summaryGeo.setRowFail(278);
			
			BeanMessageEmail beanMessageEmail = new BeanMessageEmail("elaborazioneGeo.ftl");
			beanMessageEmail.setFrom("info@peruvianit.it");
			beanMessageEmail.setTo("<EMAIL>");
			beanMessageEmail.setSubject("Geo-reverse V.1.0");
			beanMessageEmail.getMsg().put("summaryGeo", summaryGeo);
			beanMessageEmail.setFileTemplate(new File("D:\\Progetti\\Peruvian-commos\\peruvianit-commons\\src\\test\\resources\\"));
			
			SendMail sendMail = new SendMail("smtp.gmail.com", 465, "<EMAIL_GOOGLE>", "<PASSWORD_EMAIL>");
			sendMail.sendMessage(beanMessageEmail);
		} catch (Exception e) {
			fail("problemi con l'invio dell'email");
		}
	}
}
