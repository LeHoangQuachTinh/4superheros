/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan6;

/**
 *
 * @author 123
 */
public class TaiKhoan {
   private String soTaiKhoan;
   private String chuTaiKhoan;
   private double soDu;
   
   public TaiKhoan ( String soTaiKhoan ,String chuTaiKhoan, double soDu){
       this.soTaiKhoan=soTaiKhoan;
       this.chuTaiKhoan=chuTaiKhoan;
       this.soDu=soDu;
   }
   public String getsoTaiKhoan(){
       return soTaiKhoan;
   }
   public void setsoTaiKhoan(String soTaiKhoan){
       this.soTaiKhoan=soTaiKhoan;
   }
   public String getchuTaiKhoan(){
       return chuTaiKhoan;
   }
   public void setchuTaiKhoan(String chuTaiKhoan){
       this.chuTaiKhoan=chuTaiKhoan;
   }
   public double getSoDu() {
        return soDu;
    }
   public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
   
   public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Gui tien thanh cong. So du moi la: " + soDu);
        } else {
            System.out.println("So tien gui khong hop le.");
        }
    }
   
   public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong. So du moi la: " + soDu);
        } else {
            System.out.println("So tien rut khong hop le hoac vuot qua so du.");
        }
    }
   
   public void kiemTraSoDu() {
        System.out.println("So du hien tai la: " + soDu);
    }

}
