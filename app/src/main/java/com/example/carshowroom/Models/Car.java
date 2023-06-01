package com.example.carshowroom.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Car implements Parcelable {

    public static final String SELECTED_CAR = "SELECTED_CAR";
    public static ArrayList<Car> cars = new ArrayList<>();

    private String brand; // марка
    private String model; // модель
    private String year; // год
    private String price; // цена
    private String color; // цвет
    private String transmission; // коробка
    private String drive_unit; // привод
    private String mileage; // пробег
    private String engine; // двигатель
    private String body; // кузов
    public String condition; // состояние
    public String steering_wheel; // руль
    private String VIN; // VIN
    private String image;

    public Car(String VIN, String brand, String model, String year, String price, String color, String transmission,
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

    protected Car(Parcel in) {
        brand = in.readString();
        model = in.readString();
        year = in.readString();
        price = in.readString();
        color = in.readString();
        transmission = in.readString();
        drive_unit = in.readString();
        mileage = in.readString();
        engine = in.readString();
        body = in.readString();
        condition = in.readString();
        steering_wheel = in.readString();
        VIN = in.readString();
        image = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

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
                ", mileage='" + mileage + '\'' +
                ", engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", condition='" + condition + '\'' +
                ", steering_wheel='" + steering_wheel + '\'' +
                ", VIN='" + VIN + '\'' +
                ", image='" + image + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeString(year);
        dest.writeString(price);
        dest.writeString(color);
        dest.writeString(transmission);
        dest.writeString(drive_unit);
        dest.writeString(mileage);
        dest.writeString(engine);
        dest.writeString(body);
        dest.writeString(condition);
        dest.writeString(steering_wheel);
        dest.writeString(VIN);
        dest.writeString(image);
    }
}
