package commands;

import events.HunterAddEvent;
import events.HunterRemoveEvent;
import me.kvlike.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hunterCommand implements CommandExecutor {

    private String usage = ChatColor.RED + "Usage: " + ChatColor.YELLOW + "/hunter <add/remove> <player>";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("manhunt.hunter")){
            if(args.length >= 1){
                if(args[0].equalsIgnoreCase("add")){
                    if(args.length > 1){
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if(target instanceof Player){
                            if(!Manhunt.hunters.contains(target)) {
                                Bukkit.getServer().getPluginManager().callEvent(new HunterAddEvent(target));
                                sender.sendMessage(ChatColor.RED + target.getDisplayName() + ChatColor.GREEN + " is now a hunter.");
                            }
                            else{
                                sender.sendMessage(ChatColor.RED + "This player is already a hunter!");
                            }
                        }
                        else{
                            sender.sendMessage(ChatColor.RED + "This player does not exist!");
                        }
                    }
                    else{
                        sender.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
                else if(args[0].equalsIgnoreCase("remove")){
                    if(args.length > 1){
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if(target instanceof Player){
                            if(Manhunt.hunters.contains(target)) {
                                Bukkit.getServer().getPluginManager().callEvent(new HunterRemoveEvent(target));
                                sender.sendMessage(ChatColor.RED + target.getDisplayName() + ChatColor.GREEN + " is no longer a hunter.");
                            }
                            else{
                                sender.sendMessage(ChatColor.RED + "This player is not a hunter!");
                            }
                        }
                        else{
                            sender.sendMessage(ChatColor.RED + "This player does not exist!");
                        }
                    }
                    else{
                        sender.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
                else{
                    sender.sendMessage(usage);
                }
            }
            else{
                sender.sendMessage(usage);
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "No permission!");
        }

        return true;
    }
}
