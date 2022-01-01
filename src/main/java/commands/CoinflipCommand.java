package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CoinflipCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String message = event.getMessage().getContentRaw();

        if(!message.toLowerCase().startsWith("!coinflip")){
            return;
        }



        int k = new Random().nextInt(2) + 1;

        event.getMessage().getChannel().sendMessage(k > 1 ? "krone" : "plat").queue();
    }
}
