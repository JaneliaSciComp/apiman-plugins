package io.apiman.plugins.ignored_policy;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static final String BUNDLE_NAME = "io.apiman.plugins.ignored_policy.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    /**
     * Look up a message in the i18n resource message bundle by key, then format the
     * message with the given params and return the result.
     * @param key the key
     * @param params the parameters
     * @return formatted string
     */
    public static String format(String key, Object ... params) {
        ResourceBundle bundle = RESOURCE_BUNDLE;
        if (bundle.containsKey(key)) {
            String msg = bundle.getString(key);
            return MessageFormat.format(msg, params);
        } else {
            return MessageFormat.format("!!{0}!!", key); //$NON-NLS-1$
        }
    }
    
}
