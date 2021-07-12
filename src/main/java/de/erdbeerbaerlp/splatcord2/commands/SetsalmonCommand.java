package de.erdbeerbaerlp.splatcord2.commands;

import de.erdbeerbaerlp.splatcord2.Main;
import de.erdbeerbaerlp.splatcord2.dc.Bot;
import de.erdbeerbaerlp.splatcord2.storage.json.translations.Locale;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class SetsalmonCommand extends BaseCommand{
    public SetsalmonCommand(Locale l) {
        super("setsalmon", l.botLocale.cmdSetsalmonDesc);
    }

    @Override
    public boolean requiresManageServer() {
        return true;
    }

    @Override
    public void execute(SlashCommandEvent ev) {
        final Locale lang = Main.translations.get(Main.iface.getServerLang(ev.getGuild().getIdLong()));
        if (!Bot.isAdmin(ev.getMember())) {
            ev.reply(lang.botLocale.noAdminPerms).queue();
            return;
        }
        Main.iface.setSalmonChannel(ev.getGuild().getIdLong(), ev.getChannel().getIdLong());
        ev.reply(lang.botLocale.salmonFeedMsg).queue();
    }
}