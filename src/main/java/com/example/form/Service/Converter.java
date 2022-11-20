package com.example.form.Service;
import com.example.form.Model.BankCredit;
import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

@Service
public class Converter implements ConverterService{
    @Autowired
    BankCreditService bankCreditService;
    @Autowired
    PieChart_AWT pieChart_awt;
    @Autowired
    LineChart lineChart;
    @Autowired
    TableGenerator tableGenerator;


    public void convert(HttpServletResponse response) {

        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document,
                    response.getOutputStream());

            document.open();

            // 1. --->create a paragraph and add it to the document<---
            Paragraph p = new Paragraph("The next item will be a table");
            p.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p);

            //2. --->create a table and add it to the document<---ArrayList<String>(myList);
            document.add(tableGenerator.generate(new ArrayList< BankCredit >(bankCreditService.getAllBankCredit())));

            //3. --->create a pie chart and add it to the document<---
            String pieChartTitle = "PieChart";
            pieChart_awt.PieChartFactory(pieChartTitle, new ArrayList< BankCredit >(bankCreditService.getAllBankCredit()), 480, 260);
            Image jpegPieChart = Image.getInstance(pieChartTitle + ".jpeg");

            document.add(jpegPieChart);

            //4. --->create a line chart and add it to the document<---
            lineChart.generateLineChart( new ArrayList< BankCredit >(bankCreditService.getAllBankCredit()));
            Image jpegLineChart = Image.getInstance("LineChart.jpeg");
            document.add(jpegLineChart);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        document.close();
    }

}
