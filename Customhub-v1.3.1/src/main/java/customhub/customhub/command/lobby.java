package customhub.customhub.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
public class lobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {//When someone use /hub
        Plugin plugin = customhub.customhub.Customhub.getProvidingPlugin(customhub.customhub.Customhub.class);
        Player player = (Player) commandSender;
        if(plugin.getConfig().getBoolean("lobby"))
        {
            if (commandSender instanceof Player)//if it is player
            {
                player.performCommand("hub");//use command
            }
            else// if it isn't player
            {
                String isnotplayer = plugin.getConfig().getString("messege-isnotplayer");
                commandSender.sendMessage(ChatColor.RED+"[Customhub]"+isnotplayer);
            }
            return false;
        }
        else
        {
            commandSender.sendMessage(ChatColor.RED + "[Customhub]NOT OPEN");
        }
        return false;
    }
}
