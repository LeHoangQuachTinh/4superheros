/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        double so1 = scanner.nextDouble();
        System.out.print("Nhập số thứ hai: ");
        double so2 = scanner.nextDouble();

        System.out.println("Chọn phép tính:");
        System.out.println("1. Cộng");
        System.out.println("2. Trừ");
        System.out.println("3. Nhân");
        System.out.println("4. Chia");
        System.out.print("Lựa chọn của bạn: ");
        int luaChon = scanner.nextInt();

        switch (luaChon) {
            case 1:
                System.out.println("Kết quả: " + (so1 + so2));
                break;
            case 2:
                System.out.println("Kết quả: " + (so1 - so2));
                break;
            case 3:
                System.out.println("Kết quả: " + (so1 * so2));
                break;
            case 4:
                if (so2 != 0) {
                    System.out.println("Kết quả: " + (so1 / so2));
                } else {
                    System.out.println("Không thể chia cho 0.");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
}
