package ru.skywacther_2019.rpcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class Message {
    public static String format_me(String message, CommandSender sender, String[] args) {
        String action = String.join(" ", args);
        message = ChatColor.translateAlternateColorCodes('&', message);
        return message
                .replace("%", "%%")
                .replace("{player}", sender.getName())
                .replace("{action}", action);
    }

    public static String format_try(String message, CommandSender sender, String[] args) {
        String random_result;
        Random random = new Random();
        if (random.nextBoolean()) {
            random_result = "§a§oуспешно";
        } else {
            random_result = "§c§oне успешно";
        }
        String action = String.join(" ", args);
        message = ChatColor.translateAlternateColorCodes('&', message);
        return message
                .replace("%", "%%")
                .replace("{player}", sender.getName())
                .replace("{action}", action)
                .replace("{result}", random_result);
    }
}
