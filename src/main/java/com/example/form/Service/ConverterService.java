package com.example.form.Service;

import com.lowagie.text.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;

public interface ConverterService {
    void convert(HttpServletResponse response);
}

