package org.example.ebankchatbot.discord;

import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.example.ebankchatbot.agents.EBankAiAgent;

@DiscordController
public class DiscordBot {
    private EBankAiAgent ebankAiAgent;

    public DiscordBot(EBankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = ebankAiAgent.chat(query, "");
        event.getChannel().sendMessage(response).queue();
    }
}
