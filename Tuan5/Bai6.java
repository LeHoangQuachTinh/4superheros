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
public class Bai6 {
    public static void main(String[] args) {
        List<Integer> danhSach = new ArrayList<>();
        danhSach.add(10);
        danhSach.add(20);
        danhSach.add(30);
        danhSach.add(40);
        System.out.println("Danh sach ban đau: " + danhSach);
     
        int viTriThem = 2; 
        int giaTriThem = 25;
        danhSach.add(viTriThem, giaTriThem);
        System.out.println("Danh sach sau khi them phan tu " + giaTriThem + " tai vi tri " + viTriThem + ": " + danhSach);
        
        int viTriXoa = 3;
        int giaTriXoa = danhSach.remove(viTriXoa);
        System.out.println("Danh sach sau khi xoa phan tu tai vi tri " + viTriXoa + ": " + danhSach);
    }
}

