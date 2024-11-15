/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tuan_10;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public interface ITaiKhoan {
    void guiTien(double tienGui);
    void rutTien(double tienRut,Scanner scanner);
    double soDu();
    void bienLai(String tinhTrang,double soTien);
}
