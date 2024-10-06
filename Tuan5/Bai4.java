/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan5_1;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author 123
 */
public class Bai4 {

    public static void main(String[] args) {
        int[] mang = {1, 3, 2, 1, 4, 1, 3, 4, 2, 4, 4};
        int ptuNhieuNhat = timPtuNhieuNhat(mang);

        System.out.println("Phan tu xuat hien nhieu nhat: " + ptuNhieuNhat);
    }
    public static int timPtuNhieuNhat(int[] mang) {
        HashMap<Integer, Integer> tanSuat = new HashMap<>();

        for (int so : mang) {
            tanSuat.put(so, tanSuat.getOrDefault(so, 0) + 1);
        }

        int ptuNhieuNhat = mang[0];
        int maxDem = 0;

        for (Map.Entry<Integer, Integer> muc : tanSuat.entrySet()) {
            if (muc.getValue() > maxDem) {
                ptuNhieuNhat = muc.getKey();
                maxDem = muc.getValue();
            }
        }
        return ptuNhieuNhat;
    }
}

