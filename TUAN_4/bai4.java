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
public class bai4 {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số:");
        n=scanner.nextInt();
        if (n < 2) {
            System.out.println(n + " không phải là số nguyên tố.");
        } 
        else {
            boolean laSoNguyenTo = true;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    laSoNguyenTo = false;
                    break;
                }
            }

            if (laSoNguyenTo) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }
        }
    }
}
