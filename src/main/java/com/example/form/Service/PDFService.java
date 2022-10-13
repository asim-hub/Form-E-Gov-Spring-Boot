package com.example.form.Service;

import com.example.form.Model.BankCredit;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;

@Service
public class PDFService {


    public void generate(HttpServletResponse response, BankCredit bankCredit) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(18);

        Font fontSubTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontSubTitle.setSize(14);

        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontParagraph.setSize(12);

        Paragraph par_title1 = new Paragraph("DATE CREDIT BANCAR",
                fontTitle);

        Paragraph par1 = new Paragraph("Nume: " +
                bankCredit.getName(), fontParagraph);
        par1.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par2 = new Paragraph("Cod numeric personal: " +
                bankCredit.getCnp(), fontParagraph);
        par2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par3 = new Paragraph("Email: " + bankCredit.getEmail(),
                fontParagraph);
        par3.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par4 = new Paragraph("Moneda: " + bankCredit.getCurrency(), fontParagraph);
        par4.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par5 = new Paragraph("Tip credit: " +
                bankCredit.getCnp(), fontParagraph);
        par5.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par6 = new Paragraph("Valoare imprumut: " + bankCredit.getMoney(), fontParagraph);
        par6.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par7 = new Paragraph(
                "Valoare rata lunara: " + bankCredit.getRate(), fontParagraph);
        par7.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par8 = new Paragraph("Suma restituita: " + bankCredit.getMoney_back(), fontParagraph);
        par8.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par9 = new Paragraph("Dobanda: " + bankCredit.getCredit_interest() + "%", fontParagraph);
        par9.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph par10 = new Paragraph("Tip credit: " + bankCredit.getCreditType(), fontParagraph);
        par10.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(par_title1);
        document.add(Chunk.NEWLINE);
        document.add(par1);
        document.add(par2);
        document.add(par3);
        document.add(par4);
        document.add(par5);
        document.add(par6);
        document.add(par7);
        document.add(par8);
        document.add(par9);
        document.add(par10);
        document.close();
    }
}
