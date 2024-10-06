/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Bai5 
{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Nhập số lượng phần tử của danh sách
            System.out.print("Nhập số lượng phần tử: ");
            int n = scanner.nextInt();
    
            // Tạo một danh sách rỗng để lưu trữ các số nguyên
            ArrayList<Integer> danhSach = new ArrayList<>();
    
            // Nhập các phần tử vào danh sách
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
                int so = scanner.nextInt();
                danhSach.add(so);
            }
    
            // In danh sách ra màn hình
            System.out.println("Danh sách các số nguyên: " + danhSach);
        }
}
