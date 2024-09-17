/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan2;

/**
 *
 * @author 123
 */
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số tiền gửi, lãi suất hàng năm và số tháng gửi
        System.out.print("Nhap so tien gui (VND): ");
        double tiengui = scanner.nextDouble();
        System.out.print("Nhap lai suat hang nam (%): ");
        double laisuat = scanner.nextDouble();
        System.out.print("Nhap so thang gui: ");
        int thang = scanner.nextInt();

        // Tính lãi suất
        double laisuathangthang = laisuat / 12 / 100;
        double sotienlai = tiengui * laisuathangthang * thang;

        // Tính số tiền cuối kỳ (gốc + lãi)
        double sotiencuoiky = tiengui + sotienlai;

        // In kết quả ra màn hình
        System.out.println("So tien lai: " + sotienlai + " VND");
        System.out.println("So tien cuoi ky (goc + lai): " + sotiencuoiky + " VND");
    }
}

