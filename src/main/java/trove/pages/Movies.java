package trove.pages;

import trove.Movie;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Movies extends Page {

    List<Movie> movies = new ArrayList<>();

    public Movies() {
        super("movies", "Movies");
        movies.add(new Movie("Sully", 2016, "tt3263904"));
        movies.add(new Movie("Oklahoma!", 1955, "tt0048445"));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {
        startRender(renderContext, List.of());
        pw.println("<ul>");
        movies.stream().sorted((left, right) -> {
            int yearCmp = Integer.compare(left.getYear(), right.getYear());
            if (yearCmp == 0) {
                return left.getTitle().compareTo(right.getTitle());
            }
            return yearCmp;
        }).forEach(movie -> {
            String href = "https://www.imdb.com/title/" + movie.getImdbCode();
            String link = externalLink(href, movie.getYear() + " | " + movie.getTitle());
            pw.println("<li>" + link + "</li>");
        });
        pw.println("</ul>");
        finishRender(List.of());

    }
}
