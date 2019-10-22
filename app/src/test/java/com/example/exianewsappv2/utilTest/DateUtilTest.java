package com.example.exianewsappv2.utilTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.exianewsappv2.helpers.FormatDateUtils;
import com.google.firebase.crash.FirebaseCrash;

import java.text.ParseException;


@RunWith(PowerMockRunner.class)
@PrepareForTest({FirebaseCrash.class})
public class DateUtilTest {
    String correctInputData1= "2019-10-22T00:21:30Z";
    String correctOutputData1= "Sel, 22 Okt 2019 00:21";
    String incorrectInputDate1= "2019-10-20T00";

    @Test
    public void formatExiaNewsDate(){
        String outputDate = FormatDateUtils.formNewsApiDate(correctInputData1);
        assertEquals(outputDate,correctOutputData1);
    }

    @Test
    public void nullResultFormatDate(){
        String outputDate = FormatDateUtils.formNewsApiDate(null);
        assertEquals(outputDate,null);
    }


    @Test
    public void inCorrectInputExpectingResult(){
        PowerMockito.mockStatic(FirebaseCrash.class);

        String outputDateFalse = FormatDateUtils.formNewsApiDate(incorrectInputDate1);

        assertEquals(outputDateFalse,incorrectInputDate1);
        PowerMockito.verifyStatic();
        FirebaseCrash.report(Matchers.isA(ParseException.class));
    }


}
