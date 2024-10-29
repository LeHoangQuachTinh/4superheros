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
public class bai_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap vao ten:");
        String ten=scanner.nextLine();
        System.out.print("nhap vao so tuoi:");
        int tuoi=scanner.nextInt();
        System.out.print("nhap vao chieu cao:");
        double chieuCao=scanner.nextDouble();
        System.out.print("co thich lap trinh khong:");
        boolean nhanXet=scanner.nextBoolean();
        System.out.println("so tuoi la:"+tuoi);
        System.out.println("chieu cao la:"+chieuCao);
        System.out.println("ten la:"+ten);
        System.out.println("nhan xet:"+nhanXet);
        
    }
}
