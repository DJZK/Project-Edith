package Functions;

import Commands.channel;
import Event.Watcher;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import Commands.prefix;

public class Commander extends ListenerAdapter {
    // Making the slash command
    private static CommandClientBuilder slash = new CommandClientBuilder();
    private static CommandClient commands = null;
    public static void commander(JDA jda) {
        try {
            if (commands == null) {
                System.out.println("I am alive :D");
            } else {
                jda.removeEventListener(commands);
                commands.getCommands().removeAll(commands.getCommands());
            }
            slash = new CommandClientBuilder();
            // commands = slash.build();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Error happened");
            e.printStackTrace();
        }
        // Me, myself and I
        slash.setOwnerId("623189902510522373");
        // Prefix of the bot
        slash.setPrefix(DatabaseParameters.getBotPrefix());
        // Help thingy
        slash.setHelpWord("help");

        // Commands here!!
        slash.addCommand(new prefix(jda));
        slash.addCommand(new channel());

        commands = slash.build();

        // Events
        jda.addEventListener(commands);
        jda.addEventListener(new Watcher());

    }
}
