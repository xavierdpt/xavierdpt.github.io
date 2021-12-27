package pm;

public enum Number {
    SINGULAR, PLURAL;

    public String format(T term) {
        switch (this) {
            case SINGULAR:
                return term.s();
            case PLURAL:
                return term.p();
        }
        throw new IllegalStateException();
    }
}
