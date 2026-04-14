package service;

import dto.Car;
import myUtils.IConstant;
import myUtils.Inputer;

public class CarService {
    private Car[] arr = new Car[IConstant.MAX];
    private int count = 0;
    public void inputCars() {
        int ans;
        do {
            Car A = new Car();
            A.input();
            arr[count] = A;
            count++;
            System.out.println("Add more (1|0)?");
            ans = Inputer.inputNumber(0, 1);
        } while (ans == 1);
    }
    public void displayAll() {
        for (Car c : arr) {
            if (c == null) break;
            c.displayCar();
        }
    }
    public int countCarsByBrand(String brand) {
        int result = 0;
        for (Car c : arr) {
            if (c == null) break;
            if (c.getBrand().equalsIgnoreCase(brand)) result++;
        }
        return result;
    }
    public int countCarsByYear(int year) {
        int result = 0;
        for (Car c : arr) {
            if (c == null) break;
            if (c.getYear() == year) result++;
        }
        return result;
    }
    public void displayCarsByBrand(String brand) {
        for (Car c : arr) {
            if (c == null) break;
            if (c.getBrand().equalsIgnoreCase(brand)) c.displayCar();
        }
    }
    public void displayCarsByType(String type) {
        for (Car c : arr) {
            if (c == null) break;
            if (c.getUsedEngine().getType().equalsIgnoreCase(type)) c.displayCar();
        }
    }
    public Car[] getCarsByBrand(String brand) {
        Car[] result = new Car[count];
        int n = 0;
        for (Car c : arr) {
            if (c == null) break;
            if (c.getBrand().equalsIgnoreCase(brand)) {
                result[n] = c;
                n++;
            }
        }
        return result;
    }
    public Car[] getCarsByYear(int year) {
        Car[] result = new Car[count];
        int n = 0;
        for (Car c : arr) {
            if (c == null) break;
            if (c.getYear() == year) {
                result[n] = c;
                n++;
            }
        }
        return result;
    }
    public Car[] getCarsByPower(int low, int high) {
        Car[] result = new Car[count];
        int n = 0;
        for (Car c : arr) {
            if (c == null) break;
            int power = c.getUsedEngine().getPower();
            if (power >= low && power <= high) {
                result[n] = c;
                n++;
            }
        }
        return result;
    }
    public void statistic(String brand) {
        System.out.println("BRAND: " + brand);
        for (Car c : arr) {
            if (c == null) break;
            if (c.getBrand().equalsIgnoreCase(brand)) {
                int year = c.getYear();
                System.out.println("YEAR: " + year);
                System.out.println("MODEL|TYPE|POWER");

                for (Car x : arr) {
                    if (x == null) break;
                    if (x.getBrand().equalsIgnoreCase(brand) && x.getYear() == year) {
                        System.out.println("" + x.getModel() + "|" + x.getUsedEngine().getType() + "|" + x.getUsedEngine().getPower());
                    }
                }
            }
        }
    }
}