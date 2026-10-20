package org.example.ebankchatbot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EbankChatbotApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        String apiKey = environment.getProperty("spring.ai.openai.api-key");
        assertNotNull(apiKey, "spring.ai.openai.api-key should not be null");
        assertFalse(apiKey.isEmpty(), "spring.ai.openai.api-key should not be empty");
        assertFalse(apiKey.startsWith("${"), "spring.ai.openai.api-key should be resolved, not raw placeholder");
    }

}
