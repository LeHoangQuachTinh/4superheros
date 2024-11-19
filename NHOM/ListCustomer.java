package NHOM;
import java.util.HashMap;

public class ListCustomer implements IListAccount{
    HashMap<String,Customer> listCustomer;

    ListCustomer(){
        this.listCustomer=new HashMap<>();
    }

    @Override
    public void editAccount() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void forgotPassWord() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lockAccount() {
        // TODO Auto-generated method stub
        
    }

//    @Override
//    public boolean login() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public void registerAccount() {
//        
//    }
    
    //Kiểm tra tồn tại IdUser trong danh sách
    public Customer kiemTraTonTai(String idUser){
        return listCustomer.get(idUser);
    }

    @Override
    public void registerAccount(ListCustomer dstk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean login(String idUser, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resetPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
