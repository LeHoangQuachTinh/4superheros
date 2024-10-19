package NGANHANG;

import java.util.ArrayList;
import java.util.List;

public class DANHSACHTAIKHOAN {
    private List<TAIKHOAN> danhsachTK;
     
    //Constructor

    public DANHSACHTAIKHOAN() {
        this.danhsachTK = new ArrayList<>();
    }
    
    public void themTK(TAIKHOAN tk){
        danhsachTK.add(tk);
    }
    
    public void inDanhSach(){
        if(danhsachTK.isEmpty())
            System.out.println("Danh sach tài khoan trong!");
        else
        {
            System.out.println("Danh sach tai khoan: ");
            for(TAIKHOAN tk : danhsachTK)
                tk.inTK();
        }  
    }
    
     public TAIKHOAN timTaiKhoan(String soTaiKhoan) {
        for (TAIKHOAN tk : danhsachTK) {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return tk; // Trả về tài khoản nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}
