package fr.djredstone.botdiscord.commands;

import javax.annotation.Nullable;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandEyes {
	public CommandEyes(@Nullable MessageReceivedEvent event1, @Nullable SlashCommandInteractionEvent event2) { UtilsCommands.replyOrSend(":eye::lips::eye:", event1, event2); }
}
