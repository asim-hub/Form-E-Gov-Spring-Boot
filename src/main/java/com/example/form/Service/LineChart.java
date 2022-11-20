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
        int i = 0;
        /*while(i <= 100){
            line_chart_dataset.addValue(0, "number of requests", String.valueOf(bankCredits.get(i).getId()));
            i++;
        }*/
        for(BankCredit a : bankCredits){
            line_chart_dataset.addValue(0, "number of requests", String.valueOf(a.getId()));
        }




        for(BankCredit bankCredit : bankCredits){
            line_chart_dataset.addValue(line_chart_dataset
                            .getValue("number of requests", String.valueOf((long)bankCredit.getCredit_interest())).intValue() + 1,
                    "number of requests",
                    String.valueOf((long)bankCredit.getCredit_interest()));
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Rate imprumuturi",
                "Rate",
                "Number of requests",
                line_chart_dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        int width = 480;
        int height = 260;
        File lineChart = new File("LineChart.jpeg");
        ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
    }

}
