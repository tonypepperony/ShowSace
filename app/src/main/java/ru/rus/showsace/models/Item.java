package ru.rus.showsace.models;

/**
 * Created by Ruslan on 05.12.16.
 */

public class Item {
    private int id;
    private String name;
    private int resId;
    private int price;

    public Item(int id, String name, int resId, int price) {
        this.id = id;
        this.name = name;
        this.resId = resId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
