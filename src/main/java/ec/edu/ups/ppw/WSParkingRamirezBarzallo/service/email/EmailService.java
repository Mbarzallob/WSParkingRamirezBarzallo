package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.email;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

@RequestScoped
public class EmailService {
    @Resource(name = "java:jboss/mail/MyMailSession")
    private Session mailSession;

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String USERNAME = "mbarzallob@gmail.com";
    private static final String PASSWORD = "ypzt dvwe lbzu pjvh";

    public Result<Void> sendEmail(String to, String subject, String messageText) {
        try {
            if (mailSession == null) {
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", SMTP_HOST);
                props.put("mail.smtp.port", SMTP_PORT);

                mailSession = Session.getInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
            }

            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            return Result.ok();
        } catch (MessagingException e) {
            return Result.failure(e.getMessage());
        }
    }
}
