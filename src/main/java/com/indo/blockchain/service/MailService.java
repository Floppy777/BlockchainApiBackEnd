package com.indo.blockchain.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
    private JavaMailSender sender;
	
	private final static Logger LOGGER = Logger.getLogger(MailService.class);
	
	public void sendMailCreateUser(String mail) throws MessagingException{
		LOGGER.info("Sender " + sender);
		LOGGER.info("Mail to send : " + mail);
		MimeMessage mimeMessage = sender.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("test"));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		mimeMessage.setSubject("Bonjour, Ceci est un test. LOL");
		mimeMessage.setText("Test d envoi de mail");
		sender.send(mimeMessage);
		
	}
	
	public void sendMailCreateWalletEthereum(){
		
	}
}
