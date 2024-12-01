package BT;

import java.util.Scanner;

import BT.NganHang.DSTaiKhoang;

public interface IListAccount {
    final DSTaiKhoang DS=new DSTaiKhoang();
    Scanner sc=new Scanner(System.in);
    void registerAccount();
    boolean login();
    void editAccount(String id);
    void forgotPassWord();
    void lockAccount(String matk);
    void deleteAccount();
} 
