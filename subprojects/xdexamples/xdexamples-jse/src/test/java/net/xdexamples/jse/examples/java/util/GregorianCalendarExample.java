package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

@Scaffolded
public class GregorianCalendarExample extends BaseExample<GregorianCalendar> {

    @Override
    public void scaffold(GregorianCalendar instance) throws Throwable {

        TimeZone timeZone = null;
        Locale locale = null;
        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hourOfDay = 0;
        int minute = 0;
        int second = 0;
        ignore(
                new GregorianCalendar(),
                new GregorianCalendar(timeZone),
                new GregorianCalendar(locale),
                new GregorianCalendar(timeZone, locale),
                new GregorianCalendar(year, month, dayOfMonth),
                new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute),
                new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second)
        );

        int ad = GregorianCalendar.AD;
        int bc = GregorianCalendar.BC;

        int field = 0;
        int amount = 0;
        instance.add(field, amount);

        Object clone = instance.clone();

        GregorianCalendar other = null;
        instance.equals(other);

        ZonedDateTime zonedDateTime = null;
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);

        int actualMaximum = instance.getActualMaximum(field);
        int actualMinimum = instance.getActualMinimum(field);
        String calendarType = instance.getCalendarType();
        int greatestMinimum = instance.getGreatestMinimum(field);
        Date gregorianChange = instance.getGregorianChange();
        int leastMaximum = instance.getLeastMaximum(field);
        int maximum = instance.getMaximum(field);
        int minimum = instance.getMinimum(field);
        TimeZone timeZone1 = instance.getTimeZone();
        int weekYear = instance.getWeekYear();
        int weeksInWeekYear = instance.getWeeksInWeekYear();
        int i = instance.hashCode();
        boolean leapYear = instance.isLeapYear(year);
        boolean weekDateSupported = instance.isWeekDateSupported();
        boolean up = false;
        instance.roll(field, up);
        instance.roll(field, amount);
        Date date = null;
        instance.setGregorianChange(date);
        instance.setTimeZone(timeZone);
        int weekOfYear = 0;
        int dayOfWeak = 0;
        instance.setWeekDate(weekYear, weekOfYear, dayOfWeak);
        ZonedDateTime zonedDateTime1 = instance.toZonedDateTime();
    }
}
