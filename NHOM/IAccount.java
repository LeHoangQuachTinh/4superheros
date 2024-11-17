package order_online;
interface IAccount {
    void register();
    boolean login(String id, String password);
    void resetPassword();
}