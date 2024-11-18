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

    @Override
    public boolean login() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void registerAccount() {
        
    }
}
