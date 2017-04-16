package com.markettime.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu Cosma
 *
 */
public class Menu {

    private List<MenuItem> menuItems = new ArrayList<>(0);

    /**
     * Removes all the menu items from the menu.
     */
    public void clear() {
        menuItems.clear();
    }

    /**
     * Adds a new {@link MenuItem} to the menu. If a menu item with the same title key already exists, the operation
     * fails.
     *
     * @param menuItem
     * @return
     */
    public boolean add(MenuItem menuItem) {
        menuItems.stream().forEach(item -> {
            if (item.getTitleKey().equals(menuItem.getTitleKey())) {
                throw new IllegalArgumentException(
                        String.format("A menu item with titleKey=%s already exists.", menuItem.getTitleKey()));

            }
        });
        return menuItems.add(menuItem);
    }

    /**
     * Removes a {@link MenuItem} (if it exists) based on the specified title key.
     *
     * @param titleKey
     * @return
     */
    public boolean remove(String titleKey) {
        if (titleKey == null) {
            throw new IllegalArgumentException("Title key cannot be null.");
        }
        return menuItems.removeIf(item -> titleKey.equals(item.getTitleKey()));
    }

    /**
     * Retrieves all the menu items.
     *
     * @return
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Menu [menuItems=").append(menuItems).append("]");
        return builder.toString();
    }

}
