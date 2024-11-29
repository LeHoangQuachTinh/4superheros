// package BT;
public class Shipper extends Account {
    private boolean trangThai;
    private String loaiXe;

    Shipper(String idUser,String username, String password, String SDT,String diachi)
    {
        super(idUser,username,password,SDT,diachi);
        this.trangThai=false;
    }

    public void batTrangThai(){
        this.trangThai=true;
    }
    public void tatTrangThai(){
        this.trangThai=false;
    }
    @Override
    public lockAccount(){
        this.isLocked=true;
    }
    
}
