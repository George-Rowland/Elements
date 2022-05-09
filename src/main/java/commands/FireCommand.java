package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FireCommand implements CommandExecutor {

    //For Chat Colour
    String Color(String c) {
        c = ChatColor.translateAlternateColorCodes('&' , c);
        return c; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("elements.fire")) {
                if (args.length != 1) {
                    p.sendMessage(Color("&cCorrect Usage /fire [IGN]"));
                    return true;
                }
                else {
                    p.sendMessage(Color("&7You have set &c" + args[0] + " &7on fire!"));
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setFireTicks(60);
                    return true;
                }
            } else {
                p.sendMessage(Color("&cYou do not have the permission to use this command (elements.fire)"));
                return true;
            }




        } else {
            sender.sendMessage("This command may only be used InGame");
        }
        return false;
    }
}
