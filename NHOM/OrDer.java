/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHOM;

/**
 *
 * @author Admin
 */
public class OrDer {
    private String id;
    private String sanPham;
    private int soLuong;
    private String trangThai="Chờ xử lý";

    public OrDer(String id, String sanPham, int soLuong) {
        this.id = id;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    

    public String getId() {
        return id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Tên sản phẩm: " + sanPham + ", Số lượng: " + soLuong + ", Trạng thái: " + trangThai;
    }
}
