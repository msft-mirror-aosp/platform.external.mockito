/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.invocation.Location;

import java.io.Serializable;

@SuppressWarnings("unchecked")
public class LocalizedMatcher extends BaseMatcher
        implements Matcher, ContainsExtraTypeInformation, CapturesArguments, MatcherDecorator, Serializable {

    private static final long serialVersionUID = 6748641229659825725L;
    private final Matcher actualMatcher;
    private final Location location;

    public LocalizedMatcher(Matcher actualMatcher) {
        this.actualMatcher = actualMatcher;
        this.location = new LocationImpl();
    }

    public boolean matches(Object item) {
        return actualMatcher.matches(item);
    }

    public void describeTo(Description description) {
        actualMatcher.describeTo(description);
    }

    public Location getLocation() {
        return location;
    }
    
    @Override
    public String toString() {
        return "Localized: " + this.actualMatcher;
    }

    public SelfDescribing withExtraTypeInfo() {
        if (actualMatcher instanceof ContainsExtraTypeInformation) {
            return ((ContainsExtraTypeInformation) actualMatcher).withExtraTypeInfo();
        } else {
            return this;
        }
    }

    public boolean typeMatches(Object object) {
        return actualMatcher instanceof ContainsExtraTypeInformation
                && ((ContainsExtraTypeInformation) actualMatcher).typeMatches(object);
    }

    public void captureFrom(Object argument) {
        if (actualMatcher instanceof CapturesArguments) {
            ((CapturesArguments) actualMatcher).captureFrom(argument);
        }
    }

    //TODO: refactor other 'delegated interfaces' to use the MatcherDecorator feature
    public Matcher getActualMatcher() {
        return actualMatcher;
    }
}