package com.example.form.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Email {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String message;
}

