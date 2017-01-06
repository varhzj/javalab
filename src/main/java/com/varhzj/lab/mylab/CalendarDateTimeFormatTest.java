package com.varhzj.lab.mylab;

import org.apache.commons.lang.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by varhzj on 16-12-26.
 */
public class CalendarDateTimeFormatTest {

    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMdd-HH-mm-ss-SSS");

    private static final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMdd-HH-mm-ss-SSS");

    public void calendarTest() {
        Calendar calendar = Calendar.getInstance();
        Map<String, String> map = new HashMap<>();
        String date = String.format("%1$tY%1$tm%1$td", calendar);
        String hour = String.format("%tH", calendar);
        String minute = String.format("%tM", calendar);
        String second = String.format("%tS", calendar);
        String ms = String.format("%tL", calendar);
        map.put("date", date);
        map.put("hour", hour);
        map.put("minute", minute);
        map.put("ms", ms);
    }

    public void dateFormatTest() {
        String timeStr = "";
        synchronized (DATE_TIME_FORMAT) {
            timeStr = DATE_TIME_FORMAT.format(new Date());
        }
        Map<String, String> map = new HashMap<>();
        String[] strings = timeStr.split("-");
        String date = strings[0];
        String hour = strings[1];
        String minute = strings[2];
        String second = strings[3];
        String ms = strings[4];
        map.put("date", date);
        map.put("hour", hour);
        map.put("minute", minute);
        map.put("ms", ms);
    }

    public void fastDateFormatTest() {
        String timeStr = FAST_DATE_FORMAT.format(new Date());
        Map<String, String> map = new HashMap<>();
        String[] strings = timeStr.split("-");
        String date = strings[0];
        String hour = strings[1];
        String minute = strings[2];
        String second = strings[3];
        String ms = strings[4];
        map.put("date", date);
        map.put("hour", hour);
        map.put("minute", minute);
        map.put("ms", ms);
    }

    public static void main(String[] args) throws InterruptedException {
        CalendarDateTimeFormatTest test = new CalendarDateTimeFormatTest();
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch formatLatch = new CountDownLatch(10);
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.dateFormatTest();
                    }
                    formatLatch.countDown();
                }
            });
        }
        formatLatch.await();
        System.out.println("Cost time: " + (System.nanoTime() - start));
        CountDownLatch calendarLatch = new CountDownLatch(10);
        long start0 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.calendarTest();
                    }
                    calendarLatch.countDown();
                }
            });
        }
        calendarLatch.await();
        System.out.println("Cost time: " + (System.nanoTime() - start0));
        CountDownLatch fastLatch = new CountDownLatch(10);
        long start1 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.fastDateFormatTest();
                    }
                    fastLatch.countDown();
                }
            });
        }
        fastLatch.await();
        System.out.println("Cost time: " + (System.nanoTime() - start1));
        service.shutdown();
    }

}
