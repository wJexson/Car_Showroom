package com.example.carshowroom.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Car implements Parcelable {

    public static final String SELECTED_CAR = "SELECTED_CAR";
    public static ArrayList<Car> cars = new ArrayList<>();

    private final String brand; // марка
    private final String model; // модель
    private final int year; // год
    private final int price; // цена
    private String color; // цвет
    private final String transmission; // коробка
    private final String drive_unit; // привод
    private final int mileage; // пробег
    private final String engine; // двигатель
    private final String body; // кузов
    public String condition; // состояние
    public String steering_wheel; // руль
    private final String VIN; // VIN
    private final String image;

    public Car(String VIN, String brand, String model, int year, int price, String color, String transmission,
               String drive_unit, int mileage, String engine, String body,
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
        year = in.readInt();
        price = in.readInt();
        color = in.readString();
        transmission = in.readString();
        drive_unit = in.readString();
        mileage = in.readInt();
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

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
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

    public String getDrive_unit() {
        return drive_unit;
    }

    public int getMileage() {
        return mileage;
    }

    public String getEngine() {
        return engine;
    }

    public String getBody() {
        return body;
    }

    public String getCondition() {
        return condition;
    }

    public String getSteering_wheel() {
        return steering_wheel;
    }

    public String getVIN() {
        return VIN;
    }

    public String getModel() {
        return model;
    }

    public String getImage() {
        return image;
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
        dest.writeInt(year);
        dest.writeInt(price);
        dest.writeString(color);
        dest.writeString(transmission);
        dest.writeString(drive_unit);
        dest.writeInt(mileage);
        dest.writeString(engine);
        dest.writeString(body);
        dest.writeString(condition);
        dest.writeString(steering_wheel);
        dest.writeString(VIN);
        dest.writeString(image);
    }
}
