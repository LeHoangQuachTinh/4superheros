package Tuan7;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

class DSTaiKhoang {
    // List<NganHang> DS = new ArrayList<>();
    
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

    public NganHang searchAcount(String stk) {
        return this.DS.get(stk);
    }

    
}
