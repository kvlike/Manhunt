package listeners;

import me.kvlike.manhunt.Manhunt;
import org.bukkit.Location;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof EnderDragon) {

            if(e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {

                EnderDragon ed = (EnderDragon) e.getEntity();
                Location l = ed.getLocation();
                ed.setVelocity(ed.getVelocity().add(new Vector(0, 0.25, 0)));

                ed.damage(20);

                new BukkitRunnable() {
                    int time;
                    public void run() {
                        ed.teleport(l);
                        time++;
                        if(time > 2) {

                            ed.setVelocity(ed.getVelocity().add(new Vector(0, 0.23, 0)));
                            this.cancel();
                        }
                    }
                }.runTaskTimer(Manhunt.getProvidingPlugin(Manhunt.class), 0, 1);
            }
        }

    }

}
