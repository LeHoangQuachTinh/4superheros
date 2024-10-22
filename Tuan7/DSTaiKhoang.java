package Tuan7;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class DSTaiKhoang{
    List<NganHang> DS=new ArrayList<>();
    /*Có thể tạo HashList để dễ quản lí hơn vì (stk,NganHang) 
    có thể truy xuất nhanh thông qua đối số thứ 1 của HashList mà không cần tạo hàm searchAccounts --tỉnh ghi chú*/
    DSTaiKhoang()
    {

    }
    public void addAcount(NganHang account)
    {
        this.DS.add(account);
    }
    public List<NganHang> searchAccounts(String stk) {
        return this.DS.stream().filter(o -> o.getStk().contains(stk)).collect(Collectors.toList());
    }
    public void showAccount(){
       this.DS.forEach(o->o.display());
    }
}