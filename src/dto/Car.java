/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import myUtils.Inputer;

/**
 *
 * @author user
 */
public class Car implements Comparable<Car>, Serializable{
    private String brand,model; 
    private int year;
    private Engine usedEngine;// vi 1 Car has-a 1 Engine
    
    public Car(){
        this.brand="Mec";
        this.model="MayBach";
        this.year=2025;
        this.usedEngine=new Engine();
    }

    public Car(String brand, String model, int year, Engine usedEngine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.usedEngine = usedEngine;
    }
    public Car(String brand, String model,int year, String type, int power)
    {
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.usedEngine=new Engine(power, type);
    }
    public void displayCar(){
        System.out.println("brand:"+ this.brand);
        System.out.println("model:"+ this.model);
        System.out.println("year:"+this.year);
        System.out.println("engine:" + this.usedEngine.getType() +"," + this.usedEngine.getPower());
        //this.usedEngine.display();
    }
    public void input(){
        System.out.println("enter brand:");
        this.brand=Inputer.inputString("^[a-zA-Z]+$");
        System.out.println("enter model:");
        this.model=Inputer.inputString("^[a-zA-Z0-9]+$");
        System.out.println("enter year:");
        Date d=new Date();
        this.year=Inputer.inputNumber(2000, d.getYear()+1900);
        System.out.println("enter engine's infor:");
        this.usedEngine.inputEngine();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Engine getUsedEngine() {
        return usedEngine;
    }

    public void setUsedEngine(Engine usedEngine) {
        this.usedEngine = usedEngine;
    }

    //ham nay dc su dung trong ham add() cua Set
    //sd de so sanh ptu o muon add vao co bi trung voi cac ptu da add trc do hay ko
    //2 ptu trung nhau dua tren field nao se do de bai uyet dinh
    //dua vao yeu to nay de Dev code trong ham compareTo
    //vi du: de bai yeu cau 2 Car goi la trung nhau khi model 
    @Override
    public int compareTo(Car o) {
       if( model.compareTo( o.getModel())>0 ) return 1;
       else if(model.compareTo( o.getModel())<0) return -1;
       return 0;// model 2 xe giong nhau
    }
    
}
