/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập vào một số nguyên:");
        int a=scanner.nextInt();
        if(a>0)
            System.out.println(a +" là số dương");
        else
            if(a<0)
                System.out.println(a+" là số âm");
            else
                System.out.println(a+" là số 0");
        scanner.close();
    }
}
