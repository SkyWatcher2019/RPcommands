package ru.skywacther_2019.rpcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class commandRPchat implements CommandExecutor {
    private final RPcommands plugin;

    public commandRPchat(RPcommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("rpcmd.reload")) {
            sender.sendMessage(plugin.no_permission_msg);
            return true;
        }
        if (args.length != 1 || !args[0].equals("reload")) {
            return false;
        } else {
            try {
                plugin.configuration.load(plugin.config_file);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
            plugin.me_msg = plugin.configuration.getString("me");
            plugin.try_msg = plugin.configuration.getString("try");
            plugin.no_permission_msg = plugin.configuration.getString("no-permission");
            sender.sendMessage("§aПлагин перезагружен!");
            return true;
        }
    }
}
