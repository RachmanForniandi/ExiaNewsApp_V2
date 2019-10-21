package com.example.exianewsappv2.utilTest;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.exianewsappv2.helpers.FormatDateUtils;


public class DateUtilTest {
    String correctInputData1= "2019-10-22T00:21:30Z";
    String correctOutputData1= "Sel, 22 Okt 2019 00:21";

    @Test
    public void formatExiaNewsDate(){
        String outputDate = FormatDateUtils.formNewsApiDate(correctInputData1);
        assertEquals(outputDate,correctOutputData1);
    }

    /*@Test
    public void nullResultFormatDate(){
        String outputDate = FormatDateUtils.formNewsApiDate(null);
        assertEquals(outputDate,null);
    }*/
}
