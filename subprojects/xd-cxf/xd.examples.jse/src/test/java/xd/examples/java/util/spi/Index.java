package xd.examples.java.util.spi;

import java.util.spi.AbstractResourceBundleProvider;
import java.util.spi.CalendarDataProvider;
import java.util.spi.CalendarNameProvider;
import java.util.spi.CurrencyNameProvider;
import java.util.spi.LocaleNameProvider;
import java.util.spi.LocaleServiceProvider;
import java.util.spi.ResourceBundleControlProvider;
import java.util.spi.ResourceBundleProvider;
import java.util.spi.TimeZoneNameProvider;
import java.util.spi.ToolProvider;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    AbstractResourceBundleProvider.class,
                    CalendarDataProvider.class,
                    CalendarNameProvider.class,
                    CurrencyNameProvider.class,
                    LocaleNameProvider.class,
                    LocaleServiceProvider.class,
                    ResourceBundleControlProvider.class,
                    ResourceBundleProvider.class,
                    TimeZoneNameProvider.class,
                    ToolProvider.class
            ));
        }
    }

}
