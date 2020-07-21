package com.LSF.faisnoussigne.email.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.LSF.faisnoussigne.email.dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    public String sendMail(EmailRequestDto request, Map<String, String> model) {

        String response;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            ClassPathResource pdf = new ClassPathResource("static/c3cbbf38a0528c242ba1ac32cdbdd0f8.png");
            ClassPathResource image = new ClassPathResource("static/c3cbbf38a0528c242ba1ac32cdbdd0f8.png");
            Template template = configuration.getTemplate("email.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setTo(request.getTo());
            helper.setFrom(request.getFrom());
            helper.setSubject(request.getSubject());
            helper.setText(html, true);
            helper.addInline("asbnotebook", image);
            helper.addAttachment("c3cbbf38a0528c242ba1ac32cdbdd0f8.png", pdf);

            mailSender.send(message);
            response = "Email has been sent to :" + request.getTo();
        } catch (MessagingException | IOException | TemplateException e) {
            response = "Email send failure to :" + request.getTo();
        }
        return response;
    }
}