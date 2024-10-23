package Tuan7;
import java.util.Hashtable;

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
    public boolean kiemTraTrung(String stk, String tentk) {
        if (DS.containsKey(stk)) {
            System.out.println("Số tài khoản đã tồn tại!");
            return true;
        }
        for (NganHang account : DS.values()) {
            if (account.chutk.equalsIgnoreCase(tentk)) {
                // System.out.println("Tên tài khoản đã tồn tại!");
                return true;
            }
        }
        return false;
    }

    public NganHang searchAcount(String stk) {
        return this.DS.get(stk);
    }

    
}
