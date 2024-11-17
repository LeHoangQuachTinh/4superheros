package NHOM;

import java.util.Scanner;

interface IAccount {
    void register(Scanner scanner,DSTaiKhoan dstk);
    boolean login(Scanner scanner ,DSTaiKhoan dstk);
    void resetPassword(Scanner scanner);
}