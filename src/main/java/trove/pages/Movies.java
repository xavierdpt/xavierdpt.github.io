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
        Comparator<Movie> cmp = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int yearCmp = Integer.compare(o1.getYear(), o2.getYear());
                if (yearCmp == 0) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
                return yearCmp;
            }
        };
        pw.println("<ul>");
        movies.stream().sorted(cmp).forEach(movie -> {
            String href = "https://www.imdb.com/title/" + movie.getImdbCode();
            String link = externalLink(href, movie.getYear() + " | " + movie.getTitle());
            pw.println("<li>" + link + "</li>");
        });
        pw.println("</ul>");
        finishRender(List.of());

    }
}
