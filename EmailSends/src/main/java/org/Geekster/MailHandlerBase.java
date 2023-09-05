package org.Geekster;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandlerBase {
      public void sendMail() {
        Properties sysproperties= System.getProperties();
        // get  System properties //
         // System.out.println(sysproperties);

          sysproperties.put("mail.smtp.host","smtp.gmail.com");  //SMTP SERVER
          sysproperties.put("mail.smtp.port","465");  //SERVER PORT
          sysproperties.put("mail.smtp.ssl.enable","true");  // SSL-Server Socket Layer - true or false (predicate value)
          sysproperties.put("mail.smtp.auth","true");  //Authentication - auth

           Authenticator mailauthenticator = new  CustomizedMailAuthentication();
          Session mailSession= Session.getInstance(sysproperties,mailauthenticator);

          MimeMessage mailMessage=new MimeMessage(mailSession);
          try {
              mailMessage.setFrom(MailConstants.SENDER);
              mailMessage.setSubject("Geekster are Sending you a Mail");
              mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("lalitasharma8020@gmail.com"));
              mailMessage.setText("I hope this message finds you well.I am Writing to express my Strong interest in the java Developer Position[ANISH KUMAR SHARMA] from [XYZ] company Thank You  ");

              Transport.send(mailMessage);
          }
          catch (Exception e) {
              System.out.println("Some error while Preparing a message");
                 System.out.println(e.getMessage());
          }
      }
}
