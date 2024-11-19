package NHOM;
public interface IListAccount {
    void registerAccount(ListCustomer dstk);
    boolean login(String idUser, String password);
    void editAccount();
    void forgotPassWord();
    void lockAccount();
    void openAccount();
    void resetPassword();
} 
