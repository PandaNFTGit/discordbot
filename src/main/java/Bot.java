import GuildMemberJoin.WelcomeCommands;
import commands.ScholarshipCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException, InterruptedException {

        JDABuilder builder = JDABuilder.createDefault("NzcyODQ2NzkzMTg3OTE3ODY1.X6Anqg.A5YK2Wez2iblR1eGFotsL-qXPJ0")
            .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_PRESENCES)
            .enableCache(CacheFlag.MEMBER_OVERRIDES)
            .setChunkingFilter(ChunkingFilter.ALL)
            .setMemberCachePolicy(MemberCachePolicy.ALL);


        JDA jda = builder.build();

        jda.addEventListener(
              new ScholarshipCommand()
               , new WelcomeCommands()
        );

        jda.awaitReady();
    }
}
