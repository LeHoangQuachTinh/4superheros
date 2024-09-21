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
public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so can kiem tra:");
        int n= scanner.nextInt();
        if(n>0)
            System.out.println("La so duong");
        else 
            if(n<0)
                System.out.println("La so am");
            else
                System.out.println("Bang 0");
    }
}
