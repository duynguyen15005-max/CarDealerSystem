package view2;

import java.util.Scanner;
import service_ver2.CarService;

public class Tester {

    public static void main(String[] args) {

        CarService service = new CarService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Car Management");
            System.out.println("1 Input Cars");
            System.out.println("2 Display All");
            System.out.println("3 Count By Brand");
            System.out.println("4 Count By Year");
            System.out.println("5 Display By Brand");
            System.out.println("6 Display By Engine Type");
            System.out.println("7 Get Cars By Power");
            System.out.println("8 Statistic By Brand");
            System.out.println("0 Exit");

            System.out.print("Choose: ");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    service.inputCars();
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Brand: ");
                    String brand=sc.nextLine();
                    System.out.println(service.countCarsByBrand(brand));
                    break;

                case 4:
                    System.out.print("Year: ");
                    int year=sc.nextInt();
                    System.out.println(service.countCarsByYear(year));
                    break;

                case 5:
                    System.out.print("Brand: ");
                    String b=sc.nextLine();
                    service.displayCarsByBrand(b);
                    break;

                case 6:
                    System.out.print("Type: ");
                    String type=sc.nextLine();
                    service.displayCarsByType(type);
                    break;

                case 7:
                    System.out.print("Low power: ");
                    int low=sc.nextInt();
                    System.out.print("High power: ");
                    int high=sc.nextInt();
                    service.getCarsByPower(low,high).forEach(c->c.displayCar());
                    break;

                case 8:
                    System.out.print("Brand: ");
                    String br=sc.nextLine();
                    service.statistic(br);
                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while(choice!=0);
    }
}