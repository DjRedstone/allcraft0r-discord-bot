package fr.djredstone.allcraft0rDiscordBot.commands.economy;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import fr.djredstone.allcraft0rDiscordBot.Main;
import fr.djredstone.allcraft0rDiscordBot.commands.UtilsCommands;
import fr.djredstone.allcraft0rDiscordBot.classes.money;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandDaily {
	
	private static final Set<String> hadGet = new HashSet<>();
	private static final int value = 250;
	
	public CommandDaily(User user, @Nullable MessageReceivedEvent event1, @Nullable SlashCommandInteractionEvent event2) {
			
		if(!hadGet.contains(user.getId())) {
			
			try {
				money.add(user, value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			UtilsCommands.replyOrSend(String.format("Tu as reçu **%1$s** %2$s %3$s", value, Main.getRedstoneEmoji(), user.getAsMention()), event1, event2);
			
			hadGet.add(user.getId());
			
		} else {
			
			UtilsCommands.replyOrSend(String.format("Vous avez déjà récupéré votre redstone quotidienne, %1$s", user.getAsMention()), event1, event2);
			
		}
		
	}
	
}