package ru.skywacther_2019.rpcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

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
            String result;
            Random random = new Random();
            if (random.nextBoolean()) {
                result = "§a§oуспешно";
            } else {
                result = "§c§oне успешно";
            }
            String action = String.join(" ", args);
            String message = plugin.try_msg
                    .replace("%", "%%")
                    .replace("{player}", sender.getName())
                    .replace("{action}", action)
                    .replace("{result}", result);
            Bukkit.broadcastMessage(message);
            return  true;
        }
    }
}
