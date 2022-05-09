package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class LightningCommand implements CommandExecutor {

    //For Chat Colour
    String Color(String c) {
        c = ChatColor.translateAlternateColorCodes('&' , c);
        return c; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("elements.lightning")) {
                if (args.length != 1) {
                    p.sendMessage(Color("&cCorrect Usage /lightning [IGN]"));
                    return true;
                }
                else {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.getPlayer().getWorld().strikeLightning(target.getLocation());
                    p.sendMessage(Color("&7You have smited &c" + args[0] + "&7!"));
                    return true;

                }
            } else {
                p.sendMessage(Color("&cYou do not have the permission to use this command (elements.lightning)"));
            }




        } else {
            sender.sendMessage("This command may only be used InGame");
        }


        return false;
    }
}
