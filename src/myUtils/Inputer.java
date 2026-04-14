/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myUtils;

import java.util.Scanner;

/**
 *
 * @author user
 */
//day la lop cung cap cac tien ich(ham hay su dung) 
//trong nhieu project,de nhap tu ban phim

public class Inputer {
    //ham nay de nhap 1 chuoi tu ban phim
    //tra ve chuoi vua nhap neu trung pattern
    public static String inputString(String pattern){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if( s.matches(pattern) ) return s;
        return "";
    }
    public static int inputNumber(int min, int max){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        if( number< min || number>max ) return Integer.MAX_VALUE;
        return number;
    }
    
    
}
