package listeners;

import me.kvlike.manhunt.Manhunt;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        if(Manhunt.hunters.contains(event.getPlayer())){

            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemMeta compassmeta = compass.getItemMeta();

            compassmeta.setDisplayName(ChatColor.YELLOW + "Player tracker");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "Right click to track the nearest speedrunner.");
            compassmeta.setLore(lore);

            compass.setItemMeta(compassmeta);

            event.getPlayer().getInventory().addItem(compass);

        }
    }

}
