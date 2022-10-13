package com.example.form.ServiceImplement;
import com.example.form.Model.Email;
import com.example.form.Service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
public class EmailServiceImplement implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Email email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setFrom(new InternetAddress(email.getFrom()));
            mimeMessageHelper.setTo(email.getTo());
            mimeMessageHelper.setText(email.getMessage());
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailAttach(Email email, String path_attach) {

        MimeMessage male = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mailHelper
                    = new MimeMessageHelper(male, true);
            mailHelper.setFrom(new InternetAddress(email.getFrom()));
            mailHelper.setTo(email.getTo());
            mailHelper.setText(email.getMessage());
            mailHelper.setSubject(email.getSubject());
            FileSystemResource fileSystem
                    = new FileSystemResource(new File(path_attach));
            mailHelper.addAttachment(fileSystem.getFilename(),
                    fileSystem);

            javaMailSender.send(male);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}



