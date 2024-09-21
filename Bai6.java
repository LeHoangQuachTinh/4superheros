/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan3;

import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so thu nhat:");
        double a = scanner.nextDouble();
        System.out.println("Nhap vao so thu hai:");
        double b = scanner.nextDouble();
        
        System.out.println("Chon phep tinh:");
        System.out.println("1.Cong");
        System.out.println("2.Tru:");
        System.out.println("3.Nhan:");
        System.out.println("4.Chia:");
        
        System.out.println("Lua chon phep tinh cua ban la:");
        int chon = scanner.nextInt();
        double ketqua;
        switch(chon){
            case 1: ketqua = a+b;
            System.out.println("Ket qua cua phep cong la:" +ketqua);
            break;
            case 2: ketqua = a-b;
            System.out.println("Ket qua cua phep tru la:" +ketqua);
            break;
            case 3: ketqua = a*b;
            System.out.println("Ket qua cua phep nhan la:" + ketqua);
            break;
            case 4: 
                if(b!=0){
                    ketqua = a/b;
                    System.out.println("Ket qua cua phep chia la:" +ketqua);
                }
                else 
                    System.out.println("Khong the dung phep chia");
            break;    
            default:    
                System.out.println("Lua chon khong hop le");
     }
    }
}
