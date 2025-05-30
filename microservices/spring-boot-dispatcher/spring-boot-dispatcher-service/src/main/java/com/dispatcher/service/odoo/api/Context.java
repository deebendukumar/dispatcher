package com.dispatcher.service.odoo.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides the session context object that is used in calls to the server.
 */
public class Context extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    final static String ActiveTestTag = "active_test";
    final static String LangTag = "lang";
    final static String TimezoneTag = "tz";


    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        // TODO Auto-generated method stub
        super.putAll(m);
    }

    /**
     * Gets the active_test context property.
     *
     * @return The active_test value or null if the property doesn't exist.
     */
    public Boolean getActiveTest() {
        if (!this.containsKey(ActiveTestTag))
            return null;

        return Boolean.parseBoolean(this.get(ActiveTestTag).toString());
    }

    /**
     * Sets the active_test context value.  If true, only active items are returned by default when calling the ReadObject item.
     *
     * @param active_test
     */
    public void setActiveTest(boolean active_test) {
        this.remove(ActiveTestTag);
        this.put(ActiveTestTag, active_test);
    }

    /**
     * Gets the 'lang' context value.
     *
     * @return Language or null if the property doesn't exist.
     */
    public String getLanguage() {
        if (!this.containsKey(LangTag))
            return null;

        return this.get(LangTag).toString();
    }

    /**
     * Sets the 'lang' context value.
     *
     * @param lang Examples "en_US", "nl_NL"
     */
    public void setLanguage(String lang) {
        this.remove(LangTag);
        this.put(LangTag, lang);
    }

    /**
     * Gets the 'tz' context value.
     *
     * @return Time zone string or null if the property doesn't exist
     */
    public String getTimeZone() {
        if (!this.containsKey(TimezoneTag))
            return null;

        if (this.get(TimezoneTag) instanceof Boolean && Boolean.getBoolean(this.get(TimezoneTag).toString()) == false)
            return null;

        return this.get(TimezoneTag).toString();
    }

    /**
     * Sets the 'tz' context flag.
     *
     * @param tz Examples "Australia/Sydney", "Europe/Brussels"
     */
    public void setTimeZone(String tz) {
        this.remove(TimezoneTag);
        this.put(TimezoneTag, tz);
    }
}
