package com.varhzj.lab.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by varhzj on 16-11-7.
 */
public class TimeApiExample {

    public static void main(String[] args) {
        localDateUsage();
        localTimeUsage();
        localDateTimeUsage();

        durationAndPeriodUsage();
    }

    private static void localDateUsage() {
        // LocalDate, 不可变对象, 只提供了简单的日期
        LocalDate date = LocalDate.of(2016, 11, 7);
        int year = date.getYear(); // 年份, 2016
        Month month = date.getMonth(); // 月份, NOVEMBER
        int monthValue = date.getMonthValue(); // 月份, 11
        int dayOfMonth = date.getDayOfMonth(); // 第几天, 7
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 星期几, MONDAY
        int lengthOfMonth = date.lengthOfMonth();// 当月天数, 30
        boolean leap = date.isLeapYear(); // 是否闰年, true
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE)); // 20161107

        LocalDate today = LocalDate.now();
        int thisYear = today.get(ChronoField.YEAR);
        int thisMonth = today.get(ChronoField.MONTH_OF_YEAR);
        int thisDay = today.get(ChronoField.DAY_OF_MONTH);
        LocalDate threeDaysAfterNow = today.plusDays(3);
        LocalDate oneWeekBeforeNow = today.minusWeeks(1);
        LocalDate twoYeasFromNow = today.plus(2, ChronoUnit.YEARS);

        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // ... ...
    }

    private static void localTimeUsage() {
        LocalTime time = LocalTime.of(22, 49, 32);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalTime parseTime = LocalTime.parse("22:50:20");
    }

    private static void localDateTimeUsage() {
        LocalDateTime dateTime = LocalDateTime.of(2016, Month.NOVEMBER, 7, 22, 55, 58);
        LocalDateTime now = LocalDateTime.now();

        LocalDate date = LocalDate.of(2016, 11, 7);
        LocalTime time = LocalTime.of(22, 49, 32);
        LocalDateTime dateTime1 = date.atTime(12, 12, 22);
        LocalDateTime dateTime2 = time.atDate(date);
    }

    private static void durationAndPeriodUsage() {
        // Duration主要用于以秒和纳秒衡量时间的长短
        Duration threeMinutes = Duration.ofMinutes(3);
        long seconds = threeMinutes.getSeconds();
        Duration twoMinutes = Duration.of(2, ChronoUnit.MINUTES);
        Duration d1 = Duration.between(LocalDateTime.now(), LocalDateTime.of(2016,12,19, 12, 19));

        // Period, 年月日计量
        Period twoDays = Period.ofDays(2);
        Period oneWeek = Period.ofWeeks(1);
        Period threeYearsFiveMonthsFourDay = Period.of(3, 5, 4);
        Period period = Period.between(LocalDate.of(2014, 7, 1), LocalDate.of(2016, 11, 7));
    }

}
