package trove;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trove {

    private static final String BASE_PATH = "docs/";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        String packageName = "trove.pages";
        InputStream r = Trove.class.getClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(r));
        List<String> pageClassNames = bufferedReader.lines()
                .filter(x -> x.endsWith(".class"))
                .map(x -> packageName + "." + x)
                .map(x -> x.substring(0, x.length() - ".class".length()))
                .toList();
        List<Page> pages = new ArrayList<>();
        for (String pageClassName : pageClassNames) {
            Class<?> clazz = Class.forName(pageClassName);
            if (!Page.class.isAssignableFrom(clazz)) {
                continue;
            }
            Page page = (Page) clazz.getDeclaredConstructor().newInstance();
            pages.add(page);
        }
        List<String> locations = pages.stream().map(Page::getLocation).sorted().toList();
        Map<String, String> pathsByLocation = new HashMap<>();
        for (String location : locations) {
            String path;
            if ("".equals(location)) {
                path = "index.html";
            } else if (isPrefix(location, locations)) {
                path = location + "/index.html";
            } else {
                path = location + ".html";
            }
            pathsByLocation.put(location, path);
        }
        RenderContext renderContext = new RenderContext(BASE_PATH,pathsByLocation, pages);
        for (Page page : pages) {
            String location = page.getLocation();
            String path = BASE_PATH + pathsByLocation.get(location);
            mkdirs(path);
            page.renderTop(renderContext);
        }
    }

    private static void mkdirs(String path) {
        if (path.endsWith(".html")) {
            int lastSlash = path.lastIndexOf("/");
            if (lastSlash == -1) {
                return;
            }
            path = path.substring(0, lastSlash);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        }

    }

    private static boolean isPrefix(String location, List<String> locations) {
        return locations.stream().anyMatch(l -> !location.equals(l) &&
                l.startsWith(location) &&
                l.substring(location.length()).indexOf("/") == 0);
    }


}
