package com.poseidon.poseidonlib.util;

import net.minecraft.world.entity.Entity;                                   // entity base
import net.minecraft.world.entity.LivingEntity;                             // living entities
import net.minecraft.world.entity.animal.IronGolem;                         // village golem
import net.minecraft.world.entity.monster.Monster;                          // vanilla monsters
import net.minecraft.world.entity.npc.AbstractVillager;                     // villagers + wandering traders
import net.minecraft.world.entity.player.Player;                            // players
import net.minecraft.world.entity.raid.Raider;                              // pillagers, vindicators, ...

/**
 * Shared entity classification predicates used across Poseidon mods for
 * target selection, ally checks and spawn filters.
 */
public final class EntityPredicates {

    private EntityPredicates() {
    }

    /** Vanilla monsters (zombies, creepers, skeletons, ...). */
    public static boolean isMonster(Entity entity) {
        return entity instanceof Monster;
    }

    /** Raid mobs - pillagers, vindicators, evokers, witches, ravagers. */
    public static boolean isRaider(Entity entity) {
        return entity instanceof Raider;
    }

    /** Anything a defender-style unit should engage. */
    public static boolean isHostile(Entity entity) {
        return isMonster(entity) || isRaider(entity);
    }

    /** Villagers and wandering traders - the protected population. */
    public static boolean isVillager(Entity entity) {
        return entity instanceof AbstractVillager;
    }

    /** Iron golems - village defenders. */
    public static boolean isIronGolem(Entity entity) {
        return entity instanceof IronGolem;
    }

    /** Real players. */
    public static boolean isPlayer(Entity entity) {
        return entity instanceof Player;
    }

    /** Alive living entity that can be targeted or hurt. */
    public static boolean isTargetable(Entity entity) {
        return entity instanceof LivingEntity && entity.isAlive();
    }
}
