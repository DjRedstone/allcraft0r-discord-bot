package fr.djredstone.botdiscord.commands;

import java.awt.Color;
import java.util.Objects;

import javax.annotation.Nullable;

import fr.djredstone.botdiscord.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandNon {
	
	public CommandNon(@Nullable String option, @Nullable MessageReceivedEvent event1, @Nullable SlashCommandInteractionEvent event2) {
			
		Member member;
		if(event1 != null) member = event1.getMember();
		else {
			assert event2 != null;
			member = event2.getMember();
		}

		assert member != null;
		if (!member.hasPermission(Permission.NICKNAME_MANAGE)) {
            UtilsCommands.replyOrSend(Main.noPermMessage, event1, event2);
            return;
        }
		
		String message = "";
		if(event2 != null) if(event2.getOption("non_message") != null) message = Objects.requireNonNull(event2.getOption("non_message")).getAsString();
		else if(option != null) message = option;
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle(":warning: Message de la hiérarchie :warning:");
		embed.setDescription("Votre demande a été refusée.");
		embed.setFooter(message);
		embed.setColor(Color.RED);
		embed.setThumbnail("https://images.emojiterra.com/google/android-10/512px/274c.png");
		
		UtilsCommands.replyOrSend(embed, event1, event2);
		
	}

}