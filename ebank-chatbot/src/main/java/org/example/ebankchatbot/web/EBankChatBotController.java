package org.example.ebankchatbot.web;

import org.example.ebankchatbot.agents.EBankAiAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EBankChatBotController {
    private EBankAiAgent eBankAiAgent;

    public EBankChatBotController(EBankAiAgent eBankAiAgent) {
        this.eBankAiAgent = eBankAiAgent;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message, @RequestParam(defaultValue = "default") String conversationId) {
        return eBankAiAgent.chat(message, conversationId);
    }

}
