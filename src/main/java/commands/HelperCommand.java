package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelperCommand extends ListenerAdapter {

    MemberCommand command = new MemberCommand();
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String eventMessage = event.getMessage().getContentRaw();
        MessageChannel channel = event.getMessage().getChannel();

            if (eventMessage.equalsIgnoreCase("!help")) {
                channel.sendMessage("1. clear last 50 messages").queue();
                channel.sendMessage("2. online status").queue();
                channel.sendMessage("3. quit").queue();
            }

            switch (eventMessage) {
                case "1" -> {
                    purgeMessages(event.getMessage().getTextChannel(), 10);
                    event.getChannel().sendMessage("purged 5 messages").queue();
                }
                case "2" -> channel.sendMessage("" + command.getMembers()).queue();
                case "3" -> channel.sendMessage("you've quit. Have a nice day!").queue();
            }
    }

    private void purgeMessages(TextChannel channel, int numberofMessages) {

        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;

        msgs = history.retrievePast(numberofMessages).complete();
        channel.deleteMessages(msgs).queue();

    }
}
