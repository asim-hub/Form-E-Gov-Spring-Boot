package com.example.form.Service;

import com.example.form.Model.BankCredit;
import com.example.form.Model.Currency;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.springframework.stereotype.Service;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class PieChart_AWT {
    public static void PieChartFactory(String title, ArrayList<BankCredit> bankCredits, int width, int height) throws IOException {
        JFreeChart chart = createChart(createDataSet(bankCredits));
        File pieChart = new File(title + ".jpeg");
        ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
    }

    private static PieDataset createDataSet(ArrayList<BankCredit> bankCredits){
        DefaultPieDataset dataset = new DefaultPieDataset();
        int EUR, RON, USD, CNF, BTC, ETH;
        EUR = RON = USD = CNF = BTC = ETH = 0;
        for(BankCredit bankCredit : bankCredits) {
            Currency currency = bankCredit.getCurrency();
            if(currency.equals(Currency.EUR)){
                EUR ++;
            } else if (currency.equals(Currency.RON)) {
                RON ++;
            } else if (currency.equals(Currency.USD)) {
                USD ++;
            } else if(currency.equals(Currency.CNF)) {
                CNF ++;
            } else if(currency.equals(Currency.BTC)) {
                BTC ++;
            } else if(currency.equals(Currency.ETH)) {
                ETH ++;
            }
        }
        dataset.setValue("EUR", EUR);
        dataset.setValue("RON", RON);
        dataset.setValue("USD", USD);
        dataset.setValue("CNF", CNF);
        dataset.setValue("BTC", BTC);
        dataset.setValue("ETH", ETH);

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset){

        JFreeChart chart = ChartFactory.createPieChart("Procentaj imprumuturi in functie de moneda", dataset, true, true, false);
        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        return chart;
    }


}
