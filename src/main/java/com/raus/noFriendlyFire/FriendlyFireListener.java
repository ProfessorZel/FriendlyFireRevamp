//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.raus.noFriendlyFire;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FriendlyFireListener implements Listener {
    public FriendlyFireListener() {
    }

    @EventHandler(
            priority = EventPriority.LOW
    )
    public void onHit(EntityDamageByEntityEvent event) {
        Entity ent = event.getEntity();
        Entity dmg = event.getDamager();
        if (dmg instanceof Projectile) {
            dmg = (Entity)((Projectile)dmg).getShooter();
        }

        if (ent instanceof Tameable && dmg instanceof AnimalTamer) {
            Tameable pet = (Tameable)ent;
            AnimalTamer owner = (AnimalTamer)dmg;
            boolean toggle = com.raus.noFriendlyFire.Main.friendlyFire.containsKey(owner.getUniqueId()) ? (Boolean) com.raus.noFriendlyFire.Main.friendlyFire.get(owner.getUniqueId()) : true;
            if (toggle && pet.isTamed() && pet.getOwner().equals(owner)) {
                event.setDamage(0.0D);
                event.setCancelled(true);
            }
        }

    }
}
