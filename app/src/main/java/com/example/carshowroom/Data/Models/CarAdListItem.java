package com.example.carshowroom.Data.Models;

public class CarAdListItem {
    private String name; // название
    private String year; // год
    private String price; // цена
    private String color; // цвет
    private String transmission; // коробка
    private String drive_unit; // привод
    private int flagResource; // ресурс флага

    public CarAdListItem(String name, String year, String price, String color, String transmission, String drive_unit, int flagResource) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.flagResource = flagResource;
        this.color = color;
        this.transmission = transmission;
        this.drive_unit = drive_unit;
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive_unit() {
        return drive_unit;
    }

    public void setDrive_unit(String drive_unit) {
        this.drive_unit = drive_unit;
    }
}
