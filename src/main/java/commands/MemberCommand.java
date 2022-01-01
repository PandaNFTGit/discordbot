package commands;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MemberCommand extends ListenerAdapter {

    private int counter;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String message = event.getMessage().getContentRaw();


        if (!message.toLowerCase().startsWith("!member")){
            return;
        }
        // 1. få serveren
        Guild server = event.getGuild();

        // 2. løb igennem alle members og count hvor mange der er online

        int counter = 0;

        for(Member memb : server.getMembers()){
            if(memb.getOnlineStatus() == OnlineStatus.OFFLINE){
                counter++;
            }
        }

        // 3. send antallet tilbage til brugeren
        event.getMessage().getChannel().sendMessage("" + counter).queue();
    }
    public int getMembers(){
        return counter;
    }
    }

