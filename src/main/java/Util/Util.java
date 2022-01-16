package Util;

import net.dv8tion.jda.api.entities.*;

import java.util.List;

public class Util {
    private static String embedTitle;
    private static String url;



    public static boolean hasRole(Member member, String role) {
        for (Role r : member.getRoles()) {
            if (r.getName().equals(role)){
                return true;
            }
        }
        return false;
    }


    public static void deleteMessage(TextChannel channel, String message){
        List<Message> mes = new MessageHistory(channel).retrievePast(10).complete();
        for (Message m : mes){
            if (m.getContentRaw().contains(message)){
                m.delete().queue();
            }
        }
    }


    public static MessageEmbed createMessage(String title, String description){
        return new MessageEmbed(null, title, description, null, null, 0xF40C0C, null,null,null,null,null,null,null);
    }

    public static MessageEmbed sendEmbed(String description){
        var embed = new MessageEmbed(null, embedTitle, description, null, null, 0xF40C0C, null,null,null,null,null, setImageInfo(url),null);
        embedTitle = "";
        url = "";
        return embed;
    }

    public static void setTitle(String title){
        embedTitle = title;
    }

    public static MessageEmbed.ImageInfo setImageInfo(String imageUrl) {
        url = imageUrl;
        return new MessageEmbed.ImageInfo(url, "", 100, 100);
    }

}