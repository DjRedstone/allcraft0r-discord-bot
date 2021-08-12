package fr.djredstone.botdiscord.commands;

import java.awt.Color;

import fr.djredstone.botdiscord.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandHask extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase(Main.prefix + "ask")) {
			
			if (!event.getMember().hasPermission(Permission.NICKNAME_MANAGE)) {
                event.getChannel().sendMessage(Main.noPermMessage.toString()).queue();
                return;
            }
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle(":warning: Message de la hi�rarchie :warning:");
			embed.setDescription("Votre demande a �t� prise en compte. :thumbsup:");
			embed.setFooter("Nous vous informerons lorsque nous aurons plus d'informations. :receipt:");
			embed.setColor(Color.ORANGE);
			
			event.getChannel().sendMessage(embed.build()).queue();
			event.getChannel().sendTyping().queue();
			event.getMessage().delete().queue();
			
		}
	}

}