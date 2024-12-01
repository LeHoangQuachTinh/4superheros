package BT;
import java.util.HashMap;



public class ListShipper implements IListAccount{

    private HashMap<String,Shipper> listShipper;


 
    ListShipper(){
       this.listShipper=new HashMap<>();
    }
    public HashMap<String, Shipper> getListShipper() {
        return listShipper;
    }
    @Override
    public void deleteAccount() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void editAccount(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void forgotPassWord() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lockAccount(String matk) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean login() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void registerAccount() {
        // TODO Auto-generated method stub
        
    }
    
}
