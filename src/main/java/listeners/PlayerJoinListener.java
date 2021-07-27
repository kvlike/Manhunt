package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(!e.getPlayer().getName().equalsIgnoreCase("kvlike_")){
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "hunter add " + e.getPlayer().getName());
        }
        else{
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "datapack list");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "datapack enable \"file/nether.zip\"");
            // e.getPlayer().sendTitle(ChatColor.RED + "Wlacz datapacka!", ChatColor.GREEN + "/datapack enable \"file/nether.zip\"", 1, 200, 10);
        }
    }

}
