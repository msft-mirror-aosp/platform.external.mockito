/*
 * Copyright (c) 2016 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.hamcrest;

import static org.mockito.internal.util.reflection.GenericTypeExtractor.genericTypeOf;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Matcher;

/** Extracts generic type of matcher */
public final class MatcherGenericTypeExtractor {

    /**
     * Gets the generic type of given matcher. For example,
     * for matcher class that extends BaseMatcher[Integer] this method returns Integer
     */
    public static Class<?> genericTypeOfMatcher(Class<?> matcherClass) {
        // TODO SF check if we can reuse it for Mockito ArgumentMatcher
        return genericTypeOf(matcherClass, BaseMatcher.class, Matcher.class);
    }

    private MatcherGenericTypeExtractor() {}
}
