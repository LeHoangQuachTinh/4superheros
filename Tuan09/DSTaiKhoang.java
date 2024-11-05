package nganhang;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class DSTaiKhoang {
       Hashtable<String, NganHang> DS = new Hashtable<>();

    DSTaiKhoang() {

    }

    public void addAcount(NganHang account) {
        // this.DS.add(account);
        this.DS.put(account.getStk(), account); // Thêm tài khoản vào Hashtable
    }

    // public List<NganHang> searchAccounts(String stk) {
    //     return this.DS.stream().filter(o -> o.getStk().contains(stk)).collect(Collectors.toList());
    // }

    public void showAccount() {
        this.DS.values().forEach(o -> o.display());
        
    }
    public boolean kiemTraTrung(String stk, String tentk) {
        if (DS.containsKey(stk)) {
            System.out.println("Số tài khoản đã tồn tại!");
            return true;
        }
        for (NganHang account : DS.values()) {
            if (account.chutk.equalsIgnoreCase(tentk)) {
                return true;
            }
        }
        return false;
    }

    public NganHang searchAcount(String stk) {
        return this.DS.get(stk);
    }

    public void showThanhToanAccounts() {
        boolean hasAccounts = false;

        for (NganHang tk : this.DS.values()) {
            if ("Tai khoan thanh toan".equals(tk.getType())) 
            {
                tk.display();
                hasAccounts = true;
            }
        }

        if (!hasAccounts) {
            System.out.println("Danh sach tai khoan thanh toan rong.");
        }
    }
    public void showTietKiemAccounts() {
        boolean hasAccounts = false;

        for (NganHang tk : this.DS.values()) {
            if ("Tai khoan tiet kiem".equals(tk.getType())) 
            {
                tk.display();
                hasAccounts = true;
            }
        }

        if (!hasAccounts) {
            System.out.println("Danh sach tiet kiem rong.");
        }
    }
}
