package br.com.alissonryanz.aRMobEntryAddon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ARMobEntryAddon extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new MobListener(this), this);
        getCommand("armob").setExecutor(this);

        getLogger().info("ARMobEntryAddon: Entrada e Dano protegidos (1.21.10)");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("armob.admin")) {
                sender.sendMessage(getConfig().getString("messages.no-permission"));
                return true;
            }
            reloadConfig();
            sender.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&',
                    getConfig().getString("messages.prefix") + getConfig().getString("messages.reload")));
            return true;
        }
        return false;
    }
}