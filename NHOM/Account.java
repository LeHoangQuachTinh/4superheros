abstract class Account implements IAccount {
    protected String code;
    protected String username;
    protected String password;
    protected String SDT;
    protected String diachi;

    public Account(String code,String username, String password, String SDT,String diachi) {
        this.username = username;
        this.password = password;
        this.SDT = SDT;
        this.diachi=diachi;
    }

    @Override
    public void login() {
        System.out.println("Logging in as " + username);
    }

    @Override
    public void resetPassword() {
        System.out.println("Resetting password for " + username);
    }
}

