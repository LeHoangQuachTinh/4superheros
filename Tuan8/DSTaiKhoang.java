package Tuan8;
import java.util.Hashtable;

class DSTaiKhoang {
    
    Hashtable<String, NganHang> DS = new Hashtable<>();

    DSTaiKhoang() {

    }
    public void addAcount(NganHang account) {
        this.DS.put(account.getStk(), account); 

    }

    public void showAccount() {
        this.DS.values().forEach(o -> o.display());
    }
    public boolean kiemTraTrung(String stk, String tentk) {
        if (DS.containsKey(stk)) 
        {
            System.out.println("\nSố tài khoản đã tồn tại!");
            return true;
        }
        
        for (NganHang account : DS.values()) 
        {
            if (account.chutk.equalsIgnoreCase(tentk)) 
            {
                System.out.println("Tên tài khoản đã tồn tại!");
                return true;
            }
        }
        return false;
    }
    public NganHang searchAcount(String stk) {
        return this.DS.get(stk);
    }  
}
