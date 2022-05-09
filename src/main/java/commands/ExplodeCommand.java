package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplodeCommand implements CommandExecutor {

    //For Chat Colour
    String Color(String c) {
        c = ChatColor.translateAlternateColorCodes('&' , c);
        return c; }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("elements.explode")) {

                if (args.length != 1) {
                    p.sendMessage(Color("&cCorrect Usage /explode [IGN]"));
                    return true;
                }
                else {
                    p.sendMessage(Color("&7You have exploded &c" + args[0] + "&7!"));
                    Player target = Bukkit.getPlayer(args[0]);
                    Location targetLoc = target.getLocation();
                    World world = target.getWorld();
                    world.createExplosion(targetLoc, 8, false, false);
                    return true;
                }
            } else {
                p.sendMessage(Color("&cYou do not have the permission to use this command (elements.explode)"));
            }




        } else {
            sender.sendMessage("This command may only be used InGame");

        }
            return false;
    }
}

