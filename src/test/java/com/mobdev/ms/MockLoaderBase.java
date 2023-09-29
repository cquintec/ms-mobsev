package com.mobdev.ms;

import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

public class MockLoaderBase {
    public static String loadJsonStringResponse(final String responseName) {
        return new String(MockLoaderBase.loadJsonResponse(responseName), StandardCharsets.UTF_8);
    }

    public static byte[] loadJsonResponse(final String responseName) {
        return MockLoaderBase.loadResponse( responseName);
    }

    public static byte[] loadResponse(final String fileName) {
        try {
            final var in = MockLoaderBase.class.getClassLoader().getResourceAsStream(fileName);
            return IOUtils.toByteArray(in);
        } catch (final Exception e) {
            throw new IllegalArgumentException("Response doesn't exist", e);
        }
    }
}
