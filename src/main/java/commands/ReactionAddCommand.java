package commands;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReactionAddCommand extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {


        if (event.getMessageIdLong() == 932074329057923132L){

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
                case "U+1f1eeU+1f1f9":
                    // Italian
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932369901828595732L)).queue();
                    break;
                case "U+1f1eeU+1f1f1":
                    // Hebrew
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(932369831334924328L)).queue();
                    break;
                case "U+1f1e7U+1f1f7":
                    // Brazil
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(933014155756183563L)).queue();
                    break;
                case "U+1f1f3U+1f1f1":
                    // Dutch
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(933352024521719878L)).queue();
                    break;
                case "U+1f1eeU+1f1f3":
                    // Hindi
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(933402690820640778L)).queue();
                    break;
                case "U+1f1f8U+1f1ea":
                    // Swedish
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(933835926193463396L)).queue();
                    break;





            }



        }
    }
}
