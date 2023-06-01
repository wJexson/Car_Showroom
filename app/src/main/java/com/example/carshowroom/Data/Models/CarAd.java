package com.example.carshowroom.Data.Models;

import androidx.annotation.NonNull;

import com.example.carshowroom.R;

import java.util.ArrayList;

public class CarAd {

    public static ArrayList<CarAd> carAds = new ArrayList<>();

    private String brand; // марка
    private String model; // модель
    private String year; // год
    private String price; // цена
    private String color; // цвет
    private String transmission; // коробка
    private String drive_unit; // привод
    private int flagResource = 0; // ресурс флага
    private String mileage; // пробег
    private String engine; // двигатель
    private String body; // кузов
    public String condition; // состояние
    public String steering_wheel; // руль
    private String VIN; // VIN
    private String image;

    public CarAd() {
    }

    public CarAd(String VIN, String brand, String model, String year, String price, String color, String transmission,
                 String drive_unit, String mileage, String engine, String body,
                 String condition, String steering_wheel, String image) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.transmission = transmission;
        this.drive_unit = drive_unit;
        this.mileage = mileage;
        this.engine = engine;
        this.body = body;
        this.condition = condition;
        this.steering_wheel = steering_wheel;
        this.image = image;
    }

    public CarAd(String VIN) {
        this.VIN = VIN;
        this.setDataByVIN();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String name) {
        this.brand = name;
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


    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setSteering_wheel(String steering_wheel) {
        this.steering_wheel = steering_wheel;
    }

    public String getSteering_wheel() {
        return steering_wheel;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setDataByVIN() {
        switch (this.VIN) {
            case "JN1AR34D12A000001":
                this.setBrand("Nissan");
                this.setModel("Skyline GT-R R34");
                this.setFlagResource(R.drawable.skyline);
                this.setPrice("120 000");
                this.setYear("2002");
                this.setMileage("42 000 км");
                this.setEngine("2.5 л / 280 л.с. / Бензин");
                this.setBody("Купе");
                this.setColor("Серый");
                this.setDrive_unit("Полный");
                this.setTransmission("Автоматическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Правый");
                break;
            case "WAUZZZF57MA900001":
                this.setBrand("Audi");
                this.setModel("RS5 F5");
                this.setFlagResource(R.drawable.rs5);
                this.setPrice("125 000");
                this.setYear("2021");
                this.setMileage("20 км");
                this.setEngine("2.9 л / 450 л.с. / Бензин");
                this.setBody("Купе");
                this.setColor("Черный");
                this.setDrive_unit("Полный");
                this.setTransmission("Автоматическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Левый");
                break;
            case "JM1FE1C43B0400001":
                this.setBrand("Mazda");
                this.setModel("RX-8");
                this.setFlagResource(R.drawable.rx8);
                this.setPrice("19 852");
                this.setYear("2011");
                this.setMileage("190  125 км");
                this.setEngine("1.3 / 250 л.c. / Бензин");
                this.setBody("Купе");
                this.setColor("Серый");
                this.setDrive_unit("Задний");
                this.setTransmission("Механическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Правый");
                break;
            case "JM1FD3332P0200001":
                this.setBrand("Mazda");
                this.setModel("RX-7");
                this.setFlagResource(R.drawable.rx7);
                this.setPrice("31 332");
                this.setYear("2002");
                this.setMileage("58 000 км");
                this.setEngine("1.3 / 280 л.c. / Бензин");
                this.setBody("Купе");
                this.setColor("Серый");
                this.setDrive_unit("Задний");
                this.setTransmission("Механическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Правый");
                break;
            case "EK9-1000001":
                this.setBrand("Honda");
                this.setModel("Civic TYPE R");
                this.setFlagResource(R.drawable.civic);
                this.setPrice("16 738");
                this.setYear("2000");
                this.setMileage("168 000 км");
                this.setEngine("1.6 / 185 л.c. / Бензин");
                this.setBody("Хэтчбек 3 дв.");
                this.setColor("Черный");
                this.setDrive_unit("Передний");
                this.setTransmission("Механическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Правый");
                break;
            case "WBSBL93435PN63001":
                this.setBrand("BMW");
                this.setModel("M3 E46");
                this.setFlagResource(R.drawable.m3e46);
                this.setPrice("56 800");
                this.setYear("2005");
                this.setMileage("32 000 км");
                this.setEngine("3.2 / 343 л.c. / Бензин");
                this.setBody("Купе");
                this.setColor("Серый");
                this.setDrive_unit("Задний");
                this.setTransmission("Механическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Левый");
                break;
            case "WDDZF8KB7JA421234":
                this.setBrand("Mercedes-Benz");
                this.setModel("E63 AMG S");
                this.setFlagResource(R.drawable.e63s);
                this.setPrice("112 000");
                this.setYear("2018");
                this.setMileage("23 000 км");
                this.setEngine("4.0 л / 612 л.с. / Бензин");
                this.setBody("Седан");
                this.setColor("Желтый");
                this.setDrive_unit("Полный");
                this.setTransmission("Автоматическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Левый");
                break;
            case "JT2DE82A020062413":
                this.setBrand("Toyota");
                this.setModel("Supra A80");
                this.setFlagResource(R.drawable.supra_a80);
                this.setPrice("82 000");
                this.setYear("2002");
                this.setMileage("123 000 км");
                this.setEngine("3.0 л / 280 л.с. / Бензин");
                this.setBody("Купе");
                this.setColor("Синий");
                this.setDrive_unit("Задний");
                this.setTransmission("Автоматическая");
                this.setCondition("Не битый");
                this.setSteering_wheel("Правый");
                break;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return "CarAd{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                ", drive_unit='" + drive_unit + '\'' +
                ", flagResource=" + flagResource +
                ", mileage='" + mileage + '\'' +
                ", engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", condition='" + condition + '\'' +
                ", steering_wheel='" + steering_wheel + '\'' +
                ", VIN='" + VIN + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
