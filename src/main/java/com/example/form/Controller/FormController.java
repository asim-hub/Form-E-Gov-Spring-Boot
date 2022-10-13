package com.example.form.Controller;

import com.example.form.Model.BankCredit;
import com.example.form.Model.Email;
import com.example.form.Service.PDFService;
import com.example.form.ServiceImplement.BankCreditServiceImplement;
import com.example.form.ServiceImplement.EmailServiceImplement;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Controller
public class FormController {
    @Autowired
    private BankCreditServiceImplement bankCreditServiceImplement;

    @Autowired
    private PDFService pdfService;

    @Autowired
    private EmailServiceImplement emailServiceImplement;

    @GetMapping({"/newBankRequest", "/"})
    public String newBankRequest(Model model) throws ExecutionException, InterruptedException{
        BankCredit bankCredit = new BankCredit();
        model.addAttribute("bankCredit", bankCredit);
        return "BankForm";
    }

    @PostMapping("/newBankRequest")
    public String newBankRequest(Model model, @ModelAttribute("bankCredit") @Valid BankCredit bankCredit, BindingResult bindingResult) throws ExecutionException, InterruptedException, DocumentException, IOException {
        if (bindingResult.hasErrors()) {
            return "BankForm";
        }
        bankCreditServiceImplement.addBankCredit(bankCredit);
        model.addAttribute("bankCredit", bankCredit);
        return "succes";
    }

    @GetMapping("/download/{id}")
    public void download(HttpServletResponse response, Model model, @PathVariable Long id) throws ExecutionException, IOException, DocumentException {
        BankCredit bankCredit = bankCreditServiceImplement.getBankCreditById(id);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=CERERE" + bankCredit.getName() + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        pdfService.generate(response, bankCredit);
        model.addAttribute("bankCredit", new BankCredit());

        // send email
        Email email = new Email();
        email.setFrom("hrmanagerspring@gmail.com");
        email.setTo(bankCredit.getEmail());
        email.setSubject("Confirmare");
        email.setMessage("Formularul a fost inregistrat cu succes.\nRevenim cat de curand cu un raspuns.\nNumai bine, echipa Bank!");
        emailServiceImplement.sendEmail(email);

    }

}
