package fr.djredstone.botdiscord.commands.music;

import javax.annotation.Nullable;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import fr.djredstone.botdiscord.commands.UtilsCommands;
import fr.djredstone.botdiscord.classes.music.GuildMusicManager;
import fr.djredstone.botdiscord.classes.music.PlayerManager;

public class CommandDisconnect {

    public CommandDisconnect(@Nullable MessageReceivedEvent event1, @Nullable SlashCommandInteractionEvent event2) {

        Guild guild;
        User user;
        if (event1 != null) {
            guild = event1.getGuild();
            user = event1.getAuthor();
        }
        else {
            assert event2 != null;
            guild = event2.getGuild();
            user = event2.getUser();
        }
        assert guild != null;

        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(guild);
        musicManager.scheduler.player.stopTrack();
        musicManager.scheduler.queue.clear();

        guild.getAudioManager().closeAudioConnection();

        EmbedBuilder embed = UtilsCommands.getEmbedBuilderMusic(user);
        embed.setDescription("Déconnecté du salon vocal " + Emoji.fromMarkdown("✅"));
        UtilsCommands.replyOrSend(embed, event1, event2);

    }

}
