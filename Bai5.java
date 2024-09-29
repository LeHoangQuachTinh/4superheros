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
public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen thu nhat:");
        int a = scanner.nextInt();
        System.out.print("Nhap vao so nguyen thu hai:");
        int b = scanner.nextInt();
        
        int ucln =UCLN(a,b);
        int bcnn = BCNN(a,b,ucln);
        System.out.println("Uoc chung lon nhat cua " +a+ " va " +b+ " la: " +ucln);
        System.out.println("Boi chung nho nhat cua " +a+ " va " +b+ " la: " +bcnn);
    }
    // Hàm tìm UCLN sử dụng thuật toán oclid
    public static int UCLN(int a, int b) {
        while (b != 0) {
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }
    // Hàm tìm BCNN dựa trên công thức: BCNN(a, b) = (a * b) / UCLN(a, b)
    public static int BCNN(int a, int b, int c) {
        return (a * b) / c;
    }
}
