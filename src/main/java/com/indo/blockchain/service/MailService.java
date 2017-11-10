package com.indo.blockchain.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.indo.blockchain.exception.BeneficiaryJson;

@Service
public class MailService {

	@Autowired
    private JavaMailSender sender;
	
	private final static Logger LOGGER = Logger.getLogger(MailService.class);
	
	public void sendMailCreateUser(BeneficiaryJson beneficiaryJson) throws MessagingException{
		
		LOGGER.info("Mail to send : " + beneficiaryJson.getMail());
		
		StringBuilder builder = new StringBuilder();
		builder.append("Bonjour " + beneficiaryJson.getFirstname() + " " + beneficiaryJson.getLastname() + " , ");
		builder.append(System.getProperty("line.separator"));
		builder.append("Vous venez de creer un compte chez BeeEther, Welcome Home");
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("contact"));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(beneficiaryJson.getMail()));
		mimeMessage.setSubject("Creation d'un utilisateur");
		mimeMessage.setText(builder.toString());
		sender.send(mimeMessage);
		
	}
	
	public void sendMailCreateWalletEthereum(String firstname, String lastname, String mail) throws MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("contact"));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		mimeMessage.setSubject("Creation d'un utilisateur");
		mimeMessage.setText("Bonjour " + firstname + lastname + ", ");
		mimeMessage.setText("Vous venez de creer un portefeuille virtuel");
		sender.send(mimeMessage);
	}
}
