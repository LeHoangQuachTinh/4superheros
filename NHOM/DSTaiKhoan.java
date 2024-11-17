/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHOM;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class DSTaiKhoan {
    private HashMap<String,Account> DSTKND;

    public DSTaiKhoan() {
        DSTKND=new HashMap<>();
    }

    public  Account kiemTraTonTai(String code){
        return DSTKND.get(code);
    }
}
