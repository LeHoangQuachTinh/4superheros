/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan4;

import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao bao nhieu so");
        int n = scanner.nextInt();
        int Tong =0;
        for(int i=0;i<=n;i++){
            Tong = Tong + i;
        }
        System.out.println("Tong day so la:" +Tong);
    }
}
