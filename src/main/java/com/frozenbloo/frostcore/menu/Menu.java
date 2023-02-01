package com.frozenbloo.frostcore.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Menu {

    private Inventory inventory;
    private Map<Integer, MenuButton> buttonMap;
    private Consumer<Player> inventoryClosed;
    private Consumer<Player> inventoryOpened;
    private BukkitRunnable menuUpdater;

    /**
     * @param title The title of the inventory
     * @param rows The amount of rows in the inventory
     */
    public Menu(String title, int rows) {
        if (rows > 6 || rows < 1 || title.length() > 32){
            throw new IllegalArgumentException("Invalid arguments passed to menu constructor.");
        }

        //Init variables
        this.inventory = Bukkit.createInventory(null,rows * 9, title);
        this.buttonMap = new HashMap<>();
    }
    /**
     * Registers a button in a specified slot.
     * @param button The button object to register.
     * @param slot The slot to associate it with.
     */
    public void registerButton(MenuButton button, int slot) {
        buttonMap.put(slot,button);
    }

    /**
     * Sets the value of the inventoryClosed consumer.
     * @param inventoryClosed The consumer to use.
     */
    public void setInventoryClosed(Consumer<Player> inventoryClosed) {
        this.inventoryClosed = inventoryClosed;
    }

    /**
     * Sets the value of the inventoryOpened consumer
     * @param inventoryOpened The consumer to use.
     */
    public void setInventoryOpened(Consumer<Player> inventoryOpened) {
        this.inventoryOpened = inventoryOpened;
    }

    /**
     * Handles a player closing the inventory. <br>
     * Executes the inventoryClosed consumer if it is not null.
     * @param player The player who has closed the inventory.
     */
    public void handleClose(Player player) {
        if (inventoryClosed != null){
            inventoryClosed.accept(player);
        }
    }

    /**
     * Handles a player opening the inventory. <br>
     * Executes the inventoryOpen consumer if it is not null.
     * @param player The player who has opened the inventory.
     */
    public void handleOpen(Player player){
        // Is there an action associated with opening the inventory?
        if (inventoryOpened != null){
            // Perform the action
            inventoryOpened.accept(player);
        }
    }

    /**
     * Handles an InventoryClickEvent inside this menu.
     * @param event The InventoryClickEvent.
     */
    public void handleClick(InventoryClickEvent event) {
        event.setCancelled(true);
        ItemStack clicked = event.getCurrentItem();

        if (clicked == null){
            return;
        }

        if (buttonMap.containsKey(event.getRawSlot())){
            // Clicked on a valid button

            Consumer<Player> consumer = buttonMap.get(event.getRawSlot()).getWhenClicked();

            // Does the button clicked have an action associated with it?
            if (consumer != null){
                // Performs the action.
                consumer.accept((Player) event.getWhoClicked());
            }
        }
    }

    /**
     * Opens the inventory to a specified player.
     * @param player The player to open the inventory to.
     */
    public void open(Player player) {
        MenuManager manager = MenuManager.getInstance();
        buttonMap.forEach((slot, button) -> {
            inventory.setItem(slot, button.getItemStack());
        });
        // Open the inventory and handle the open event.
        player.openInventory(inventory);
        manager.registerMenu(player.getUniqueId(), this);
        handleOpen(player);
    }

    /**
     * Method is called when the MenuUpdater runnable executes/
     */
    public void onUpdate() {}

}
