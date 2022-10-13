package com.example.form.Service;


import com.example.form.Model.Email;

public interface EmailService {
    public void sendEmail(Email email);
    public void sendEmailAttach(Email email, String path_attach);
}

