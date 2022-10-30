package xd.helpers.dummies;

public class DummyKey {
    private final String name;

    public DummyKey(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!this.getClass().equals(other.getClass())) {
            return false;
        }
        DummyKey otherKey = (DummyKey) other;
        return name.equals(otherKey.name);
    }
}
