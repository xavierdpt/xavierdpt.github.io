package trove;

import java.util.*;

public class RenderContext {
    private String basePath;
    private Map<String, String> pathsByLocations;
    Map<String, Page> pagesByLocations = new HashMap<>();

    public RenderContext(String basePath, Map<String, String> pathsByLocations, List<Page> pages) {
        this.basePath = basePath;
        this.pathsByLocations = pathsByLocations;
        for (Page page : pages) {
            pagesByLocations.put(page.getLocation(), page);
        }
    }

    public String getPath(Page page) {
        String location = page.getLocation();
        if (location != null) {
            return basePath + pathsByLocations.get(location);
        }
        return null;
    }

    public Page getPage(String location) {
        return pagesByLocations.get(location);
    }

    public String getPath(String location) {
        return basePath + pathsByLocations.get(location);
    }


    public Page getPageByClass(Class<? extends Page> pageClass) {
        for (Page page : pagesByLocations.values()) {
            if (page.getClass().equals(pageClass)) {
                return page;
            }
        }
        return null;
    }

    public Collection<Page> getAllPages() {
        return pagesByLocations.values();
    }

    public List<Page> getChildPages(String location) {
        List<Page> pages = new ArrayList<>();
        for (Map.Entry<String, Page> entry : pagesByLocations.entrySet()) {
            String key = entry.getKey();
            if (key.equals(location) || !key.startsWith(location)) {
                continue;
            }
            int nslash1 = count('/', location);
            int nslash2 = count('/', key);
            if (nslash2 == nslash1 + 1) {
                pages.add(entry.getValue());
            }
        }
        return pages;
    }

    private int count(char c, String location) {
        int count = 0;
        for (char ch : location.toCharArray()) {
            if (c == ch) {
                ++count;
            }
        }
        return count;
    }
}
