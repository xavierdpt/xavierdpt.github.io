package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

@Scaffolded
public class CurrencyExample extends BaseExample<Currency> {
    @Override
    public void scaffold(Currency instance) throws Throwable {

        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();

        String currencyCode = instance.getCurrencyCode();

        int defaultFractionDigits = instance.getDefaultFractionDigits();

        Locale locale = null;
        String displayName = instance.getDisplayName();
        String displayName1 = instance.getDisplayName(locale);

        Currency instance1 = Currency.getInstance(currencyCode);
        Currency instance2 = Currency.getInstance(locale);

        int numericCode = instance.getNumericCode();
        String numericCodeAsString = instance.getNumericCodeAsString();
        String symbol = instance.getSymbol();
        String symbol1 = instance.getSymbol(locale);

        String s = instance.toString();

    }
}
