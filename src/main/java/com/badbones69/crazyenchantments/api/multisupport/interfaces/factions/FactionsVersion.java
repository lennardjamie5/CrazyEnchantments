package com.badbones69.crazyenchantments.api.multisupport.interfaces.factions;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface FactionsVersion {

    String wilderness = "Wilderness";

    boolean isFriendly(Player player, Player other);

    boolean inTerritory(Player player);

    boolean canBreakBlock(Player player, Block block);

}