package com.example.exianewsappv2.helpers;

import com.google.firebase.crash.FirebaseCrash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.PatternSyntaxException;

public class FormatDateUtils {

    public static String formNewsApiDate(String inputDate){
        if (inputDate==null)
            return null;
        try {
            String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            String outputDateFormat ="EEE, d MMM yyyy KK:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        }catch (ParseException e){
            e.printStackTrace();
            FirebaseCrash.report(e);
        }
        return inputDate;
    }
}
