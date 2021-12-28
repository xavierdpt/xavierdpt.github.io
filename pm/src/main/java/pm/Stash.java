package pm;

public class Stash {
    public static final String TEXT;

    public static final Bag BAG_1 = new Bag(Number.PLURAL, T.PRACTICE, T.PRINCIPLE, T.PROCESS, T.TOOL, T.TECHNIQUE);

    public static final Bag BAG_2 = new Bag(Number.PLURAL, T.KNOWLEDGE, T.SKILL, T.TOOL, T.TECHNIQUE);

    public static final Bag BAG_3 = new Bag(Number.PLURAL, T.PROCESS, T.INPUT, T.TOOL, T.TECHNIQUE, T.OUTCOME, T.LIFE_CYCLE_PHASE);

    public static final Bag BAG_4 = new Bag(Number.PLURAL, T.PRACTICE, T.TECHNIQUE, T.PROCEDURE, T.RULE);

    public static final Bag BAG_5 = new Bag(Number.PLURAL, T.METHODOLOGY, T.POLICY, T.PROCEDURE, T.RULE, T.TOOL, T.TECHNIQUE, T.LIFE_CYCLE_PHASE);

    static {
        TEXT = T.PROJECT_MANAGEMENT.s() + " is not new. Examples of " +
                T.PROJECT.s() + " " + T.OUTCOME.p() +
                " include:\n" +
                "\n" +
                "The " +
                T.OUTCOME.p() +
                " of these " +
                T.PROJECT.p() +
                " were the result of " +
                T.LEADER.p() +
                " and " +
                T.MANAGER.p() +
                " applying " +
                T.PROJECT_MANAGEMENT.s() +
                " " +
                BAG_1 +
                " to their work. The " +
                T.MANAGER.p() +
                " of these " +
                T.PROJECT.p() +
                " used a set of key " +
                T.SKILL.p() +
                " and " +
                T.APPLIED_KNOWLEDGE.s() +
                " to satisfy their " +
                T.CUSTOMER.p() +
                " and other people involved in and affected by the " +
                T.PROJECT.s() +
                ". By the mid-20th century, " +
                T.PROJECT_MANAGER.p() +
                " began the work of seeking recognition for " +
                T.PROJECT_MANAGEMENT.s() +
                " as a " +
                "profession" +
                ". One aspect of this work involved obtaining " +
                "agreement" +
                " on the content of the " +
                T.BODY_OF_KNOWLEDGE.s() +
                " (BOK) called " +
                T.PROJECT_MANAGEMENT.s() +
                ". This BOK became known as the " +
                T.PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE.s() +
                " (PMBOK). The " +
                T.PROJECT_MANAGEMENT_INSTITUTE.s() +
                " (PMI) produced a " +
                T.BASELINE.s() +
                " of " +
                T.CHART.p() +
                " and " +
                T.GLOSSARY.p() +
                " for the PMBOK. " +
                T.PROJECT_MANAGER.p() +
                " soon realized that no single book could contain the entire PMBOK. Therefore, PMI developed and published " +
                T.A_GUIDE_TO_THE_PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE.s() +
                ".\n" +
                "\n" +
                "PMI defines the " +
                T.PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE.s() +
                " (PMBOK) as a " +
                T.TERM.s() +
                " that describes the " +
                T.KNOWLEDGE.s() +
                " within the " +
                T.PROFESSION.s() +
                " of " +
                T.PROJECT_MANAGEMENT.s() +
                ". The " +
                T.PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE.s() +
                " includes proven " +
                T.TRADITIONAL_PRACTICE.p() +
                " that are widely applied as well as " +
                T.INNOVATIVE_PRACTICE.p() +
                " that are emerging in the profession.\n" +
                "\n" +
                "The " +
                T.BODY_OF_KNOWLEDGE.s() +
                " (BOK) includes both " +
                T.PUBLISHED_MATERIAL.p() +
                " and " +
                T.UNPUBLISHED_MATERIAL.p() +
                ". This " +
                T.BODY_OF_KNOWLEDGE.s() +
                " is constantly evolving. This PMBOK® Guide identifies a subset of the " +
                T.PROJECT_MANAGEMENT_BODY_OF_KNOWLEDGE.s() +
                " that is " +
                T.GENERALLY_RECOGNIZED.s() +
                " as " +
                T.GOOD_PRACTICE.s() +
                ".\n" +
                "\n" +
                "    " +
                T.GENERALLY_RECOGNIZED.s() +
                " means the " +
                T.KNOWLEDGE.s() +
                " and " +
                T.PRACTICE.p() +
                " described are applicable to " +
                "most projects" +
                " " +
                "most of the time" +
                ", and there is " +
                T.CONSENSUS.s() +
                " about their " +
                T.VALUE.s() +
                " and " +
                T.USEFULNESS.s() +
                ".\n" +
                "\n" +
                "    " +
                T.GOOD_PRACTICE.s() +
                " means there is " +
                T.GENERAL_AGREEMENT.s() +
                " that the " +
                "application" +
                " of the " +
                BAG_2 +
                " to " +
                T.PROJECT_MANAGEMENT_PROCESS.p() +
                " can enhance the " +
                "chance of success" +
                " over " +
                "many projects" +
                " in " +
                "delivering" +
                " the " +
                T.EXPECTED_BUSINESS_VALUE.p() +
                " and " +
                T.EXPECTED_BUSINESS_RESULT.p() +
                ".\n" +
                "\n" +
                "The " +
                T.PROJECT_MANAGER.s() +
                " works with the " +
                T.PROJECT_TEAM.s() +
                " and other " +
                T.STAKEHOLDERS.p() +
                " to determine and use the " +
                "appropriate" +
                " " +
                T.GENERALLY_RECOGNIZED.s() +
                " " +
                T.GOOD_PRACTICE.p() +
                " for each " +
                T.PROJECT.s() +
                ". Determining the appropriate combination of " +
                BAG_3 +
                " to manage a " +
                T.PROJECT.s() +
                " is referred to as “" +
                T.TAILORING.s() +
                "” the " +
                T.APPLICATION.s() +
                " of the " +
                T.KNOWLEDGE.s() +
                " described in this " +
                "guide" +
                ".\n" +
                "\n" +
                "This PMBOK® Guide is different from a " +
                T.METHODOLOGY.s() +
                ". A " +
                T.METHODOLOGY.s() +
                " is a " +
                T.SYSTEM.s() +
                " of " +
                BAG_4 +
                " used by those who work in a " +
                T.DISCIPLINE.s() +
                ". This PMBOK® Guide is a " +
                T.FOUNDATION.s() +
                " upon which " +
                T.ORGANIZATION.p() +
                " can build " +
                BAG_5 +
                " needed to practice " +
                T.PROJECT_MANAGEMENT.s() +
                ".";
    }
}
