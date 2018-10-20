package me.shanodekono.nostrip.listeners;

import me.shanodekono.nostrip.NoStrip;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteractListener implements Listener {

    private List<Material> logs;

    public PlayerInteractListener() {
        logs = new ArrayList<>();

        logs.add(Material.ACACIA_LOG);
        logs.add(Material.BIRCH_LOG);
        logs.add(Material.DARK_OAK_LOG);
        logs.add(Material.JUNGLE_LOG);
        logs.add(Material.SPRUCE_LOG);
        logs.add(Material.OAK_LOG);
    }

    @EventHandler
    private void onInteract (PlayerInteractEvent event) {

        // Checks if action is not right click, stops
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        //Checks if list of materials containing logs, does not contain block interacted with, stops
        if (!logs.contains(event.getClickedBlock().getType())) {
            return;
        }

        if (NoStrip.getEnabledPlayers().contains(event.getPlayer().getUniqueId())) {
            return;    //player has the strip option toggled ON
        }
        // Since all conditions were met stop the interaction from happening.
        event.setCancelled(true);
    }
}