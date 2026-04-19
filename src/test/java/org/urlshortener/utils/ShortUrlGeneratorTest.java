package org.urlshortener.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ShortUrlGeneratorTest {

    @Test
    void generateUrl() {
        log.info(ShortUrlGenerator.generateUrl("https://test.com"));
    }
}