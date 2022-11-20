package com.example.form.Service;

import com.example.form.Model.BankCredit;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.*;

import java.awt.*;
import java.util.*;

@Service
public class TableGenerator {

    private static void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        //cell.setPhrase(new Phrase("Solicitare ID", font));
        //table.addCell(cell);

        cell.setPhrase(new Phrase("Solicitant", font));
        table.addCell(cell);

        //cell.setPhrase(new Phrase("CNP", font));
        //table.addCell(cell);

        cell.setPhrase(new Phrase("Tip credit", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Moneda", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Durata", font));
        table.addCell(cell);

        //cell.setPhrase(new Phrase("Emial", font));
        //table.addCell(cell);

        //cell.setPhrase(new Phrase("Tip dob.", font));
        //table.addCell(cell);

        cell.setPhrase(new Phrase("Suma imp.", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Suma ret.", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rata", font));
        table.addCell(cell);
    }

    private static void writeTableData(PdfPTable table, ArrayList<BankCredit> bankCredits){
        for(int i=0; i < bankCredits.size(); i++) {
            //table.addCell(String.valueOf(bankCredits.get(i).getId()));
            table.addCell(bankCredits.get(i).getName());
            //table.addCell(bankCredits.get(i).getCnp());
            table.addCell(String.valueOf(bankCredits.get(i).getCreditType()));
            table.addCell(String.valueOf(bankCredits.get(i).getCurrency()));
            table.addCell(String.valueOf(bankCredits.get(i).getDuration()));
            //table.addCell(bankCredits.get(i).getEmail());
            //table.addCell(String.valueOf(bankCredits.get(i).getInterestType()));
            table.addCell(String.valueOf(bankCredits.get(i).getMoney()));
            table.addCell(String.valueOf(bankCredits.get(i).getMoney_back()));
            table.addCell(String.valueOf(bankCredits.get(i).getRate()));

        }
    }

    public static PdfPTable generate(ArrayList<BankCredit> bankCredits) throws DocumentException {
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.0f, 3.5f, 1.5f, 1f, 1.5f, 1.5f, 1.5f,});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table, bankCredits);
        return table;
    }

}
