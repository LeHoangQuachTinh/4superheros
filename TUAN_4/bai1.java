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
public class bai1 {
    public static void main(String[] args) {
        int n;
        int tg = 0;
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập n:");
        n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            tg+=i;
        }
        System.out.println("tổng là:"+tg);
    }
}
