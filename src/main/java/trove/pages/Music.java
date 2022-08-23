package trove.pages;

import trove.MusicLink;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Music extends Page {

    private List<MusicLink> links = new ArrayList<>();

    public Music() {
        super("music", "Music");
        addMusic("Brassens", "Quand on est con, on est con", "zMALuEYxK6U");


    }

    private void addMusic(String author, String title, String youtubeId) {
        links.add(new MusicLink(author, title, youtubeId));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {
        startRender(renderContext, List.of());

        Map<String, List<MusicLink>> byAuthor = new HashMap<>();
        for (MusicLink link : links) {
            String author = link.getAuthor();
            if (!byAuthor.containsKey(author)) {
                byAuthor.put(author, new ArrayList<>());
            }
            byAuthor.get(author).add(link);
        }

        pw.println("<ul>");
        byAuthor.keySet().stream().sorted().forEach(author -> {
            pw.println("<li>" + author);
            pw.println("<ul>");
            byAuthor.get(author).stream().sorted(Comparator.comparing(MusicLink::getTitle)).forEach(link->{
                String linkHtml = externalLink("https://www.youtube.com/watch?v=" +
                        link.getYoutubeId(), link.getTitle());
                pw.println("<li>" + linkHtml + "</li>");
            });
            pw.println("</ul>");
            pw.println("</li>");
        });
        pw.println("</ul>");
        finishRender(List.of());
    }
}
