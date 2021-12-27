package pm;

import java.util.Arrays;
import java.util.List;

public class Library {
    public static List<Book> initBooks() {

        Section guide = new Section("A Guide to the Project Management Body of Knowledge (PMBOK® Guide)").sections(
                new Section("Introduction").sections(
                        new Section("Overview and Purpose of this Guide").intro(Stash.TEXT).sections(
                                new Section("The Standard for Project Management"),
                                new Section("Common Vocabulary"),
                                new Section("Code of Ethics and Professional Conduct")
                        ),
                        new Section("Foundational Elements")
                ),
                new Section("The Environment in Which Projects Operate"),
                new Section("The Role of the Project Manager"),
                new Section("Project Integration Management"),
                new Section("Project Scope Management"),
                new Section("Project Schedule Management"),
                new Section("Project Cost Management"),
                new Section("Project Quality Management"),
                new Section("Project Resource Management"),
                new Section("Project Communications Management"),
                new Section("Project Risk Management"),
                new Section("Project Procurement Management"),
                new Section("Project Stakeholder Management"),
                new Section("References")
        );

        Section standard = new Section("The Standard for Project Management").sections(
                new Section("Introduction"),
                new Section("Initiating Process Group"),
                new Section("Planning Process Group"),
                new Section("Executing Process Group"),
                new Section("Monitoring and Controlling Process Group"),
                new Section("Closing Process Group")
        );

        Section appendices = new Section("Appendices, Glossary, and Index").sections(
                new Section("Sixth Edition Changes"),
                new Section("Contributors and Reviewers of the PMBOK® Guide—Sixth Edition"),
                new Section("Agile, Iterative, Adaptive, and Hybrid Project Environments"),
                new Section("Summary of Key Concepts for Knowledge Areas"),
                new Section("Summary of Tailoring Considerations for Knowledge Areas"),
                new Section("Tools and Techniques"),
                new Section("Glossary")
        );

        Book pmbokGuide = new Book(
                BookCode.PMBOK_GUIDE,
                "A Guide to the Project Management Body of Knowledge (PMBOK® Guide), Sixth Edition",
                "file:///home/user/synchronized/PMBOOKS/html/A%20Guide%20to%20the%20Project%20Manageme%20-%20Project%20Management%20Institute/index.html"
        ).sections(guide, standard, appendices);

        List<Book> books = Arrays.asList(pmbokGuide);
        return books;
    }
}
