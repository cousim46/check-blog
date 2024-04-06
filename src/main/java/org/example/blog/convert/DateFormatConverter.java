package org.example.blog.convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateFormatConverter {

    public static List<String> convertTistoryDateToString(LocalDate date) {
        return List.of(
            getYearDotBlankMonthDotBlankDay(date),
            getYearDotMonthDotDay(date),
            getYear년BlankMonth월BlankDay일(date),
            getYear년Month월Day일(date),
            getYear년ZerpMonth월ZerpDay일(date),
            getYear년BlankZerpMonth월BlankZerpDay일(date),
            getYearDotBlankZeroMonthBlankZeorDay(date),
            getYearDotZeroMonthZeorDay(date)
        );
    }

    public static List<String> convertVelogDateToString(LocalDate date) {
        return List.of(
            getYearDotBlankMonthDotBlankDay(date),
            getYearDotMonthDotDay(date),
            getYear년BlankMonth월BlankDay일(date),
            getYear년Month월Day일(date),
            getYear년ZerpMonth월ZerpDay일(date),
            getYear년BlankZerpMonth월BlankZerpDay일(date),
            getYearDotBlankZeroMonthBlankZeorDay(date),
            getYearDotZeroMonthZeorDay(date),
            getBasicFormat(date)
        );
    }


    private static String getYearDotBlankMonthDotBlankDay(LocalDate date) {
        return format("yyyy. M. d",date);
    }
    private static String getYearDotMonthDotDay(LocalDate date) {
        return format("yyyy.M.d",date);
    }
    private static String getYear년BlankMonth월BlankDay일(LocalDate date) {
        return format("yyyy년 M월 d일", date);
    }

    private static String getYear년Month월Day일(LocalDate date) {
        return format("yyyy년M월d일", date);
    }

    private static String getYear년ZerpMonth월ZerpDay일(LocalDate date) {
        return format("yyyy년MM월dd일", date);
    }
    private static String getYear년BlankZerpMonth월BlankZerpDay일(LocalDate date) {
        return format("yyyy년 MM월 dd일", date);
    }

    private static String getYearDotBlankZeroMonthBlankZeorDay(LocalDate date) {
        return format("yyyy. MM. dd", date);
    }

    private static String getYearDotZeroMonthZeorDay(LocalDate date) {
        return format("yyyy.MM.dd", date);
    }

    private static String getBasicFormat(LocalDate date) {
        return format("yyyy-MM-dd", date);
    }

    private static String format(String pattern, LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(date);
    }



}
