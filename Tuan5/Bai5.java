/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan5_1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 123
 */
public class Bai5 {
    public static void main(String[] args) {
        List<Integer> danhSach = new ArrayList<>();

        // Thêm các phần tử vào danh sách
        danhSach.add(5);
        danhSach.add(15);
        danhSach.add(25);
        danhSach.add(35);
        danhSach.add(45);
        System.out.println("Cac phan tu trong danh sach:");
        for (Integer so : danhSach) {
            System.out.println(so);
        }
    }
}

