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
public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập vào điểm trung bình:");
        double dtb=scanner.nextDouble();
        if(dtb>=8)
            System.out.println("Đạt loại giỏi");
        else
            if(dtb>=6.5)
                System.out.println("Đạt loại khá");
            else
                if(dtb>=5)
                    System.out.println("Đạt loại trung bình");
                else
                    System.out.println("Đạt loại yếu");
        scanner.close();
    }
}
