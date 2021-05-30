package ru.skywacther_2019.rpcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandMe implements CommandExecutor {
    private final RPcommands plugin;

    public commandMe(RPcommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("rpcmd.me")) {
            sender.sendMessage(plugin.no_permission_msg);
            return true;
        }

        if (args.length == 0) {
            return false;
        } else {
            Bukkit.broadcastMessage(Message.format_me(plugin.me_msg, sender, args));
            return true;
        }
    }
}
