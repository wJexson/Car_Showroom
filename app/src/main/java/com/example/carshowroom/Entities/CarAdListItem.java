package com.example.carshowroom.Entities;

public class CarAdListItem {
    private String name; // название
    private String year;
    private String price;
    private String color;
    private int flagResource; // ресурс флага

    public CarAdListItem(String name, String year, String price, String color, int flagResource) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.flagResource = flagResource;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
