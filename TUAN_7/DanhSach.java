/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class DanhSach {
    private HashMap<String, TaiKhoan> dsTaiKhoan;
    private HashMap<String, TaiKhoan> dsThanhToan;
    private HashMap<String, TaiKhoan> dsTietKiem;
    private HashMap<String, List<LocalDateTime>> dsLichSu;
    

    public DanhSach() {
        dsTaiKhoan=new HashMap<>();
        dsThanhToan=new HashMap<>();
        dsTietKiem=new HashMap<>();
        dsLichSu=new HashMap<>();
    }
    
     public void themTaiKhoanThanhToan(String soTaiKhoan, TaiKhoan tk) {
        dsThanhToan.put(soTaiKhoan, tk);
        dsTaiKhoan.put(soTaiKhoan, tk); 
    }

    public void themTaiKhoanTietKiem(String soTaiKhoan, TaiKhoan tk) {
        dsTietKiem.put(soTaiKhoan, tk);
        dsTaiKhoan.put(soTaiKhoan, tk);
    }
    
    public TaiKhoan kiemTraTonTai(String soTaiKhoan){
        return dsTaiKhoan.get(soTaiKhoan);
    }
    
//     public void ghiLichSuGiaoDich(String soTaiKhoan) {
//        dsLichSu.putIfAbsent(soTaiKhoan, new ArrayList<>());
//        dsLichSu.get(soTaiKhoan).add(LocalDateTime.now());
//    }
    
         public void ghiLichSuGiaoDich(TaiKhoan tk) {
             tk.themgiaodich(String.valueOf(LocalDateTime.now()));
    }
    

    public void hienThiLichSu(TaiKhoan tk) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            System.out.println("Chủ tài khoản: " + tk.getChuTaiKhoan());
            for (String tg : tk.getLsgd()) {
                System.out.println("   +Thời gian giao dịch: " + tg);
            }
        
    }
}
