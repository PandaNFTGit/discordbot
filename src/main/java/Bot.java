import GuildMemberJoin.WelcomeCommands;
import commands.ScholarshipCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bot {

    public static void main(String[] args) throws LoginException, InterruptedException, IOException {


        Path path = Path.of("C:\\Users\\Administrator\\Desktop\\bottoken.txt");
        String token = String.valueOf(Files.readAllLines(path).get(0));


        JDABuilder builder = JDABuilder.createDefault(token)
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
