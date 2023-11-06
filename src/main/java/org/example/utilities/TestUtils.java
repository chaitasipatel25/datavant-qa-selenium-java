package org.example.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class TestUtils {

    static DateFormat dateFormat;
    static Date date;
    public static final long PAGE_LOAD_TIMEOUT = 100;
    public static final long IMPLICIT_WAIT = 10;
    public static final String DateFormat = "d-MMMM-yyyy";

    public static String getCurrentDate(String format) {
        dateFormat = new SimpleDateFormat(format);
        date = new Date();
        return dateFormat.format(date);
    }
    public static String getCustomDate(String format, int days) {
        dateFormat = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        return dateFormat.format(c.getTime());
    }
    public String getMonth(int days) {
        dateFormat = new SimpleDateFormat(DateFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        String date = dateFormat.format(c.getTime());
        String[] splitter = date.split("-");
        return splitter[1];
    }
    public String getDay(int days) {
        dateFormat = new SimpleDateFormat(DateFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        String date = dateFormat.format(c.getTime());
        String[] splitter = date.split("-");
        return splitter[0];
    }

}
