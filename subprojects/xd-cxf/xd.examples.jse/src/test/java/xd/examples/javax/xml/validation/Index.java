package xd.examples.javax.xml.validation;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.SchemaFactoryConfigurationError;
import javax.xml.validation.SchemaFactoryLoader;
import javax.xml.validation.TypeInfoProvider;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;


public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    Schema.class,
                    SchemaFactory.class,
                    SchemaFactoryConfigurationError.class,
                    SchemaFactoryLoader.class,
                    TypeInfoProvider.class,
                    Validator.class,
                    ValidatorHandler.class
            ));
        }
    }

}
