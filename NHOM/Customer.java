class Customer extends Account implements ICustomer {
    public Customer(String code,String username, String password, String SDT,String diachi) {
        super(code,username, password, SDT,diachi);
    }

    @Override
    public void register() {
        System.out.println("Registering customer...");
    }

    @Override
    public void placeOrder() {
        System.out.println("Placing an order...");
    }

    @Override
    public void viewOrderStatus() {
        System.out.println("Viewing order status...");
    }
}