package ru.skywacther_2019.rpcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandTry implements CommandExecutor {
    private final RPcommands plugin;

    public commandTry(RPcommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("rpcmd.try")) {
            sender.sendMessage(plugin.no_permission_msg);
            return true;
        }

        if (args.length == 0) {
            return false;
        } else {
            Bukkit.broadcastMessage(Message.format_try(plugin.try_msg, sender, args));
            return true;
        }
    }
}
