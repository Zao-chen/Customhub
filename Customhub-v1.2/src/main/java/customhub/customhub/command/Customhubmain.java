package customhub.customhub.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Customhubmain implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Plugin plugin = customhub.customhub.Customhub.getProvidingPlugin(customhub.customhub.Customhub.class);
        if (strings.length == 1) {
            String Message = strings[0];
            if (Message.equals("reload")) {//When someone use reload
                if (commandSender.hasPermission("customhub.commands.reload")) {//see the permission
                    plugin.reloadConfig();
                    String messegereload = plugin.getConfig().getString("messege-reload");
                    commandSender.sendMessage(ChatColor.GREEN + "[Customhub]!"+messegereload);
                } else {
                    String messegepermissions = plugin.getConfig().getString("messege-nopermissions");
                    commandSender.sendMessage(ChatColor.RED + "[Customhub]"+messegepermissions);
                }
            } else if (Message.equals("info"))
            {
                if (commandSender.hasPermission("customhub.commands.info"))
                {//see the permission
                    {
                        String messegeload = plugin.getConfig().getString("messege-load");
                        commandSender.sendMessage(ChatColor.GREEN + "[Customhub]"+messegeload);
                        commandSender.sendMessage(ChatColor.YELLOW + "————[Customhub]————");
                        String messegeloadhub = plugin.getConfig().getString("messege-load-hub");
                        commandSender.sendMessage(ChatColor.YELLOW + messegeloadhub);
                        List<String> rules = plugin.getConfig().getStringList("hubcommand");
                        for (String command_ : rules) {
                            commandSender.sendMessage(command_);//use command
                        }
                        String messegelobby = plugin.getConfig().getString("messege-load-lobby");
                        commandSender.sendMessage(ChatColor.YELLOW + messegelobby);
                        if (plugin.getConfig().getBoolean("lobby")) {
                            rules = plugin.getConfig().getStringList("lobbycommand");
                            for (String command_ : rules) {
                                commandSender.sendMessage(command_);//use command
                            }
                        } else {
                            String messegenolobby = plugin.getConfig().getString("messege-load-nolobby");
                            commandSender.sendMessage(ChatColor.YELLOW + messegenolobby);//use command
                        }
                    }
                }
                else
                {
                    String messegepermissions = plugin.getConfig().getString("messege-nopermissions");
                    commandSender.sendMessage(ChatColor.RED + "[Customhub]"+messegepermissions);
                }
            }
            else {
                String syntaxerror = plugin.getConfig().getString("messege-syntaxerror");
                commandSender.sendMessage(ChatColor.RED + "[Customhub]"+syntaxerror);
            }
            return false;
        }else {
            if (strings.length == 0) {
                commandSender.sendMessage(ChatColor.GREEN + "[Customhub]1.2");
            } else {
                String syntaxerror = plugin.getConfig().getString("messege-syntaxerror");
                commandSender.sendMessage(ChatColor.RED + "[Customhub]"+syntaxerror);
            }
        }
        return false;
    }
}
