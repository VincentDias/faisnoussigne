package com.LSF.faisnoussigne.webservices.email;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmailRequestDto {

    private String from;
    private static String to =  "lakazmobile.test@gmail.com";
    private String subject;
    private String name;
    private String message;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}