package trove.pages;

public class WikipediaArticle {
    private final String code;
    private final String title;
    private final String category;

    public WikipediaArticle(String title, String category) {
        this.code = makeCode(title);
        this.title = title;
        this.category = category;
    }


    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    private String makeCode(String title) {
        if("".equals(title)) {
            return "";
        }
        String code = title.replaceAll(" ", "_");
        char firstChar = code.charAt(0);
        if (Character.isLowerCase(firstChar)) {
            code = Character.toUpperCase(firstChar) + code.substring(1);
        }
        return code;

    }
}
