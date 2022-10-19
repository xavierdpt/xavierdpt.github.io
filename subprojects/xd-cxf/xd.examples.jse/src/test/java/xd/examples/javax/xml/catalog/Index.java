package xd.examples.javax.xml.catalog;

import javax.xml.catalog.Catalog;
import javax.xml.catalog.CatalogException;
import javax.xml.catalog.CatalogFeatures;
import javax.xml.catalog.CatalogManager;
import javax.xml.catalog.CatalogResolver;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    Catalog.class,
                    CatalogException.class,
                    CatalogFeatures.class,
                    CatalogManager.class,
                    CatalogResolver.class
            ));
        }
    }

}
