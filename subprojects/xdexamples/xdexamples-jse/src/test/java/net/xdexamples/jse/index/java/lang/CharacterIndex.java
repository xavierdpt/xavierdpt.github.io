package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.CharacterExample_CONNECTOR_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_CONTROL;
import net.xdexamples.jse.examples.java.lang.CharacterExample_CURRENCY_SYMBOL;
import net.xdexamples.jse.examples.java.lang.CharacterExample_DASH_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_ENCLOSING_MARK;
import net.xdexamples.jse.examples.java.lang.CharacterExample_END_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_FINAL_QUOTE_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_FORMAT;
import net.xdexamples.jse.examples.java.lang.CharacterExample_INITIAL_QUOTE_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_LINE_SEPARATOR;
import net.xdexamples.jse.examples.java.lang.CharacterExample_MODIFIER_SYMBOL;
import net.xdexamples.jse.examples.java.lang.CharacterExample_PARAGRAPH_SEPARATOR;
import net.xdexamples.jse.examples.java.lang.CharacterExample_START_PUNCTUATION;
import net.xdexamples.jse.examples.java.lang.CharacterExample_UNASSIGNED;
import net.xdexamples.jse.examples.java.lang.CharacterExample_charCount;
import net.xdexamples.jse.examples.java.lang.CharacterExample_getDirectionality;
import net.xdexamples.jse.examples.java.lang.CharacterExample_hashCode;
import net.xdexamples.jse.examples.java.lang.CharacterExample_highSurrogate;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isBmpCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isDefined;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isDigitChar;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isDigitCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isHighSurrogate;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isIdeographic;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isLetter;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isLowSurrogate;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isLowerCaseChar;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isLowerCaseCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isMirrored;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isSpaceChar;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isSupplementaryCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isSurrogate;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isSurrogatePair;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isTitleCaseCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isUpperCaseCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isValidCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_isWhitespace;
import net.xdexamples.jse.examples.java.lang.CharacterExample_lowSurrogate;
import net.xdexamples.jse.examples.java.lang.CharacterExample_toCodePoint;
import net.xdexamples.jse.examples.java.lang.CharacterExample_toString;
import net.xdexamples.jse.examples.java.lang.CharacterExample_getType;
import net.xdexamples.jse.examples.java.lang.CharacterExample_valueOf_charValue;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.Examples;
import net.xdexamples.support.internal.Scaffolded;
import xdtest.ToBeContinued;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

@ToBeContinued
@Bundle(EBundle.CORE)
@Examples({
        @Example(value = CharacterExample_valueOf_charValue.class, illustrated = {"valueOf", "charValue"}),
        @Example(value = CharacterExample_hashCode.class, illustrated = {"hashCode"}),
        @Example(value = CharacterExample_toString.class, illustrated = {"toString"}),
        @Example(value = CharacterExample_isSurrogate.class, illustrated = {"isSurrogate"}),
        @Example(value = CharacterExample_isHighSurrogate.class, illustrated = {"isHighSurrogate"}),
        @Example(value = CharacterExample_isLowSurrogate.class, illustrated = {"isLowSurrogate"}),
        @Example(value = CharacterExample_isSurrogatePair.class, illustrated = {"isSurrogatePair"}),
        @Example(value = CharacterExample_highSurrogate.class, illustrated = {"highSurrogate"}),
        @Example(value = CharacterExample_lowSurrogate.class, illustrated = {"lowSurrogate"}),
        @Example(value = CharacterExample_isBmpCodePoint.class, illustrated = {"isBmpCodePoint"}),
        @Example(value = CharacterExample_charCount.class, illustrated = {"charCount"}),
        @Example(value = CharacterExample_toCodePoint.class, illustrated = {"toCodePoint"}),
        @Example(value = CharacterExample_isValidCodePoint.class, illustrated = {"isValidCodePoint"}),
        @Example(value = CharacterExample_isSupplementaryCodePoint.class, illustrated = {"isSupplementaryCodePoint"}),
        @Example(value = CharacterExample_isDigitCodePoint.class, illustrated = {"isDigit"}),
        @Example(value = CharacterExample_isDigitChar.class, illustrated = {"isDigit"}),
        @Example(value = CharacterExample_isLowerCaseChar.class, illustrated = {"isLowerCase"}),
        @Example(value = CharacterExample_isLowerCaseCodePoint.class, illustrated = {"isLowerCase"}),
        @Example(value = CharacterExample_isUpperCaseCodePoint.class, illustrated = {"isUpperCase"}),
        @Example(value = CharacterExample_isTitleCaseCodePoint.class, illustrated = {"isTitleCase"}),
        @Example(value = CharacterExample_isLetter.class, illustrated = {"isLetter"}),
        @Example(value = CharacterExample_isDefined.class, illustrated = {"isDefined"}),
        @Example(value = CharacterExample_isIdeographic.class, illustrated = {"isIdeographic"}),
        @Example(value = CharacterExample_isSpaceChar.class, illustrated = {"isSpaceChar"}),
        @Example(value = CharacterExample_isWhitespace.class, illustrated = {"isWhitespace"}),
        @Example(value = CharacterExample_getType.class, illustrated = {"getType"}),
        @Example(value = CharacterExample_LINE_SEPARATOR.class, illustrated = {"LINE_SEPARATOR"}),
        @Example(value = CharacterExample_PARAGRAPH_SEPARATOR.class, illustrated = {"PARAGRAPH_SEPARATOR"}),
        @Example(value = CharacterExample_INITIAL_QUOTE_PUNCTUATION.class, illustrated = {"INITIAL_QUOTE_PUNCTUATION"}),
        @Example(value = CharacterExample_FINAL_QUOTE_PUNCTUATION.class, illustrated = {"FINAL_QUOTE_PUNCTUATION"}),
        @Example(value = CharacterExample_MODIFIER_SYMBOL.class, illustrated = {"MODIFIER_SYMBOL"}),
        @Example(value = CharacterExample_CURRENCY_SYMBOL.class, illustrated = {"CURRENCY_SYMBOL"}),
        @Example(value = CharacterExample_CONNECTOR_PUNCTUATION.class, illustrated = {"CONNECTOR_PUNCTUATION"}),
        @Example(value = CharacterExample_END_PUNCTUATION.class, illustrated = {"END_PUNCTUATION"}),
        @Example(value = CharacterExample_START_PUNCTUATION.class, illustrated = {"START_PUNCTUATION"}),
        @Example(value = CharacterExample_DASH_PUNCTUATION.class, illustrated = {"DASH_PUNCTUATION"}),
        @Example(value = CharacterExample_FORMAT.class, illustrated = {"FORMAT"}),
        @Example(value = CharacterExample_CONTROL.class, illustrated = {"CONTROL"}),
        @Example(value = CharacterExample_ENCLOSING_MARK.class, illustrated = {"ENCLOSING_MARK"}),
        @Example(value = CharacterExample_UNASSIGNED.class, illustrated = {"UNASSIGNED"}),
        @Example(value = CharacterExample_getDirectionality.class, illustrated = {"getDirectionality"}),
        @Example(value = CharacterExample_isMirrored.class, illustrated = {"isMirrored"}),
})
public class CharacterIndex extends BaseExample<Character> {

