package listeners;

import events.HunterAddEvent;
import me.kvlike.manhunt.Manhunt;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HunterAddListener implements Listener {

    @EventHandler
    public void onHunterAdd(HunterAddEvent event){

        Manhunt.hunters.add(event.getHunter());

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassmeta = compass.getItemMeta();

        compassmeta.setDisplayName(ChatColor.YELLOW + "Player tracker");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Right click to track the nearest speedrunner.");
        compassmeta.setLore(lore);

        compass.setItemMeta(compassmeta);

        event.getHunter().getInventory().addItem(compass);

    }

}
