package swen221.adventure.model;

import java.awt.Graphics;
import java.util.Objects;

public class Book extends PickupableItem {

    private final String title; //Title of book
    private boolean isRead = false; //If the book has been read or not

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String[] getActions() {
        return new String[]{"Pickup","Drop", "Read"};
    }

    public String getTitle() { return title; }

    @Override
    public String getDescription() {
        if (!isRead) {
            isRead = true;
            return "A book entitled \"" + title + "\"";
        } else {
            return "A book entitled \"" + title + "\"; it looks like it has been read";
        }
    }

    @Override
    public boolean performAction(String action, Player player) {
        Book book = new Book(title);

        if(Objects.equals(action, "Pickup")) {
            player.getInventory().add(book);
            return true;
        }
        if(Objects.equals(action, "Drop")) {
            player.getInventory().remove(book);
            return true;
        }
        if(Objects.equals(action, "Read")) {
            getDescription();
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {

    }
}

