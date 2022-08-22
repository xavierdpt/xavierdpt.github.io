package trove;

public class Movie {
    private final String title;
    private final int year;
    private final String imdbCode;

    public Movie(String title, int year, String imdbCode) {
        this.title = title;
        this.year = year;
        this.imdbCode = imdbCode;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbCode() {
        return imdbCode;
    }
}
