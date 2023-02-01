package com.frozenbloo.frostcore.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager {

    private static MenuManager instance;
    private final Map<UUID, Menu> openMenus;

    /**
     * Class Constructor.
     */
    public MenuManager() {
        this.openMenus = new HashMap<>();
    }

    /**
     * Creates a new instance of the Menu manager if one doesn't already exist
     * @return The Menu Manager Instance
     */
    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    /**
     * Register a menu to a user;
     * @param toRegister The User.
     * @param menu THe Menu.
     */
    public void registerMenu(UUID toRegister, Menu menu) {
        openMenus.put(toRegister, menu);
    }

    /**
     * Unregister a menu
     * @param toUnRegister THe user's menu to unregister.
     */
    public void unregisterMenu(UUID toUnRegister) {
        openMenus.remove(toUnRegister);
    }

    /**
     * Find a menu.
     * @param user The user to search for.
     * @return THe Menu found, or null if it does not exist.
     */
    public Menu matchMenu(UUID user) { return openMenus.get(user); }
}
