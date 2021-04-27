//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.raus.noFriendlyFire;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleCommand implements CommandExecutor {
    public ToggleCommand() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        } else if (args[0].equals("info")) {
            sender.sendMessage( Main.getInstance().getMessage(Messages.VERSION_INFO, Main.getInstance().getDescription().getVersion()));
            return true;
        } else if (args[0].equals("toggle")) {
            if (!sender.hasPermission("nofriendlyfire.toggle")) {
                sender.sendMessage(Main.getInstance().getMessage(Messages.NO_PERMS));
                return true;
            } else if (!(sender instanceof Player)) {
                sender.sendMessage(Main.getInstance().getMessage(Messages.PLAYER_ONLY_COMMAND));
                return true;
            } else {
                Player ply = (Player)sender;
                boolean toggle = Main.friendlyFire.containsKey(ply.getUniqueId()) ? (Boolean)Main.friendlyFire.get(ply.getUniqueId()) : true;
                if (toggle) {
                    sender.sendMessage(Main.getInstance().getMessage(Messages.ENABLE));
                    Main.friendlyFire.put(ply.getUniqueId(), false);
                } else {
                    sender.sendMessage(Main.getInstance().getMessage(Messages.DISABLE));
                    Main.friendlyFire.put(ply.getUniqueId(), true);
                }

                return true;
            }
        } else {
            return false;
        }
    }
}
