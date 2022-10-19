package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class BitsBytes extends Page {

    public BitsBytes() {
        super("bitsAndBytes", "Bits and Bytes");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        section("The Bit");
        p("At first, there was the bit");
        p("The bit has always been there");
        p("Day, night, true or false, one or the other, things always are or are not, there is no in-between.");
        p("In computers, bits are 0 or 1, if a bit is not 0, then it is 1, if it is 0, then it is not 1, and reciprocally.");
        p("In other words, with one bit, you can encode two values.");
        p("Set the bit to 0, you have encoded 0, set the bit to 1, you have encoded 1.");

        section("Two bits");
        p("If you have two bits, you can do more things. One bit gives you two possibilities, and for each of those, the other bit gives you two other possibities. ");
        p("That makes 4 possibilities in total.");
        p("With two bits, you can encode four values.");
        p("For example, you can encode zero as `00`, one as `01`, two as `10`, three as `11`.");
        p("You've just invented the 2-bit unsigned integer.");

        section("Two's complement notation");
        p("The other day, I met a guy, he wanted negative numbers.");
        p("I said I can make numbers, but only with 2 bits.");
        p("He said, that's ok, I don't need too many numbers.");
        p("I said, do you need positive numbers too ?");
        p("He said, yes, it would be nice to have both");
        p("So I said, ok, here's what we'll do, when the first bit is 0, it will be positive, so that gives zero as `00`, and one as `01`.");
        p("When the first bit is 1, then it's a negative number, but here's the trick, to get it, you invert all the other bits, and that makes your positive nubmer.");
        p("So `10` becomes `01` which is minus one, and `11` becomes `00`, and that's minus zero.");
        p("He said, that seems promising, but there are not so many bits here, and zero and minus zero are really the same thing.");
        p("I said, yes, agreed, then subtract one, so `01` becomes `01`, and that makes minus one, subtract one, that makes minus two.");
        p("And `11` becomes `00`, and that makes minus zero, subtract one, that makes minus one.");
        p("So now, we can encode minus two, minus one, zero and one with two bits.");
        p("He said, well, ok, but if ask for minus two, I get two, and I cannot encode that with my two bits now.");
        p("I said, indeed, you would need to buy more bits.");
        p("He said, well I will have the same problem with more bits.");
        p("I said, how many bits do you really need ?");

        section("Three bits");
        p("With three bits, you can encode twice more values as with two bits, that makes eight values.");
        p("So, you can now talks about 1, 2, 3, 4, 5, 6, 7, and that's all.");
        p("But that's not very useful or convenient.");

        section("Four bits");
        p("With four bits, you can encode sixteen values.");
        p("Now, if you start counting, it will go like this: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15.");
        p("But that's not convenient, because we end up with numbers with two digits, and we will have to use extra space to resolve alignment issues, and we really don't want that.");
        p("So instead, we start using alphabet letters, and that gives 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F");
        p("And if you like lowercase letters, that works two.");
        p("That's call the hexadecimal notation because it uses sixteen symbols.");

        section("Five bits, six bits");
        p("When electric systems communicate between themselves, some use one electric wire for each bit.");
        p("So more bits, more wires.");
        p("Some system use five bits, because they don't need more than that, other may use six, or more.");

        section("Seven bits");
        p("The ASCII standard use 7 bits to encode most common characters.");
        p("This include uppercase letters, lowercase letters, digits, punctuation symbols, and some other symbols.");
        p("It also includes non-printable control characters that were very useful for early to transmit things to print on the screen as well as things to do, such as move the cursor to left, down one line, or to the beginning of the line.");

        section("Eight bits");
        p("Now it get's interesting, because eight is a very particular number.");
        p("If you divide it by four, you get four bits, and that's a nibble.");
        p("And you can describe nibbles using the hexadecimal notation.");
        p("So you can describe two nibbles with the hexadecimal notation.");
        p("So you ca describe octets using hexadecimal notation.");
        p("And that's very convenient.");
        p("In addition, you encode 256 different values, and that's good enough for many purposes.");
        p("This make one of the core units of computers.");
        p("In many computers, you cannot ask for one bit without getting seven other bits you do not care about, and that's because of that.");
        p("And that makes the byte.");
        p("With an unsigned byte, you get the numbers 0 to 255, or 00 to FF in hexadecimal notation.");
        p("With a signed byte, you get the numbers -128 to 127 using two's complement, where, in hexadecimal notation, `00` encodes zero, `FF` encodes minus one");

        section("Two bytes");
        p("Two bytes is sixteen bits, and that's called a short number.");
        p("You can have signed or unsigned shorts.");
        p("They are short, because most CPUs nowadays use...");

        section("Four bytes");
        p("With four bytes, you get regular 32-bit integers.");
        p("Many CPUs used to like that, but nowadays, it's no longer enough.");
        p("You can have unsigned integers, or signed integers.");
        p("To describe 32-bit integers, you need eight nibbles.");
        p("That's find, but it's starting to be a limit.");
        p("By the way, nobody use three bytes, it's not convenient.");

        section("Eight bytes");
        p("With eight bytes, you get the modern 64-bit integers.");
        p("Many CPUs now use 64-bit integers.");
        p("That's because computer memory are becoming so large that you need big numbers to identify individual memory cells.");
        p("With eight bytes, you get long integers, which can be signed or unsigned, still using two's complemenet.");
        p("Eight bytes can be represented with sixteen nibbles, and is starting to be enough to be too many.");
        p("A lot of representation scheme introduce additional separators, and means to transmit less characters when most bytes are zero.");
        p("Some other schemes introduce the concept of prefix, so that only the suffix need to be specified.");

        section("Characters");

        p("Back to characters, we stopped at ASCII, which uses 7 bits.");
        p("With eight bits, you get twice more slots to add additional characters.");
        p("Many character encoding standards used the ASCII characters, then added additional characters depending on the targeted use.");
        p("Some added accentuated european characters, other added greek or cyrillic characters.");
        p("But eight bits is really not enough to represent everything we need.");
        p("Unicode introduced a standard that used 32 bits, but 32 bits is too many when most in existence, will have 3 bytes consistently at 0.");
        p("This is why they also defined a varying length encoding that only need one byte for ASCII, then more bytes as needed.");




    }
}
