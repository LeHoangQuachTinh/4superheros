/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_6.BAI1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double chieuDai = scanner.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double chieuRong = scanner.nextDouble();

        HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);

        double dienTich = hinhChuNhat.tinhDienTich();
        double chuVi = hinhChuNhat.tinhChuVi();

        System.out.println("Diện tích hình chữ nhật: " + dienTich);
        System.out.println("Chu vi hình chữ nhật: " + chuVi);
    }
}
