package com.LSF.faisnoussigne.email.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LSF.faisnoussigne.email.dto.EmailRequestDto;
import com.LSF.faisnoussigne.email.service.MailService;

@RestController
public class MailSenderController {

    @Autowired
    private MailService mailService;

    @PostMapping("send-mail")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequestDto emailRequest) {
        Map<String, String> model = new HashMap<>();
        model.put("name", emailRequest.getName());
        model.put("value", "Fais nous signe!");
        String response = mailService.sendMail(emailRequest, model);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}