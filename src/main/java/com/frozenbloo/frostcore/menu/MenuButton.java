package com.frozenbloo.frostcore.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class MenuButton {

    private ItemStack itemStack;
    private Consumer<Player> whenClicked;

    /**
     * Class Constructor
     * @param itemStack The itemstack to use for this button
     */
    public MenuButton(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * Returns the value of the whenClicked Consumer
     * @return
     */
    public Consumer<Player> getWhenClicked() {
        return whenClicked;
    }

    /**
     * Sets the value of the whenClicked consumer.
     * @param whenClicked The consumer to set
     * @return Returns this object
     */
    public MenuButton setWhenClicked(Consumer<Player> whenClicked) {
        this.whenClicked = whenClicked;
        return this;
    }

    /**
     * Returns the itemStack for this button.
     * @return The itemStack supplied in the constructor.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }
}
