 package BT;
public interface IListAccount {
    void registerAccount();
    boolean login();
    void editAccount();
    void forgotPassWord();
    void lockAccount(String matk);
    void deleteAccount();
} 
