package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Scaffolded
public class TimeZoneExample extends BaseExample<TimeZone> {
    @Override
    public void scaffold(TimeZone instance) throws Throwable {

        int rawOffset = 0;
        Locale locale = null;
        boolean daylight = false;
        int style = 0;
        long date = 0;
        int era = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int dayOfWeek = 0;
        int milliseconds = 0;
        ZoneId zoneId = null;
        TimeZone other = null;
        Date ddate = null;

        Object clone = instance.clone();
        String[] availableIDs = TimeZone.getAvailableIDs();
        String[] availableIDs1 = TimeZone.getAvailableIDs(rawOffset);
        int dstSavings = instance.getDSTSavings();
        TimeZone aDefault = TimeZone.getDefault();
        String displayName = instance.getDisplayName();
        String displayName1 = instance.getDisplayName(locale);
        String displayName2 = instance.getDisplayName(daylight, style);
        String displayName3 = instance.getDisplayName(daylight, style, locale);
        String id = instance.getID();
        int offset = instance.getOffset(date);
        int offset1 = instance.getOffset(era, year, month, day, dayOfWeek, milliseconds);
        int rawOffset1 = instance.getRawOffset();
        TimeZone timeZone = TimeZone.getTimeZone(id);
        TimeZone timeZone1 = TimeZone.getTimeZone(zoneId);
        instance.hasSameRules(other);
        boolean b = instance.inDaylightTime(ddate);
        boolean b1 = instance.observesDaylightTime();
        TimeZone.setDefault(timeZone);
        instance.setID(id);
        instance.setRawOffset(offset);
        ZoneId zoneId1 = instance.toZoneId();
        boolean b2 = instance.useDaylightTime();
        int aShort = TimeZone.SHORT;
        int aLong = TimeZone.LONG;
    }
}
