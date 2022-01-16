package commands;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReactionAddCommand extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {


        if (event.getMessageIdLong() == 932051456083787856L){

            System.out.println(event.getReactionEmote().getAsCodepoints());

            switch (event.getReactionEmote().getAsCodepoints()){
                case "U+1f1eaU+1f1f8":
                    // spain
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932059733337194578L)).queue();
                    break;
                case "U+1f1ebU+1f1f7":
                    // french
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932058604935196732L)).queue();
                    break;
                case "U+1f1f7U+1f1fa":
                    // russian
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932058678910136320L)).queue();
                    break;
                case "U+1f1e8U+1f1f3":
                    // china
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932058646341386321L)).queue();
                    break;
                case "U+1f1e9U+1f1f0":
                    // Danish
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932059607256412160L)).queue();
                    break;
                case "U+1f1f9U+1f1f7":
                    // turkish
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932059033693741086L)).queue();
                    break;
                case "U+1f1f5U+1f1ed":
                    // PH
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932058942601850950L)).queue();
                    break;
            }



        }
    }
}
