/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập một số nguyên dương:");
        int n=scanner.nextInt();
        if(n<0)
            System.out.println("Số vừa nhập không phải là số nguyên dương");
        else{
            int giaiThua=1;
            for(int i=1;i<=n;i++){
                giaiThua*=i;
            }
             System.out.println("giai thua là:"+giaiThua);   
            
        }
    }
}
