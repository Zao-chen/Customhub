package customhub.customhub;

import customhub.customhub.command.Customhubmain;
import customhub.customhub.command.hub;
import customhub.customhub.command.lobby;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customhub extends JavaPlugin {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            getConfig().options().copyDefaults();
            saveDefaultConfig();
            getCommand("hub").setExecutor(new hub());
            getCommand("Customhub").setExecutor(new Customhubmain());
            getCommand("lobby").setExecutor(new lobby());
            // Plugin startup logic
            System.out.println("[Customhub]Successfully loaded");

        } else
            {
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Customhub]Successfully unloaded");
    }
}
