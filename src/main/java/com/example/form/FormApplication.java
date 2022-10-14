package com.example.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormApplication {

	public static void main(String[] args) {
		// pentru a afisa datele in format xml
		// SELECT * FROM bank_credit
		// FOR XML PATH
		SpringApplication.run(FormApplication.class, args);
	}

}
