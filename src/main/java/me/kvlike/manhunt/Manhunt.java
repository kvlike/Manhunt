package me.kvlike.manhunt;

import commands.hunterCommand;
import listeners.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.util.ArrayList;

public final class Manhunt extends JavaPlugin {

    public static ArrayList<Player> hunters;
    public static Location tpLocationOv, tpLocationNt;

    @Override
    public void onEnable() {

        hunters = new ArrayList<>();
        tpLocationOv = null;
        tpLocationNt = null;

        getServer().getPluginManager().registerEvents(new HunterAddListener(), this);
        getServer().getPluginManager().registerEvents(new HunterRemoveListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);

        getCommand("hunter").setExecutor(new hunterCommand());

        FileUtil.copy(new File("datapack_nether/nether.zip"), new File("world/datapacks/nether.zip"));


    }

}
