
/*package view3;

import java.util.Scanner;
import service_ver3.CarService;

/*
public class Main {
    public static void main(String[] args) {
        String filename="data.txt";
        String filename2="emyeuco.xinhdep";
        CarService t=new CarService();
        int choice=0;
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        do{ 
        try{   
          System.out.println("ban muon doc file nao textfile(1) or binary file(2):");
          sc=new Scanner(System.in);
          choice=sc.nextInt();
          flag=false;
        }catch(Exception e){
            System.out.println("nhap choice sai");
            flag=true;
        }
       }while(flag);
        if(choice==1)
          t.readDataFromFile(filename);
        else if(choice==2)
          t.readDataFromBinaryFile(filename2);
        System.out.println("loading data.....done!!!!");
        t.addCars();//nhap tu ban phim
        t.displayAll();//xuat ra man hinh
        System.out.println("ban co muon luu cac cars vao text file(1) or binary file(2)?:");
        sc=new Scanner(System.in);
        choice=sc.nextInt();
        if(choice==1){
            t.saveDataToFile(filename);
        }
        else if(choice==2){
            t.saveDataToBinaryFile(filename2);
        }
    }
   
}
*/

package view3;

import java.util.Scanner;
import service_ver3.CarService;

public class Main {

    public static void main(String[] args) {

        String filename="data.txt";
        String filename2="cars.dat";

        CarService service=new CarService();
        Scanner sc=new Scanner(System.in);

        int choice=0;

        while(true){

            try{
                System.out.println("Doc file text(1) or binary(2):");
                choice=sc.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("Nhap sai!");
                sc.nextLine();
            }
        }

        if(choice==1)
            service.readDataFromFile(filename);
        else
            service.readDataFromBinaryFile(filename2);

        System.out.println("Loading data... done!");

        service.addCars();

        System.out.println("===== LIST CARS =====");
        service.displayAll();

        System.out.println("Luu file text(1) or binary(2):");
        choice=sc.nextInt();

        if(choice==1)
            service.saveDataToFile(filename);
        else
            service.saveDataToBinaryFile(filename2);

        System.out.println("Save done!");
    }
}