package com.geekymon2.carmarketplace.carorchestrator.models;

public class Car {
    long carId;
    String make;
    String model;
    int year;
    int doors;
    int seats;
    int odometer;
    String description;

    public Car() {
    }

    public Car(long carId, String make, String model, int year, int doors, int seats, int odometer, String description) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.doors = doors;
        this.seats = seats;
        this.odometer = odometer;
        this.description = description;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

