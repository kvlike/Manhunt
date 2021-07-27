package events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HunterRemoveEvent extends Event {

    private Player hunter;

    public HunterRemoveEvent(Player hunter){
        this.hunter = hunter;
    }

    public Player getHunter() {
        return hunter;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
