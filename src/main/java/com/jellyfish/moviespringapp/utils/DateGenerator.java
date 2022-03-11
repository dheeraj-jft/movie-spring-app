package com.jellyfish.moviespringapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {
    private final static String pattern = "dd-MM-yyyy";

    public static String getDateInString() {
        return new SimpleDateFormat(pattern).format(new Date());
    }

}
