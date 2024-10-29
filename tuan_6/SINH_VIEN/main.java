/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_6.SINH_VIEN;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        List<sinh_vien> ds = new ArrayList<>();
        sinh_vien sv1 = new sinh_vien();
        sv1.nhap();
        sinh_vien sv2 = new sinh_vien();
        sv2.nhap();
        ds.add(sv1);
        ds.add(sv2);
        for(sinh_vien sv:ds)
            sv.in();
    }
}
