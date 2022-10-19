package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Scaffolded
public class LocaleExample extends BaseExample<Locale> {

    @Override
    public void scaffold(Locale instance) throws Throwable {
        String language = null;
        String country = null;
        String variant = null;
        ignore(
                new Locale(language),
                new Locale(language, country),
                new Locale(language, country, variant)
        );

        Locale other = null;
        List<Locale.LanguageRange> priorityList = null;
        Collection<Locale> locales = null;
        Locale.FilteringMode mode = null;
        Collection<String> tags = null;
        String languageTag = null;
        Locale.Category category = null;
        char extensionKey = 0;
        Locale.IsoCountryCode isoCountryCodeType = null;
        String ultKey = null;

        Object clone = instance.clone();
        boolean equals = instance.equals(other);
        List<Locale> locales1 = Locale.filter(priorityList, locales);
        List<Locale> locales2 = Locale.filter(priorityList, locales, mode);
        Locale.filterTags(priorityList, tags);
        Locale.filterTags(priorityList, tags, mode);
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale[] availableLocales = Locale.getAvailableLocales();
        String country1 = instance.getCountry();
        Locale aDefault = Locale.getDefault();
        Locale aDefault1 = Locale.getDefault(category);
        String displayCountry = instance.getDisplayCountry();
        String displayCountry1 = instance.getDisplayCountry(locale);
        String displayLanguage = instance.getDisplayLanguage();
        String displayLanguage1 = instance.getDisplayLanguage(locale);
        String displayName = instance.getDisplayName();
        String displayName1 = instance.getDisplayName(locale);
        String displayScript = instance.getDisplayScript();
        String displayScript1 = instance.getDisplayScript(locale);
        String displayVariant = instance.getDisplayVariant();
        String displayVariant1 = instance.getDisplayVariant(locale);
        String extension = instance.getExtension(extensionKey);
        Set<Character> extensionKeys = instance.getExtensionKeys();
        String iso3Country = instance.getISO3Country();
        String iso3Language = instance.getISO3Language();
        String[] isoCountries = Locale.getISOCountries();
        Set<String> isoCountries1 = Locale.getISOCountries(isoCountryCodeType);
        String[] isoLanguages = Locale.getISOLanguages();
        String language1 = instance.getLanguage();
        String script = instance.getScript();
        Set<String> unicodeLocaleAttributes = instance.getUnicodeLocaleAttributes();
        Set<String> unicodeLocaleKeys = instance.getUnicodeLocaleKeys();
        String unicodeLocaleType = instance.getUnicodeLocaleType(ultKey);
        String variant1 = instance.getVariant();
        boolean b = instance.hasExtensions();
        int i = instance.hashCode();
        Locale lookup = Locale.lookup(priorityList, locales);
        String s = Locale.lookupTag(priorityList, tags);
        Locale.setDefault(locale);
        Locale.setDefault(category, locale);
        Locale locale1 = instance.stripExtensions();
        String s1 = instance.toLanguageTag();
        String s2 = extension.toString();

        Locale canada = Locale.CANADA;
        Locale canadaFrench = Locale.CANADA_FRENCH;
        Locale china = Locale.CHINA;
        Locale chinese = Locale.CHINESE;
        Locale english = Locale.ENGLISH;
        Locale france = Locale.FRANCE;
        Locale french = Locale.FRENCH;
        Locale german = Locale.GERMAN;
        Locale germany = Locale.GERMANY;
        Locale italian = Locale.ITALIAN;
        Locale italy = Locale.ITALY;
        Locale japan = Locale.JAPAN;
        Locale japanese = Locale.JAPANESE;
        Locale korea = Locale.KOREA;
        Locale korean = Locale.KOREAN;
        Locale prc = Locale.PRC;
        char privateUseExtension = Locale.PRIVATE_USE_EXTENSION;
        Locale root = Locale.ROOT;
        Locale simplifiedChinese = Locale.SIMPLIFIED_CHINESE;
        Locale taiwan = Locale.TAIWAN;
        Locale traditionalChinese = Locale.TRADITIONAL_CHINESE;
        Locale uk = Locale.UK;
        char unicodeLocaleExtension = Locale.UNICODE_LOCALE_EXTENSION;
        Locale us = Locale.US;
    }

}
