package xd.examples.javax.xml.transform;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.URIResolver;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    ErrorListener.class,
                    OutputKeys.class,
                    Result.class,
                    Source.class,
                    SourceLocator.class,
                    Templates.class,
                    Transformer.class,
                    TransformerConfigurationException.class,
                    TransformerException.class,
                    TransformerFactory.class,
                    TransformerFactoryConfigurationError.class,
                    URIResolver.class
            ));
        }
    }

}
