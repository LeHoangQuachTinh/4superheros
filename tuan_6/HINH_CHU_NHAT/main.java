/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_6.HINH_CHU_NHAT;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        hinhchunhat hcn = new hinhchunhat();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập chiều dài và chiều rộng:");
        double chieuDai = sc.nextInt();
        double chieuRong =sc.nextInt();
        hcn.setChieuDai(chieuDai);
        hcn.setChieuRong(chieuRong);
        hcn.in();
        
    }
}
