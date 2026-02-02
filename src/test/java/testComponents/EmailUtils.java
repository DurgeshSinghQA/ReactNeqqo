package testComponents;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.io.File;

public class EmailUtils {

    public static void sendReport(String reportPath) {
        final String fromEmail = "Durgesh.kumar@abc.com";
        final String password = "WelcomePassword";
        final String toEmail = "Durgesh.kumar@abc.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Test Execution Report");
            
            BodyPart body = new MimeBodyPart();
            body.setText("Hi,\n\nPlease find the attached test report.\n\nRegards,\nQA Team");

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(new File(reportPath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Report emailed successfully.");

        } catch (Exception e) {
            System.out.println("Failed to send report email.");
            e.printStackTrace();
        }
    }
}

