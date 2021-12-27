package pm;

import static java.util.Objects.requireNonNull;

public enum T {
    APPLICATION("Application"),
    APPLIED_KNOWLEDGE("Applied knowledge"),
    A_GUIDE_TO_THE_PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE("A Guide to the Project Management Body of Knowledge (PMBOK® Guide)"),
    BASELINE("Baseline"),
    BODY_OF_KNOWLEDGE("Body of knowledge"),
    CHART("Chart", "Charts"),
    CONSENSUS("Consensus"),
    CUSTOMER("Customer", "Customers"),
    DISCIPLINE("Discipline", "Disciplines"),
    EXPECTED_BUSINESS_RESULT("Expected business result", "Expected business results"),
    EXPECTED_BUSINESS_VALUE("Expected business value", "Expected business values"),
    FOUNDATION("Foundation", "Foundations"),
    GENERALLY_RECOGNIZED("Generally recognized"),
    GENERAL_AGREEMENT("General agreement"),
    GLOSSARY("Glossary", "Glossaries"),
    GOOD_PRACTICE("Good practice", "Good practices"),
    INNOVATIVE_PRACTICE("Innovative practice", "Innovative practices"),
    INPUT("Input", "Inputs"),
    KNOWLEDGE("Knowledge"),
    LEADER("Leader", "Leaders"),
    LIFE_CYCLE_PHASE("Life cycle phase", "Life cycle phases"),
    MANAGER("Manager", "Managers"),
    METHODOLOGY("Methodology","Methodologies"),
    ORGANIZATION("Organization", "Organizations"),
    OUTCOME("Outcome", "Outcomes"),
    OUTPUT("Output", "Outputs"),
    POLICY("Policy", "Policies"),
    PRACTICE("Practice", "Practices"),
    PRINCIPLE("Principle", "Principles"),
    PROCEDURE("Procedure", "Procedures"),
    PROCESS("Process", "Processes"),
    PROFESSION("Profession"),
    PROJECT("Project", "Projects"),
    PROJECT_MANAGEMENT("Project management"),
    PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE("Project management body of knowledge"),
    PROJECT_MANAGEMENT_INSTITUTE("Project Management Institute"),
    PROJECT_MANAGEMENT_PROCESS("Project management process", "Project management processes"),
    PROJECT_MANAGER("Project manager", "Project managers"),
    PROJECT_TEAM("Project team", "Project teams"),
    PUBLISHED_MATERIAL("Published material", "Published materials"),
    RULE("Rule", "Rules"),
    SKILL("Skill", "Skills"),
    STAKEHOLDERS("Stakeholder", "Stakeholders"),
    SYSTEM("System", "Sytems"),
    TAILORING("Tailoring"),
    TECHNIQUE("Technique", "Techniques"),
    TERM("Term", "Terms"),
    TOOL("Tool", "Tools"),
    TRADITIONAL_PRACTICE("Traditional practice", "Traditional practices"),
    UNPUBLISHED_MATERIAL("Unpublished material", "Unpublished materials"),
    USEFULNESS("Usefulness"),
    VALUE("Value"),
    ;

    private final String singular;
    private final String plural;

    T(String text) {
        this.singular = text;
        this.plural = text;
    }

    T(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
    }


    public String s() {
        return requireNonNull(singular);
    }

    public String p() {
        return requireNonNull(plural);
    }
}
