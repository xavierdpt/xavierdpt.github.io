package trove;

public class RFC {

    private final int num;
    private final String title;
    private final int month;
    private final int year;

    public RFC(int num, String title, int month, int year) {
        this.num = num;
        this.title = title;
        this.month = month;
        this.year = year;
    }

    public int getNum() {
        return num;
    }

    public String getTitle() {
        return title;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String dateString() {
        if (month >= 10) {
            return month + "/" + year;
        } else {
            return "0" + month + "/" + year;
        }
    }

    public String makeLongLinkHtml(Page page) {
        String linkTitle = "RFC" + num + " " + title;
        String href = "https://datatracker.ietf.org/doc/html/rfc" + num;
        return PageUtils.externalLink(href, linkTitle,page);
    }

    public String makeShortLinkHtml(Page page) {
        String linkTitle = "RFC" + num;
        String href = "https://datatracker.ietf.org/doc/html/rfc" + num;
        return PageUtils.externalLink(href, linkTitle,page);
    }
}
