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
public class bai2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String ten;
        int tuoi;
        double chieuCao;
        boolean coThichLapTrinhKhong;
        System.out.print("Nhập tên:");
        ten=scanner.nextLine();
        System.out.print("Nhập tuổi:");
        tuoi=scanner.nextInt();
        System.out.print("Nhập chiều cao:");
        chieuCao=scanner.nextDouble();
        System.out.print("Bạn có thích lập trình không(true/false):");
        coThichLapTrinhKhong=scanner.nextBoolean();
        System.out.println("\nThông tin bạn vừa nhập:");
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Chiều cao: " + chieuCao);
        System.out.println("Có thích lập trình không: " + (coThichLapTrinhKhong ? "Có" : "Không"));
    }
}
