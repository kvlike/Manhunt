package listeners;

import me.kvlike.manhunt.Manhunt;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){

        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)){

            if(e.getFrom().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                Manhunt.tpLocationOv = e.getFrom();
            }
            else{
                Manhunt.tpLocationNt = e.getFrom();
            }

        }
        else if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){

            if(e.getFrom().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                Manhunt.tpLocationOv = e.getFrom();
            }

        }

    }

}
