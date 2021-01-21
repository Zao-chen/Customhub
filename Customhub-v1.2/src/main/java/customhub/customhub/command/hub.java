package customhub.customhub.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class hub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {//When someone use /hub
        Plugin plugin = customhub.customhub.Customhub.getProvidingPlugin(customhub.customhub.Customhub.class);
        if(commandSender instanceof Player)//if it is player
        {
            Player player=(Player) commandSender;
            List<String> rules = plugin.getConfig().getStringList("hubcommand");
            int time = plugin.getConfig().getInt("delay");//find command in config
            new BukkitRunnable()
            {
                int sec = time;
                @Override
                public void run()
                {
                    if(sec >= 0)
                    {
                        String timemessege = plugin.getConfig().getString("messege-time");
                        commandSender.sendMessage(ChatColor.GREEN+"[Customhub]"+timemessege+sec);
                    }
                    if(sec == 0)
                    {
                        for (String command_ : rules)
                        {
                            player.performCommand(command_);//use command
                        }
                        sec=-999999;
                        return;
                    }
                    sec--;
                }
            }.runTaskTimer(plugin, 20L, 20L);
        }
        else// if it isn't player
        {
            String isnotplayer = plugin.getConfig().getString("messege-isnotplayer");
            commandSender.sendMessage(ChatColor.RED+"[Customhub]"+isnotplayer);
        }
        return false;
    }
}
