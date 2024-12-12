/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double tienGui;
        double laiXuat;
        int thangGui;
        System.out.print("Nhập số tiền gửi:");
        tienGui=scanner.nextDouble();
        System.out.print("Nhập lãi xuất:");
        laiXuat=scanner.nextDouble();
        System.out.print("Nhập số tháng gửi:");
        thangGui=scanner.nextInt();
        double tienLai=tienGui*(laiXuat/100)*(thangGui/12);
        System.out.println("Tiền lãi:"+tienLai);
    }
}
