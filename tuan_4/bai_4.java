/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_4 {
    public static int kiemtra(int n){
        if(n<2)
            return 0;
        else
            for(int i=2;i<=Math.sqrt(n);i++)
                if(n%i==0)
                    return 0;
        return 1;
    }
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào 1 số nguyên n:");
        int n=scanner.nextInt();
        if(kiemtra(n)==1)
            System.out.println("Số "+n+" là số nguyên tố");
        else
            System.out.println("Số "+n+" không phải là số nguyên tố");
    }
}
