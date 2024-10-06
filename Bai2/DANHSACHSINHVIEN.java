/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai02_tuan06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DELL
 */
public class DANHSACHSINHVIEN {
    private ArrayList<SINHVIEN> listSV;

    public DANHSACHSINHVIEN(ArrayList<SINHVIEN> listSV) {
        super();
        this.listSV = listSV;
    }
    public DANHSACHSINHVIEN() {
        this.listSV = new ArrayList<SINHVIEN>();
    }
    
    //Thêm sinh viên vào danh sách
    public void themSV(SINHVIEN sv){
        this.listSV.add(sv);
    }
     //In danh sách sinh viên
    public void in(){
        for(SINHVIEN sinhVien : listSV)
        {
            System.out.println(sinhVien);
        }
    }
    
    //Sap xep diem sinh vien
    public void sapXep(){
        //Collections là phương thức dùng để sắp xeeso các phần tử trong một List
        Collections.sort(this.listSV, new Comparator<SINHVIEN>() { //Comparator dùng để xác định cách thức so sánh các đối tượng SINHVIEN trong danh sách dựa trên điểm trung bình.
            @Override
            public int compare(SINHVIEN sv1, SINHVIEN sv2) {
                if(sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh())
                    return -1;
                else if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh())
                    return 1;
                else 
                    return 0;
                //Java quy định sẵn 
                //trả về giá trị dương tức là sv1 đứng sau sv2
                //trả về giá trị âm tức là sv1 đứng trước sv2
                //trả về 0 tức là không đổi
                
            }
        });
    }
}
