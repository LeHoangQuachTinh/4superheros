/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package order_online;

public class Account {
    protected String id;
    protected String tenNhaHang;
    protected String password;
    protected String SDT;
    protected String diachi;

    public Account(String id, String tenNhaHang, String password, String SDT, String diachi) {
        this.id = id;
        this.tenNhaHang = tenNhaHang;
        this.password = password;
        this.SDT = SDT;
        this.diachi = diachi;
    }

    public String getPassword() {
        return password;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getId() {
        return id;
    }

    public String getTenNhaHang() {
        return tenNhaHang;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }
}