    @Override
    protected void scaffold(Character instance) throws Throwable {
        Optional<DynamicConstantDesc<Character>> characterDynamicConstantDesc = instance.describeConstable();
        char ch = 0;

        Character other = null;
        boolean equals = instance.equals(other);
        int codePoint = 0;

        CharSequence charSequence = null;
        int index = 0;
        int i4 = Character.codePointAt(charSequence, index);
        char[] chars = new char[0];
        int i5 = Character.codePointAt(chars, index);
        int limit = 0;
        int i6 = Character.codePointAt(chars, index, limit);
        int i7 = Character.codePointBefore(charSequence, index);
        int i8 = Character.codePointBefore(chars, index);
        int start = 0;
        int i9 = Character.codePointBefore(chars, index, start);
        char[] chars1 = Character.toChars(codePoint);
        int i10 = Character.toChars(codePoint, chars, index);
        int beginIndex = 0;
        int endIndex = 0;
        int i11 = Character.codePointCount(charSequence, beginIndex, endIndex);
        int offset = 0;
        int count = 0;
        int i12 = Character.codePointCount(chars, offset, count);
        int i13 = Character.offsetByCodePoints(charSequence, index, offset);
        int i14 = Character.offsetByCodePoints(chars, start, count, index, offset);
        boolean upperCase = Character.isUpperCase(ch);
        boolean titleCase = Character.isTitleCase(ch);
        boolean defined = Character.isDefined(ch);
        boolean letter = Character.isLetter(ch);
        boolean letterOrDigit = Character.isLetterOrDigit(ch);
        boolean letterOrDigit1 = Character.isLetterOrDigit(codePoint);
        boolean alphabetic = Character.isAlphabetic(codePoint);
        boolean javaIdentifierStart = Character.isJavaIdentifierStart(ch);
        boolean javaIdentifierStart1 = Character.isJavaIdentifierStart(codePoint);
        boolean javaIdentifierPart = Character.isJavaIdentifierPart(ch);
        boolean javaIdentifierPart1 = Character.isJavaIdentifierPart(codePoint);
        boolean unicodeIdentifierStart = Character.isUnicodeIdentifierStart(ch);
        boolean unicodeIdentifierStart1 = Character.isUnicodeIdentifierStart(codePoint);
        boolean unicodeIdentifierPart = Character.isUnicodeIdentifierPart(ch);
        boolean unicodeIdentifierPart1 = Character.isUnicodeIdentifierPart(codePoint);
        boolean identifierIgnorable = Character.isIdentifierIgnorable(ch);
        boolean identifierIgnorable1 = Character.isIdentifierIgnorable(codePoint);
        char c3 = Character.toLowerCase(ch);
        int i15 = Character.toLowerCase(codePoint);
        char c4 = Character.toUpperCase(ch);
        int i16 = Character.toUpperCase(codePoint);
        char c5 = Character.toTitleCase(ch);
        int i17 = Character.toTitleCase(codePoint);
        int radix = 0;
        int digit2 = Character.digit(ch, radix);
        int digit3 = Character.digit(codePoint, radix);
        int numericValue = Character.getNumericValue(ch);
        int numericValue1 = Character.getNumericValue(codePoint);
        boolean spaceChar = Character.isSpaceChar(ch);
        boolean whitespace = Character.isWhitespace(ch);
        boolean isoControl = Character.isISOControl(ch);
        boolean isoControl1 = Character.isISOControl(codePoint);
        int type = Character.getType(ch);
        int digitt = 0;
        char c6 = Character.forDigit(digitt, radix);
        byte directionality = Character.getDirectionality(ch);
        boolean mirrored = Character.isMirrored(ch);

        int i18 = instance.compareTo(other);
        char chx = 0;
        char chy = 0;
        int compare = Character.compare(chx, chy);
        char c7 = Character.reverseBytes(ch);
        String name = Character.getName(codePoint);
        int i19 = Character.codePointOf(name);

        int minRadix = Character.MIN_RADIX;
        int maxRadix = Character.MAX_RADIX;
        char minValue = Character.MIN_VALUE;
        char maxValue = Character.MAX_VALUE;
        Class<Character> type2 = Character.TYPE;
        byte uppercaseLetter = Character.UPPERCASE_LETTER;
        byte lowercaseLetter = Character.LOWERCASE_LETTER;
        byte titlecaseLetter = Character.TITLECASE_LETTER;
        byte modifierLetter = Character.MODIFIER_LETTER;
        byte otherLetter = Character.OTHER_LETTER;
        byte nonSpacingMark = Character.NON_SPACING_MARK;
        byte combiningSpacingMark = Character.COMBINING_SPACING_MARK;
        byte decimalDigitNumber = Character.DECIMAL_DIGIT_NUMBER;
        byte letterNumber = Character.LETTER_NUMBER;
        byte otherNumber = Character.OTHER_NUMBER;
        byte spaceSeparator = Character.SPACE_SEPARATOR;
        byte privateUse = Character.PRIVATE_USE;
        byte surrogate1 = Character.SURROGATE;
        byte otherPunctuation = Character.OTHER_PUNCTUATION;
        byte mathSymbol = Character.MATH_SYMBOL;
        byte otherSymbol = Character.OTHER_SYMBOL;
        byte directionalityUndefined = Character.DIRECTIONALITY_UNDEFINED;
        byte directionalityLeftToRight = Character.DIRECTIONALITY_LEFT_TO_RIGHT;
        byte directionalityRightToLeft = Character.DIRECTIONALITY_RIGHT_TO_LEFT;
        byte directionalityRightToLeftArabic = Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
        byte directionalityEuropeanNumber = Character.DIRECTIONALITY_EUROPEAN_NUMBER;
        byte directionalityEuropeanNumberSeparator = Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR;
        byte directionalityEuropeanNumberTerminator = Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR;
        byte directionalityArabicNumber = Character.DIRECTIONALITY_ARABIC_NUMBER;
        byte directionalityCommonNumberSeparator = Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR;
        byte directionalityNonspacingMark = Character.DIRECTIONALITY_NONSPACING_MARK;
        byte directionalityBoundaryNeutral = Character.DIRECTIONALITY_BOUNDARY_NEUTRAL;
        byte directionalityParagraphSeparator = Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR;
        byte directionalitySegmentSeparator = Character.DIRECTIONALITY_SEGMENT_SEPARATOR;
        byte directionalityWhitespace = Character.DIRECTIONALITY_WHITESPACE;
        byte directionalityOtherNeutrals = Character.DIRECTIONALITY_OTHER_NEUTRALS;
        byte directionalityLeftToRightEmbedding = Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING;
        byte directionalityLeftToRightOverride = Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE;
        byte directionalityRightToLeftEmbedding = Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING;
        byte directionalityRightToLeftOverride = Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE;
        byte directionalityPopDirectionalFormat = Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT;
        byte directionalityLeftToRightIsolate = Character.DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE;
        byte directionalityRightToLeftIsolate = Character.DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE;
        byte directionalityFirstStrongIsolate = Character.DIRECTIONALITY_FIRST_STRONG_ISOLATE;
        byte directionalityPopDirectionalIsolate = Character.DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE;
        char minHighSurrogate = Character.MIN_HIGH_SURROGATE;
        char maxHighSurrogate = Character.MAX_HIGH_SURROGATE;
        char minLowSurrogate = Character.MIN_LOW_SURROGATE;
        char maxLowSurrogate = Character.MAX_LOW_SURROGATE;
        char minSurrogate = Character.MIN_SURROGATE;
        char maxSurrogate = Character.MAX_SURROGATE;
        int minSupplementaryCodePoint = Character.MIN_SUPPLEMENTARY_CODE_POINT;
        int minCodePoint = Character.MIN_CODE_POINT;
        int maxCodePoint = Character.MAX_CODE_POINT;
        int size = Character.SIZE;
        int bytes = Character.BYTES;
    }

}
