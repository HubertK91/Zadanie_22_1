package pl.hk.zadanie_22_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Sender sender) {
        logger.debug("Wysyłam maila do {}", sender.senderMail);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setTo("hubert160491@gmail.com");
            helper.setFrom(sender.senderMail);
            helper.setSubject(sender.name);
            helper.setText(sender.content, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.warn("Bład podczas wysłania wiadomości", e);
        }
        logger.debug("Mail do {} wysłany poprawnie", sender.senderMail);
    }
}
