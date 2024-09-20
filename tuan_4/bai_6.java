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
public class bai_6 {
    public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên:");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a=n;
        int num=0;
        while(a!=0){
            int du=a%10;
            num=num*10+du;
            a/=10;
        }
        if(num==n)
            System.out.println(n+" là số đối xứng");
        else
            System.out.println(n+" không phải là số đối xứng");
    }
}
