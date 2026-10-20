package org.example.ebankchatbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EBankAiAgent {
    private ChatClient chatClient;

    public EBankAiAgent(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultSystem("""
                        repondre aux context fournis a propos des clients et des compte bancaire , tout autre message dis je ne sais pas
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).defaultTools(toolCallbackProvider)
                .build();
    }

    public String chat(String message, @RequestParam(defaultValue = "default") String conversationId) {
        return chatClient.prompt(message)
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, conversationId))

                .call()

                .content();
    }
}
