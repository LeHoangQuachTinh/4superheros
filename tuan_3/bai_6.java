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
public class bai_6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập lần lượt 2 só:");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println("Các phép tính:");
        System.out.println("1.Cộng '+'");
        System.out.println("2.Trừ '-'");
        System.out.println("3.Chia '/'");
        System.out.println("4. Nhân '*'");
        System.out.println("Chọn phép toán:");
        int lc=scanner.nextInt();
        switch(lc){
            case 1:System.out.println("Tổng của 2 số là:"+(a+b));break;
            case 2:System.out.println("Hiệu của 2 số là:"+(a-b));break;
            case 3:System.out.println("Thương của 2 số là:"+(a/b));break;
            case 4:System.out.println("Tích của 2 số là:"+(a*b));break;
            default:System.out.println("Lựa chọn không hợp lệ");
        }
            
    }
}
