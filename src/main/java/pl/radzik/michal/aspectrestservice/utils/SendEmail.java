package pl.radzik.michal.aspectrestservice.utils;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.radzik.michal.aspectrestservice.utils.EmailSender;

import javax.mail.*;
import javax.mail.internet.MimeMessage;


@Service
@Aspect
public class SendEmail implements EmailSender {

    public SendEmail() {
    }

    @Autowired
    private JavaMailSender javaMailSender;



        @Override
        @After(value = "execution(org.springframework.http.ResponseEntity pl.radzik.michal.aspectrestservice.controller.FilmController.addFilm(..))")
        public void sendEmail() {
            MimeMessage mail = javaMailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(mail, true);
                helper.setTo("michal.radzik@wp.pl");
                helper.setReplyTo("newsletter@codecouple.pl");
                helper.setFrom("newsletter@codecouple.pl");
                helper.setSubject("Dynastia");
                helper.setText("Add film", true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(mail);
        }
}

