package listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){

        for(Entity entity : e.getPlayer().getNearbyEntities(50.0, 50.0, 50.0)){
            if(entity.getType() == EntityType.PIGLIN_BRUTE){
                ((LivingEntity) entity).setHealth(0.0);
            }
        }

    }

}
