package pm;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private final Number number;
    private final List<T> terms = new ArrayList<>();

    public Bag(Number number, T... terms) {
        this.number = number;
        for (T term : terms) {
            this.terms.add(term);
        }
    }

    public String toString() {
        System.out.println(stack());
        System.out.println(bbox());
        StringBuilder sb = new StringBuilder();
        boolean sep = false;
        sb.append("[");
        for (T term : terms) {
            if (sep) {
                sb.append("/");
            }
            sb.append(number.format(term));
            sep = true;
        }
        sb.append("]");
        return sb.toString();
    }

    private BoundingBox bbox() {
        int max = 0;
        for (T term : terms) {
            int l = number.format(term).length();
            max = l > max ? l : max;
        }
        return new BoundingBox(0, 0, max + 4, terms.size() + 2);
    }

    private String stack() {
        List<String> formatted = new ArrayList<>();
        int maxLength = 0;
        for (T term : terms) {
            String s = number.format(term);
            maxLength = s.length() > maxLength ? s.length() : maxLength;
            formatted.add(s);
        }
        StringBuilder sb = new StringBuilder();

        // header
        sb.append("+");
        for (int i = 0; i < maxLength + 2; ++i) {
            sb.append("-");
        }
        sb.append("+");
        sb.append("\n");

        for (String f : formatted) {
            sb.append("| ").append(f);
            for (int i = f.length(); i < maxLength; ++i) {
                sb.append(" ");
            }
            sb.append(" |").append("\n");
        }

        // footer
        sb.append("+");
        for (int i = 0; i < maxLength + 2; ++i) {
            sb.append("-");
        }
        sb.append("+");
        sb.append("\n");

        return sb.toString();
    }
}
