package view;

import service_ver3.CarService;

public class Tester {

    public static void main(String[] args) {

        CarService service = new CarService();

        System.out.println("Add cars");
        service.addCars();

        System.out.println("Display ASC");
        service.displayAll();

        System.out.println("Display DESC");
        service.displayDescAll();

        System.out.println("Count Honda");
        System.out.println(service.countCarsByBrand("Honda"));

        System.out.println("Save text file");
        service.saveDataToFile("data.txt");

        System.out.println("Save binary file");
        service.saveDataToBinaryFile("cars.dat");
    }
}