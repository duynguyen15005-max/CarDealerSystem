/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import myUtils.Inputer;

/**
 *  
 * @author user
 */
public class Engine implements Serializable{
    private int power;
    private String type;

    public Engine() {
        this.power=1;
        this.type="electric";
    }

    public Engine(int power, String type) {
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void display(){
        System.out.println("power:"+this.power);
        System.out.println("type:"+ this.type);
    }
    public void inputEngine(){
        do {
            System.out.println("enter type:");
            this.type = Inputer.inputString("^[a-zA-Z]+$");
        } while (this.type.isEmpty());
        do{
            System.out.println("enter power:");
            this.power=Inputer.inputNumber(1, 5);
        }while(this.power==Integer.MAX_VALUE);
    }
}
