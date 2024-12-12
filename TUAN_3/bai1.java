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
public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số: ");
        double so = scanner.nextDouble();
        if (so > 0) 
            System.out.println("Số " + so + " là số dương.");
        
        else 
            if (so < 0) 
                System.out.println("Số " + so + " là số âm.");           
            else 
                System.out.println("Số vừa nhập là 0.");
    }
}
