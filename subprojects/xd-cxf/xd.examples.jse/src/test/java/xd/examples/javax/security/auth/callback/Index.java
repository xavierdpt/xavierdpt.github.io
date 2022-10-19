package xd.examples.javax.security.auth.callback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.ChoiceCallback;
import javax.security.auth.callback.ConfirmationCallback;
import javax.security.auth.callback.LanguageCallback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    Callback.class,
                    CallbackHandler.class,
                    ChoiceCallback.class,
                    ConfirmationCallback.class,
                    LanguageCallback.class,
                    NameCallback.class,
                    PasswordCallback.class,
                    TextInputCallback.class,
                    TextOutputCallback.class,
                    UnsupportedCallbackException.class
            ));
        }
    }
}
