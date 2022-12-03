package com.example.form.Service;

import com.example.form.Model.BankCredit;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Service
public class LineChart {
    public static void generateLineChart(ArrayList<BankCredit> bankCredits) throws IOException {

        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        int i = 59;
        while(i < 59 + bankCredits.size()){
            line_chart_dataset.addValue((int)bankCredits.get(i-59).getMoney(), "Solicitari in ordine temporala",
                    String.valueOf(i));
            System.out.println(bankCredits.get(i-59).getMoney());
            i++;
        }
        /*for(BankCredit a : bankCredits){
            line_chart_dataset.addValue(0, "number of requests", String.valueOf(a.getId()));
        }*/




        /*for(BankCredit bankCredit : bankCredits){
            line_chart_dataset.addValue(line_chart_dataset
                            .getValue("number of requests", String.valueOf((long)bankCredit.getId())).intValue(),
                    "number of requests",
                    String.valueOf((long)bankCredit.getMoney()));
        }*/

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Sume solicitate",
                "Id client",
                "Suma",
                line_chart_dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        int width = 680;
        int height = 420;
        File lineChart = new File("LineChart.jpeg");
        ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
    }

}
