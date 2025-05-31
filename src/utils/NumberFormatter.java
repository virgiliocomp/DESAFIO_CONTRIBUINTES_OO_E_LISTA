package utils;

import java.text.DecimalFormat;

public class NumberFormatter {
    public static String numberFormatter(double number){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        return decimalFormat.format(number);
    }




}
