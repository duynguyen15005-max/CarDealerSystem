package service_ver2;

import dto.Car;
import myUtils.Inputer;
import java.util.ArrayList;

public class CarService extends ArrayList<Car> {

    public void inputCars() {
        int ans;
        do {
            Car c = new Car();
            c.input();
            this.add(c);
            System.out.println("Add more (1|0)?");
            ans = Inputer.inputNumber(0,1);
        } while(ans==1);
    }

    public void displayAll() {
        for(Car c:this) c.displayCar();
    }

    public int countCarsByBrand(String brand) {
        int count=0;
        for(Car c:this) if(c.getBrand().equalsIgnoreCase(brand)) count++;
        return count;
    }

    public int countCarsByYear(int year) {
        int count=0;
        for(Car c:this) if(c.getYear()==year) count++;
        return count;
    }

    public void displayCarsByBrand(String brand) {
        for(Car c:this) if(c.getBrand().equalsIgnoreCase(brand)) c.displayCar();
    }

    public void displayCarsByType(String type) {
        for(Car c:this) if(c.getUsedEngine().getType().equalsIgnoreCase(type)) c.displayCar();
    }

    public ArrayList<Car> getCarsByBrand(String brand) {
        ArrayList<Car> result=new ArrayList<>();
        for(Car c:this) if(c.getBrand().equalsIgnoreCase(brand)) result.add(c);
        return result;
    }

    public ArrayList<Car> getCarsByYear(int year) {
        ArrayList<Car> result=new ArrayList<>();
        for(Car c:this) if(c.getYear()==year) result.add(c);
        return result;
    }

    public ArrayList<Car> getCarsByPower(int low,int high) {
        ArrayList<Car> result=new ArrayList<>();
        for(Car c:this){
            int power=c.getUsedEngine().getPower();
            if(power>=low && power<=high) result.add(c);
        }
        return result;
    }

    public void statistic(String brand) {
        System.out.println("BRAND: "+brand);
        for(Car c:this){
            if(c.getBrand().equalsIgnoreCase(brand)){
                int year=c.getYear();
                System.out.println("   YEAR: "+year);
                System.out.println("      MODEL    TYPE    POWER");
                for(Car x:this){
                    if(x.getBrand().equalsIgnoreCase(brand) && x.getYear()==year){
                        System.out.println("      "+x.getModel()+"    "+x.getUsedEngine().getType()+"    "+x.getUsedEngine().getPower());
                    }
                }
            }
        }
    }
}