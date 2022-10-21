package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

@Scaffolded
public class CalendarExample extends BaseExample<Calendar> {

    @Override
    public void scaffold(Calendar instance) {

        int field = 0;
        int amount = 0;
        instance.add(field, amount);

        Object when = null;
        boolean after = instance.after(when);

        boolean before = instance.before(when);

        instance.clear();
        instance.clear(field);

        Object clone = instance.clone();

        Calendar other = null;
        int i = instance.compareTo(other);

        boolean equals = instance.equals(other);

        int i1 = instance.get(field);

        int actualMaximum = instance.getActualMaximum(field);

        int actualMinimum = instance.getActualMinimum(field);

        Set<String> availableCalendarTypes = Calendar.getAvailableCalendarTypes();

        Locale[] availableLocales = Calendar.getAvailableLocales();

        String calendarType = instance.getCalendarType();

        int style = 0;
        Locale locale = null;
        String displayName = instance.getDisplayName(field, style, locale);

        Map<String, Integer> displayNames = instance.getDisplayNames(field, style, locale);

        int firstDayOfWeek = instance.getFirstDayOfWeek();

        int greatestMinimum = instance.getGreatestMinimum(field);

        TimeZone timeZone = null;
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance(timeZone);
        Calendar instance3 = Calendar.getInstance(locale);
        Calendar instance4 = Calendar.getInstance(timeZone, locale);

        int leastMaximum = instance.getLeastMaximum(field);

        int maximum = instance.getMaximum(field);

        int minimalDaysInFirstWeek = instance.getMinimalDaysInFirstWeek();

        int minimum = instance.getMinimum(field);

        Date time = instance.getTime();

        long timeInMillis = instance.getTimeInMillis();

        TimeZone timeZone1 = instance.getTimeZone();

        int weekYear = instance.getWeekYear();

        int weeksInWeekYear = instance.getWeeksInWeekYear();

        int i2 = instance.hashCode();

        boolean lenient1 = instance.isLenient();

        boolean set = instance.isSet(field);

        boolean weekDateSupported = instance.isWeekDateSupported();

        boolean up = false;
        instance.roll(field, up);
        instance.roll(field, amount);

        int value = 0;
        int year = 0;
        int month = 0;
        int date = 0;
        int hour = 0;
        int minute = 0;
        int second = 0;

        instance.set(field, value);
        instance.set(year, month, date);
        instance.set(year, month, date, hour, minute);
        instance.set(year, month, date, hour, minute, second);

        instance.setFirstDayOfWeek(value);

        boolean lenient = false;
        instance.setLenient(lenient);

        instance.setMinimalDaysInFirstWeek(value);

        Date dateTime = null;
        instance.setTime(dateTime);

        long millis = 0;
        instance.setTimeInMillis(millis);

        instance.setTimeZone(timeZone);


        int weekOfYear = 0;
        int dayOfWeek = 0;
        instance.setWeekDate(weekYear, weekOfYear, dayOfWeek);

        Instant instant = instance.toInstant();

        String s = instance.toString();


        int era = Calendar.ERA;
        int year1 = Calendar.YEAR;
        int month1 = Calendar.MONTH;
        int weekOfYear1 = Calendar.WEEK_OF_YEAR;
        int weekOfMonth = Calendar.WEEK_OF_MONTH;
        int date1 = Calendar.DATE;
        int dayOfMonth = Calendar.DAY_OF_MONTH;
        int dayOfYear = Calendar.DAY_OF_YEAR;
        int dayOfWeek1 = Calendar.DAY_OF_WEEK;
        int dayOfWeekInMonth = Calendar.DAY_OF_WEEK_IN_MONTH;
        int amPm = Calendar.AM_PM;
        int hour1 = Calendar.HOUR;
        int hourOfDay = Calendar.HOUR_OF_DAY;
        int minute1 = Calendar.MINUTE;
        int second1 = Calendar.SECOND;
        int millisecond = Calendar.MILLISECOND;
        int zoneOffset = Calendar.ZONE_OFFSET;
        int dstOffset = Calendar.DST_OFFSET;
        int fieldCount = Calendar.FIELD_COUNT;
        int sunday = Calendar.SUNDAY;
        int monday = Calendar.MONDAY;
        int tuesday = Calendar.TUESDAY;
        int wednesday = Calendar.WEDNESDAY;
        int thursday = Calendar.THURSDAY;
        int friday = Calendar.FRIDAY;
        int saturday = Calendar.SATURDAY;
        int january = Calendar.JANUARY;
        int february = Calendar.FEBRUARY;
        int march = Calendar.MARCH;
        int april = Calendar.APRIL;
        int may = Calendar.MAY;
        int june = Calendar.JUNE;
        int july = Calendar.JULY;
        int august = Calendar.AUGUST;
        int september = Calendar.SEPTEMBER;
        int october = Calendar.OCTOBER;
        int november = Calendar.NOVEMBER;
        int december = Calendar.DECEMBER;
        int undecimber = Calendar.UNDECIMBER;
        int am = Calendar.AM;
        int pm = Calendar.PM;
        int allStyles = Calendar.ALL_STYLES;
        int aShort = Calendar.SHORT;
        int aLong = Calendar.LONG;
        int narrowFormat = Calendar.NARROW_FORMAT;
        int narrowStandalone = Calendar.NARROW_STANDALONE;
        int shortFormat = Calendar.SHORT_FORMAT;
        int longFormat = Calendar.LONG_FORMAT;
        int shortStandalone = Calendar.SHORT_STANDALONE;
        int longStandalone = Calendar.LONG_STANDALONE;
    }

}
