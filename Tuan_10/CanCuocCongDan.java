/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class CanCuocCongDan {
    private String soCanCuocCongDan;
    private String ten;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String danToc;
    private String quocTich;

    public CanCuocCongDan() {
    }

    public CanCuocCongDan(String soCanCuocCongDan, String ten, LocalDate ngaySinh, String gioiTinh, String queQuan, String danToc, String quocTich) {
        this.soCanCuocCongDan = soCanCuocCongDan;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.quocTich = quocTich;
    }

    

    @Override
    public String toString() {
         return "Căn cước công dân: " + soCanCuocCongDan + " || Họ và tên: " + ten + " || Ngày sinh: " + ngaySinh + 
           " || Giới tính: " + gioiTinh + " || Quê quán: " + queQuan + " || Dân tộc: " + danToc + 
           " || Quốc tịch: " + quocTich;
    }
    
    
}
