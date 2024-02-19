package com.badbones69.crazyenchantments.paper.api.builders;

import com.badbones69.crazyenchantments.paper.CrazyEnchantments;
import com.badbones69.crazyenchantments.paper.api.utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")
public abstract class InventoryBuilder implements InventoryHolder {

    @NotNull
    protected final CrazyEnchantments plugin = CrazyEnchantments.get();

    private final Inventory inventory;
    private final Player player;
    private String title;
    private int size;
    private int page;

    public InventoryBuilder(Player player, int size, String title) {
        this.title = title;
        this.size = size;

        this.player = player;

        this.inventory = this.plugin.getServer().createInventory(this, this.size, ColorUtils.color(this.title));
    }

    public abstract InventoryBuilder build();

    public void size(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return this.page;
    }

    public void title(String title) {
        this.title = title;
    }

    public boolean contains(String message) {
        return this.title.contains(message);
    }

    public Player getPlayer() {
        return this.player;
    }

    public InventoryView getInventoryView() {
        return getPlayer().getOpenInventory();
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return this.inventory;
    }
}