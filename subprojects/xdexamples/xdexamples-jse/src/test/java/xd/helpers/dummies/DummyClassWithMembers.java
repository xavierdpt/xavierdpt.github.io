package xd.helpers.dummies;

public class DummyClassWithMembers extends DummyBaseClassWithMembers {

    private int privateBaseOverridenField = 10;
    protected int protectedBaseOverridenField = 11;
    public int publicBaseOverridenField = 12;

    private boolean privateNewField = true;
    protected boolean protectedNewField = true;
    public boolean publicNewField = true;

    public DummyClassWithMembers() {
    }

    private DummyClassWithMembers(int xOverriden) {
    }

    protected DummyClassWithMembers(int xOverriden, int yOverriden) {
    }

    public DummyClassWithMembers(int xOverriden, int yOverriden, int zOverriden) {
    }

    private DummyClassWithMembers(boolean xNew) {
    }

    protected DummyClassWithMembers(boolean xNew, boolean yNew) {
    }

    public DummyClassWithMembers(boolean xNew, boolean yNew, boolean zNew) {
    }

    private String privateMethodOverriden() {
        return "DummyClassWithMembers privateMethodOverriden";
    }

    @Override
    protected String protectedMethodOverriden() {
        return "DummyClassWithMembers protectedMethodOverriden";
    }

    @Override
    public String publicMethodOverriden() {
        return "DummyClassWithMembers publicMethodOverriden";
    }

    private String privateMethodNew() {
        return "DummyClassWithMembers privateMethodNew";
    }

    protected String protectedMethodNew() {
        return "DummyClassWithMembers protectedMethodNew";
    }

    public String publicMethodNew() {
        return "DummyClassWithMembers publicMethodNew";
    }


}
