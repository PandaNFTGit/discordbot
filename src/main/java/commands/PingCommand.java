package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String message = event.getMessage().getContentRaw();

        // Hvis den ikke starter med !ping, så stop
        if (!message.toLowerCase().startsWith("!ping")) {
            return;
        }

        // Vi ved nu at beskeden starter med !ping
        event.getMessage().getChannel().sendMessage("Pong!").queue();
    }
}
