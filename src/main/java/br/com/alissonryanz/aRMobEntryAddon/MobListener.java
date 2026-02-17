package br.com.alissonryanz.aRMobEntryAddon;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class MobListener implements Listener {

    private final ARMobEntryAddon plugin;

    public MobListener(ARMobEntryAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onMobMove(EntityMoveEvent event) {
        if (event.getEntity() instanceof Player) return;

        if (isWhitelisted(event.getEntity().getType().name())) return;

        RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();

        if (!query.testState(BukkitAdapter.adapt(event.getTo()), null, Flags.MOB_SPAWNING)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;

        if (isWhitelisted(event.getEntity().getType().name())) return;

        RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();

        if (!query.testState(BukkitAdapter.adapt(player.getLocation()), null, Flags.MOB_SPAWNING)) {
            event.setCancelled(true);

            String msg = plugin.getConfig().getString("messages.denied-damage");
            player.sendMessage(format(msg));
        }
    }

    private boolean isWhitelisted(String typeName) {
        return plugin.getConfig().getStringList("whitelist").contains(typeName);
    }

    private String format(String text) {
        String prefix = plugin.getConfig().getString("messages.prefix");
        return ChatColor.translateAlternateColorCodes('&', prefix + text);
    }
}