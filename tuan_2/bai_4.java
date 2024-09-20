/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap vao so tien gui:");
        double tienGui = scanner.nextDouble();
        System.out.print("nhap lai suat hang nam: ");
        double laiSuat = scanner.nextDouble();
        System.out.print("nhap so thang gui: ");
        int thang = scanner.nextInt();
        double tongTienLai = tienGui * (laiSuat / 12 / 100)* thang;
        double tongTien = tienGui + tongTienLai;
        System.out.println("so tien lai sau " + thang + " thang: " + tongTienLai);
        System.out.println("tong tien: " + tongTien);
        
    }
}
