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
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so a:");
        int a= scanner.nextInt();
        System.out.println("Nhap vao so b:");
        int b= scanner.nextInt();
        System.out.println("Nhap vao so c:");
        int c= scanner.nextInt();
        
        int min=a;
        if(b<min){
            min=b;
        }
        if(c<min){
            min=c;
        }
        System.out.println("So nho nhat trong ba so la:" +min);
    }
}
