package org.Geekster;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedMailAuthentication extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(MailConstants.SENDER,"tmlmkvovloogthdg");
    }
}
