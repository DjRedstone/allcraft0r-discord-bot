package fr.djredstone.botdiscord.commands.hPrivate;

import javax.annotation.Nullable;
import java.awt.*;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import fr.djredstone.botdiscord.commands.UtilsCommands;

public class CommandOui {
	
	public CommandOui(@Nullable String option, MessageReceivedEvent event) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle(":warning: Message de la hiérarchie :warning:");
		embed.setDescription("Votre demande a été acceptée.");
		embed.setFooter(option);
		embed.setColor(Color.GREEN);
		embed.setThumbnail("https://images.emojiterra.com/twitter/v13.0/512px/2705.png");
		
		UtilsCommands.replyOrSend(embed, event, null);
			
	}

}