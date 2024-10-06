/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan3;

import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhap vao canh thu nhat:");
        double a = scanner.nextDouble();
        System.out.println("Nhap vao canh thu hai:");
        double b = scanner.nextDouble();
        System.out.println("Nhap vao canh thu ba:");
        double c = scanner.nextDouble();
        
        //kiem tra tam giac
        if(a+b>c && a+c>b && b+c>a){
            System.out.println("La mot tam giac");
        //kiem tra la tam giac gi
           if(a==b && a==c && b==c){
                System.out.println("La tam giac deu");
            }
            else
                if(a==b|| a==c|| b==c){
                    System.out.println("La tam giac can");
                }
                else
                    if(Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2) ||
                        Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2) ||
                        Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)){
                        System.out.println("La tam giac vuong");
                    }
                    else
                        System.out.println("La tam giac thuong");
        }
        else 
            System.out.println("Ba canh khong tao thanh tam giac");
    }
}
