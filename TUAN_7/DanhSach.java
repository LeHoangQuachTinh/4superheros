/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class DanhSach {
    private HashMap<String,TaiKhoan> dsTaiKhoan;

    public DanhSach() {
        dsTaiKhoan=new HashMap<>();
    }
    
    public void themTaiKhoan(String soTaiKhoan,TaiKhoan tk){
        dsTaiKhoan.put(soTaiKhoan,tk);
    }
    
    public TaiKhoan kiemTraTonTai(String soTaiKhoan){
        return dsTaiKhoan.get(soTaiKhoan);
    }
}
