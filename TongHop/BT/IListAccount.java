package BT;

import java.util.Scanner;

import BT.NganHang.DSTaiKhoang;

public interface IListAccount {
    final static DSTaiKhoang DS=new DSTaiKhoang();
    Scanner sc=new Scanner(System.in);
    
    void registerAccount();
    boolean login(String id,String password);
    void forgotPassWord();
    void deleteAccount();
} 
