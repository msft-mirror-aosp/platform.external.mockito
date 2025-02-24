/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.configuration.plugins;

import static org.junit.Assert.*;
import static org.mockito.internal.configuration.plugins.DefaultMockitoPlugins.INLINE_ALIAS;
import static org.mockito.internal.configuration.plugins.DefaultMockitoPlugins.PROXY_ALIAS;

import org.junit.Test;
import org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker;
import org.mockito.internal.creation.bytebuddy.InlineByteBuddyMockMaker;
import org.mockito.internal.util.ConsoleMockitoLogger;
import org.mockito.plugins.InstantiatorProvider;
import org.mockito.plugins.InstantiatorProvider2;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockitoLogger;
import org.mockitoutil.TestBase;

public class DefaultMockitoPluginsTest extends TestBase {

    private DefaultMockitoPlugins plugins = new DefaultMockitoPlugins();

    @Test
    @SuppressWarnings("deprecation")
    public void provides_plugins() throws Exception {
        assertEquals(
                "org.mockito.internal.creation.bytebuddy.InlineByteBuddyMockMaker",
                plugins.getDefaultPluginClass(INLINE_ALIAS));
        assertEquals(InlineByteBuddyMockMaker.class, plugins.getInlineMockMaker().getClass());
        assertEquals(
                "org.mockito.internal.creation.proxy.ProxyMockMaker",
                plugins.getDefaultPluginClass(PROXY_ALIAS));
        assertEquals(
                ByteBuddyMockMaker.class, plugins.getDefaultPlugin(MockMaker.class).getClass());
        assertNotNull(plugins.getDefaultPlugin(InstantiatorProvider.class));
        assertNotNull(plugins.getDefaultPlugin(InstantiatorProvider2.class));
        assertEquals(
                ConsoleMockitoLogger.class,
                plugins.getDefaultPlugin(MockitoLogger.class).getClass());
    }
}
