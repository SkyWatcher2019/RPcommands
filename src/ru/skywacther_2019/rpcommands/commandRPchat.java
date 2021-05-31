package ru.skywacther_2019.rpcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandRPchat implements CommandExecutor {
    private final RPcommands plugin;

    public commandRPchat(RPcommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("rpcmd.reload")) {
            sender.sendMessage(plugin.configuration.getString("no-permission"));
            return true;
        }
        if (args.length != 1 || !args[0].equals("reload")) {
            return false;
        } else {
            plugin.reloadConfig();
            sender.sendMessage("§aПлагин перезагружен!");
            return true;
        }
    }
}
