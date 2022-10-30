package xd.helpers.dummies;

public class DummyBaseClassWithMembers {

    private String privateBaseField = "privateBaseField";
    protected String protectedBaseField = "protectedBaseField";
    public String publicBaseField = "publicBaseField";

    private int privateBaseOverridenField = 1;
    protected int protectedBaseOverridenField = 2;
    public int publicBaseOverridenField = 3;

    public DummyBaseClassWithMembers() {
    }

    private DummyBaseClassWithMembers(String x) {
    }

    protected DummyBaseClassWithMembers(String x, String y) {
    }

    public DummyBaseClassWithMembers(String x, String y, String z) {
    }

    private DummyBaseClassWithMembers(int xOverriden) {
    }

    protected DummyBaseClassWithMembers(int xOverriden, int yOverriden) {
    }

    public DummyBaseClassWithMembers(int xOverriden, int yOverriden, int zOverriden) {
    }

    private String privateMethod() {
        return "DummyBaseClassWithMembers privateMethod";

    }

    protected String protectedMethod() {
        return "DummyBaseClassWithMembers protectedMethod";
    }

    public String publicMethod() {
        return "DummyBaseClassWithMembers publicMethod";
    }

    private String privateMethodOverriden() {
        return "DummyBaseClassWithMembers privateMethodOverriden";
    }

    protected String protectedMethodOverriden() {
        return "DummyBaseClassWithMembers protectedMethodOverriden";
    }

    public String publicMethodOverriden() {
        return "DummyBaseClassWithMembers publicMethodOverriden";
    }


}
