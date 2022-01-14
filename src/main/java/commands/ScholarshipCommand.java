package commands;


import Util.Util;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScholarshipCommand extends ListenerAdapter {

    private int botCounter = 0;
    private List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        if (event.getMember().getIdLong() == 772846793187917865L) {
            return;
        }

        if (event.getMessage().getTextChannel().getIdLong() == 867048274882854922L || event.getMessage().getTextChannel().getIdLong() == 867066671729999892L || event.getMessage().getTextChannel().getIdLong() == 867345705520594975L || event.getMessage().getTextChannel().getIdLong() == 875454299558260856L) {
            return;
        }

        if (event.getMember().getIdLong() == 204255221017214977L) {
            return;
        }

        if (!Util.hasRole(event.getMember(), "Marketing Manager")){
            return;
        }

        if (event.getMessage().getContentRaw().toLowerCase().startsWith("!id")){

            for (var member : event.getGuild().getMembers()) {
                if (member.getIdLong() == Long.parseLong(event.getMessage().getContentRaw().split(" ")[1])){
                    event.getChannel().sendMessage(member.getAsMention() + " " + member.getUser().getAsTag()).queue() ;
                }
            }
        }


        if (!Util.hasRole(event.getMember(), "Project Manager")){
            return;
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("?removerank")){

            for (int i = 0; i < event.getGuild().getRoles().size(); i++){
                if (event.getGuild().getRoles().get(i).getIdLong() == 925558862478717058L){
                    var members = event.getGuild().getMembersWithRoles(event.getGuild().getRoles().get(i));

                    for (var member: members) {
                        event.getGuild().removeRoleFromMember(member, event.getGuild().getRoles().get(i)).queue();
                    }
                }

            }

            return;
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("?validateuser")){

            for (int i = 0; i < event.getGuild().getMembers().size(); i++){
                if (!event.getGuild().getMembers().get(i).getUser().isBot() && event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE
                || event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB
                || event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.IDLE){
                    event.getGuild().addRoleToMember(event.getGuild().getMembers().get(i), event.getGuild().getRoleById(925571054368342027L)).queue();
                    System.out.println(event.getGuild().getMembers().get(i).getRoles().size() + " size of roles");
                    System.out.println(event.getGuild().getMembers().get(i) + " is online");
                }
            }
            return;
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("?kickuser")){

            for (int i = 0; i < event.getGuild().getMembers().size(); i++){
                if (!event.getGuild().getMembers().get(i).getUser().isBot() && event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.OFFLINE
                && event.getGuild().getMembers().get(i).getRoles().size() == 0){
                    for (int j = 0; j < numbers.size(); j++){
                        if (event.getGuild().getMembers().get(i).getEffectiveName().startsWith(numbers.get(j).toString())){
                            //event.getGuild().kick(event.getGuild().getMembers().get(i)).queue();
                            System.out.println(event.getGuild().getMembers().get(i) + " is offline");
                        }

                    }

                }
            }
            return;
        }

      /*
        if (event.getMessage().getChannel().getIdLong() == 925394283769520169L){
            if (event.getMessage().getContentRaw().contains("15")){
                // Add the user to give whitelisted role
            }
        }*/


       /* if (event.getMessage().getMember().getIdLong() == 720351927581278219L) {

            for (MessageEmbed messageEmbed : event.getMessage().getEmbeds()) {
                member = event.getGuild().getMemberByTag(messageEmbed.getTitle().replace("*", ""));

                if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 500) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866816159709659157L)).queue();
                } else if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 300) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866816004092067910L)).queue();
                } else if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 200) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866815977944514612L)).queue();
                } else if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 100) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866815880267956274L)).queue();
                } else if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 50) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866815462607159337L)).queue();
                } else if (Integer.parseInt(messageEmbed.getDescription().split(" ")[3].replace("*", "")) >= 5) {
                    event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(866814273921351720L)).queue();
                }
            }
        }

        if (event.getMessage().getContentRaw().toLowerCase().startsWith("?info")) {

            for (Member memb : event.getGuild().getMembers()) {
                for (Role role : memb.getRoles()) {
                    if (role.getIdLong() == 867039667470991391L) {
                        botCounter++;
                    }
                }
            }

            event.getChannel().sendMessage(Util.createMessage("Info about Axie ScholarShip Land", "- There are currently " + event.getGuild().getMembers().size() + " users in this server \n" + "- My commands: !ban, !mute, !unmute, ?purge, ?info, ?copychannel, ?createmessage \n - Axie Scholarship Land has " + event.getGuild().getRoles().size() + " roles \n - Axie Scholarship Land has " + botCounter + " bots \n - Axie Scholarship Land has " + event.getGuild().getChannels().size() + " channels \n ")).queue();
            botCounter = 0;
            return;
        }

        if (event.getMessage().getContentRaw().toLowerCase().startsWith("?commands")) {
            event.getChannel().sendMessage(Util.createMessage("List of commands", "**Admin Commands** \n - ?copychannel [channel ID] \n -?createmessage [Title][Description] \n \n **Diamond Commands** \n - !mute [user ID] [reason] \n - !unmute [user ID] \n - ?mutelist \n - ?purge [amount of messages to delete] \n \n **Public Commands** \n - ?info \n - ?commands")).queue();
        }
*/

        String message = event.getMessage().getContentRaw();
        if (message.toLowerCase().startsWith("!mute")) {
            String reason = "";

            for (int i = 2; i < message.split(" ").length; i++) {
                reason += " " + message.split(" ")[i];
            }

            Member memb = event.getGuild().getMemberById(event.getMessage().getContentRaw().split(" ")[1]);
            if (Util.hasRole(memb, "muted")) {
                event.getChannel().sendMessage("This user is already muted!").queue();
                return;
            } else {
                event.getChannel().sendMessage("**" + memb.getEffectiveName() + "** has been muted \n \n **Reason:**" + reason).queue();
            }
            event.getGuild().addRoleToMember(memb, event.getGuild().getRoleById(869161267309473812L)).queue();
            return;
        } else if (message.toLowerCase().startsWith("!unmute")) {

            Member memb = event.getGuild().getMemberById(event.getMessage().getContentRaw().split(" ")[1]);
            if (!Util.hasRole(memb, "muted")) {
                event.getChannel().sendMessage("This user is already unmuted").queue();
                return;
            } else {
                event.getChannel().sendMessage("**" + memb.getEffectiveName() + "** has been unmuted and can now speak!").queue();
            }
            event.getGuild().removeRoleFromMember(memb, event.getGuild().getRoleById(869161267309473812L)).queue();
            return;
        } else if (message.toLowerCase().startsWith("?mutelist")) {
            String names = "";
            int counter = 0;
            for (Member m : event.getGuild().getMembers()) {
                for (Role role : m.getRoles()) {
                    if (role.getIdLong() == 869161267309473812L) {
                        counter++;
                        names += " \n **" + m.getEffectiveName() + "**";
                    }
                }
            }
            if (counter == 0) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + " The mute list is clear").queue();
                return;
            }
            event.getChannel().sendMessage(Util.createMessage("List of muted people", names)).queue();
        }
        if (message.toLowerCase().startsWith("?purge")) {
            int amountOfDeletes = Integer.parseInt(event.getMessage().getContentRaw().split(" ")[1]);
            purgeMessages(event.getChannel(), amountOfDeletes);
            return;

        }

        if (message.startsWith("?settitle")){
            var msgSplit = message.split(" ");
            String title = "";
            for (int i = 1; i < msgSplit.length; i++){
                title += " " + msgSplit[i];
            }
            Util.setTitle(title);
            Util.deleteMessage(event.getChannel(), "?settitle");
            return;
        }

        if (message.startsWith("?setimageurl")){
            var msgSplit = message.split(" ");

            Util.setImageInfo(msgSplit[1]);
            Util.deleteMessage(event.getChannel(), "?setimageurl");
            return;
        }

        if (message.toLowerCase().startsWith("?sendembed")) {
            String description = "";
            for (int i = 1; i < message.split(" ").length; i++) {
                description += " " + message.split(" ")[i];
            }
            event.getChannel().sendMessage(Util.sendEmbed(description)).queue();
            Util.deleteMessage(event.getChannel(), "?sendembed");
            return;

        } else if (message.toLowerCase().startsWith("?copychannel")) {
            TextChannel channel = event.getGuild().getTextChannelById(message.split(" ")[1]);
            MessageHistory messageHistory = new MessageHistory(channel);
            List<Message> messages = messageHistory.retrievePast(1).complete();
            event.getChannel().sendMessage(Util.createMessage(null, messages.get(0).getContentRaw())).queue();
            Util.deleteMessage(event.getChannel(), "?copychannel");
        } else if (message.toLowerCase().startsWith("!ban")) {
            String reason = "";

            for (int i = 2; i < message.split(" ").length; i++) {
                reason += " " + message.split(" ")[i];
            }
            Member memb = event.getGuild().getMemberById(message.split(" ")[1]);
            assert memb != null;
            memb.ban(7, reason).queue();
            event.getChannel().sendMessage("**" + memb.getEffectiveName() + "** has been banned! \n \n**Reason:** " + reason).queue();
        }
    }


    private void purgeMessages(TextChannel channel, int numberofMessages) {
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;

        msgs = history.retrievePast(numberofMessages).complete();

        for (int i = 0; i < numberofMessages; i++) {
            System.out.println("Deleteing " + msgs.get(i));
        }
        channel.deleteMessages(msgs).complete();
    }
}




