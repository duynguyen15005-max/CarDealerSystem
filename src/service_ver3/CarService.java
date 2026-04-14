package service_ver3;

import dto.Car;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class CarService {

    private TreeSet<Car> setCars = new TreeSet<>();

    public void addCars() {
        String ans="y";
        do{
            Car c=new Car();
            c.input();
            setCars.add(c);
            System.out.println("add more(y|n)?");
            Scanner sc=new Scanner(System.in);
            ans=sc.nextLine();
        }while(ans.equalsIgnoreCase("y"));
    }

    public void readDataFromFile(String filename) {
        FileReader f=null;
        BufferedReader bf=null;
        try{
            f=new FileReader(filename);
            bf=new BufferedReader(f);

            while(bf.ready()){
                String s=bf.readLine();
                String[] a=s.split("[,-]");

                if(a.length==5){
                    Car c=new Car(
                        a[0],a[1],
                        Integer.parseInt(a[2].trim()),
                        a[3],
                        Integer.parseInt(a[4].trim())
                    );
                    setCars.add(c);
                }
            }
        }catch(Exception e){
            System.out.println("cannot open file");
        }finally{
            try{
                if(f!=null) f.close();
                if(bf!=null) bf.close();
            }catch(Exception e){
                System.out.println("file close error");
            }
        }
    }

    public void saveDataToFile(String filename) {
        PrintWriter f=null;
        try{
            f=new PrintWriter(filename);
            for(Car c:setCars){
                String s=c.getBrand()+","+c.getModel()+","+c.getYear()+"-"+c.getUsedEngine().getType()+","+c.getUsedEngine().getPower();
                f.println(s);
            }
        }catch(Exception e){
            System.out.println("file write error");
        }finally{
            if(f!=null) f.close();
        }
    }

    public void saveDataToBinaryFile(String filename) {
        FileOutputStream f=null;
        ObjectOutputStream of=null;
        try{
            f=new FileOutputStream(filename);
            of=new ObjectOutputStream(f);
            of.writeObject(setCars);
        }catch(Exception e){
            System.out.println("file write error");
        }finally{
            try{
                if(f!=null) f.close();
                if(of!=null) of.close();
            }catch(Exception e){
                System.out.println("close file error");
            }
        }
    }

    public void readDataFromBinaryFile(String filename) {
        FileInputStream f=null;
        ObjectInputStream of=null;
        try{
            f=new FileInputStream(filename);
            of=new ObjectInputStream(f);
            setCars=(TreeSet<Car>)of.readObject();
        }catch(Exception e){
            System.out.println("file read error");
        }finally{
            try{
                if(f!=null) f.close();
                if(of!=null) of.close();
            }catch(Exception e){
                System.out.println("close file error");
            }
        }
    }

    public void displayAll() {
        for(Car c:setCars) c.displayCar();
    }

    public void displayDescAll() {
        Iterator<Car> it=setCars.descendingIterator();
        while(it.hasNext()){
            Car c=it.next();
            c.displayCar();
        }
    }

    public int countCarsByBrand(String brand) {
        int count=0;
        for(Car c:setCars) if(c.getBrand().equalsIgnoreCase(brand)) count++;
        return count;
    }

    public int countCarsByYear(int year) {
        int count=0;
        for(Car c:setCars) if(c.getYear()==year) count++;
        return count;
    }

    public void displayCarsByBrand(String brand) {
        for(Car c:setCars) if(c.getBrand().equalsIgnoreCase(brand)) c.displayCar();
    }

    public void displayCarsByType(String type) {
        for(Car c:setCars) if(c.getUsedEngine().getType().equalsIgnoreCase(type)) c.displayCar();
    }

    public ArrayList<Car> getCarsByYear(int year) {
        ArrayList<Car> result=new ArrayList<>();
        for(Car c:setCars) if(c.getYear()==year) result.add(c);
        return result;
    }

    public ArrayList<Car> getCarsByPower(int low,int high) {
        ArrayList<Car> result=new ArrayList<>();
        for(Car c:setCars){
            int p=c.getUsedEngine().getPower();
            if(p>=low && p<=high) result.add(c);
        }
        return result;
    }

    public void statistic(String brand) {
        System.out.println("BRAND: "+brand);
        for(Car c:setCars){
            if(c.getBrand().equalsIgnoreCase(brand)){
                int year=c.getYear();
                System.out.println(" YEAR: "+year);
                System.out.println(" Model|Type|Power");

                for(Car x:setCars){
                    if(x.getBrand().equalsIgnoreCase(brand) && x.getYear()==year){
                        System.out.println(x.getModel()+"|"+x.getUsedEngine().getType()+"|"+x.getUsedEngine().getPower());
                    }
                }
            }
        }
    }
}