/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinhchunhat_tuan6;

/**
 *
 * @author DELL
 */
public class MAIN {
    public static void main(String[] args) {
        HINHCHUNHAT hcn1 = new HINHCHUNHAT(3,2);
        hcn1.inKetQua();
        HINHCHUNHAT hcn2 = new HINHCHUNHAT();
        hcn2.Nhap();
        hcn2.inKetQua();
        HINHCHUNHAT hcn3 = new HINHCHUNHAT();
        hcn3.setCd(5);
        hcn3.getCd();
        hcn3.setCr(6);
        hcn3.getCd();
        hcn3.inKetQua();
    }
}
