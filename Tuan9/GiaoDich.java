/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nganhang;

/**
 *
 * @author 123
 */
public class GiaoDich 
{
    private String loaiGiaoDich;
    private double soTien;
    private double soDuSauGiaoDich;

    public GiaoDich(String loaiGiaoDich, double soTien, double soDuSauGiaoDich) 
    {
        this.loaiGiaoDich = loaiGiaoDich;
        this.soTien = soTien;
        this.soDuSauGiaoDich = soDuSauGiaoDich;
    }

    @Override
    public String toString() 
    {
        return "Loai: " + loaiGiaoDich + ", So tien: " + soTien + ", So du sau giao dich: " + soDuSauGiaoDich;
    }
}
