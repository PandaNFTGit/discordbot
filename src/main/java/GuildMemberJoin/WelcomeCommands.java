package GuildMemberJoin;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class WelcomeCommands extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        TextChannel channel = event.getGuild().getTextChannelById(926691512836825159L);
        MessageEmbed embed = Util.Util.createMessage("Welcome **" + event.getMember().getEffectiveName() + "**"," Welcome to PandaUniverse! " + event.getMember().getAsMention() + " \n \n- __**Earn passive income**__ by holding our nft \n- Earn passive income in our Earn-To-Play NFT game! (currently under development) \n- We are helping charity of your choice \n\nWe are currently running an invite contest where the 10 most inviters will receive a NFT from our NFT collection. You can read our announcement in: " + event.getGuild().getTextChannelById(926493847314370611L).getAsMention() + " to see our latest announcement. Also read" + event.getGuild().getTextChannelById(867363327750701087L).getAsMention() + " to see the different ranks. You can track your invites in " + event.getGuild().getTextChannelById(925617795566272513L).getAsMention() + " by typing -invite. \n \n If you have any other questions please feel free to ask them in the different chats! or contact support at: " + event.getGuild().getTextChannelById(925395961998630962L).getAsMention() + ". Remember to verify yourself in order to see the different channels");
        channel.sendMessage(event.getMember().getAsMention()).queue();
        channel.sendMessage(embed).queue();
    }
}