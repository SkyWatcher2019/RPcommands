package ru.skywacther_2019.rpcommands;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class RPcommands extends JavaPlugin {
    public File config_file = new File(getDataFolder() + File.separator + "config.yml");
    public FileConfiguration configuration = YamlConfiguration.loadConfiguration(config_file);
    public String me_msg, try_msg, no_permission_msg;

    @Override
    public void onEnable() {
        if (!config_file.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        me_msg = configuration.getString("me");
        try_msg = configuration.getString("try");
        no_permission_msg = configuration.getString("no-permission");

        getCommand("me").setExecutor(new commandMe(this));
        getCommand("try").setExecutor(new commandTry(this));
        getCommand("rpcmd").setExecutor(new commandRPcmd(this));

        getLogger().info("Активирован");
    }
}
