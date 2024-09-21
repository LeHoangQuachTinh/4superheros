/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan3;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author 123
 */
public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhap vao he so a:");
        double a = scanner.nextDouble();
        System.out.println("Nhap vao he so b:");
        double b = scanner.nextDouble();
        System.out.println("Nhap vao he so c:");
        double c = scanner.nextDouble();
        
        if(a==0){
            System.out.println("Day khong phai la phuong trinh bac hai!");
        }
        else 
        {
            double delta= b*b -4*a*c;
            if(delta >0){
             double x1 = (-b + Math.sqrt(delta)) / (2 * a);
             double x2 = (-b - Math.sqrt(delta)) / (2 * a);
             System.out.println("Phuong trinh co hai nghiem phan biet:");
             System.out.println("x1:"+x1);
             System.out.println("x2:"+x2);
            }
            else
                if(delta==0){
                    double x=-b/(2*a);
                    System.out.println("Phuong trinh co nghiem kep la:" +x);
                }
                else
                    System.out.println("Phuong trinh vo nghiem");
        }
     }
}
