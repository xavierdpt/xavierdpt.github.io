package trove.pages;

import trove.*;

import java.io.IOException;
import java.util.*;

public class YouTube extends Page {

    Map<YoutubeChannel, List<YoutubeLink>> links = new HashMap<>();

    public YouTube() {
        super("youtube", "YouTube");
        {
            YoutubeChannel channel = new YoutubeChannel("Mathémusique", " Mathémusique", YoutubeChannelType.C);
            addVideo(channel, "C'est quoi un RYTHME EUCLIDIEN ?", "8G8qko7NZdE");
        }
        {
            YoutubeChannel channel = new YoutubeChannel("Black Hat", "BlackHatOfficialYT", YoutubeChannelType.C);
            addVideo(channel, "HTTP/2: The Sequel is Always Worse", "sI6YS9a7Qyg");
            addVideo(channel, "ChaosDB: How We Hacked Databases of Thousands of Azure Customers (rev)", "QiJAxo30w6U");
            addVideo(channel, "Security Industry Call-to-Action: We Need a Cloud Vulnerability Database", "JEA_Zgi8Tjg");
        }
        {
            YoutubeChannel channel = new YoutubeChannel("BBC", "BBC", YoutubeChannelType.USER);
            addVideo(channel, "BBC Proms 2011: Tim Minchin - F Sharp (Comedy Prom)", "5Ju8Wxmrk3s");
        }
        {
            YoutubeChannel channel = new YoutubeChannel("Tim Minchin", "UCz5wnzqxdlrhdpaVoRwKe2A", YoutubeChannelType.CHANNEL);
            addVideo(channel, "Lullaby by Tim Minchin", "ESFANzZTdYM");
        }
        {
            YoutubeChannel channel = new YoutubeChannel("zefrank1", "zefrank", YoutubeChannelType.C);
            addVideo(channel, "True Facts: The Self-Sacrificing Amoeba", "vlANF-v9lb0");
        }
    }

    private void addVideo(YoutubeChannel channel, String title, String videoId) {
        if (!links.containsKey(channel)) {
            links.put(channel, new ArrayList<>());
        }
        links.get(channel).add(new YoutubeLink(videoId, title));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {
        startRender(renderContext, List.of());
        pw.println("<ul>");
        links.keySet().stream().sorted(Comparator.comparing(YoutubeChannel::getTitle)).forEach(channel -> {
            String channelLink = externalLink("https://www.youtube.com/" + channel.getLinkSuffix(), channel.getTitle());
            pw.println("<li>" + channelLink);
            pw.println("<ul>");
            links.get(channel).stream().sorted(Comparator.comparing(YoutubeLink::getTitle)).forEach(link -> {
                String videoLink = externalLink("https://www.youtube.com/watch?v=" + link.getVideoId(), link.getTitle());
                pw.println("<li>" + videoLink + "</li>");
            });

            pw.println("</ul>");
            pw.println("</li>");
        });
        finishRender(List.of());
    }

}
