class Restaurant extends Account implements IRestaurant {


    public Restaurant(String code,String username, String password, String SDT,String diachi) {
        super(code,username, password, SDT,diachi);

    }

    @Override
    public void register() {
        System.out.println("Registering restaurant...");
    }

    @Override
    public void addDish() {
        System.out.println("Adding a new dish to the menu...");
    }

    @Override
    public void updateDish() {
        System.out.println("Updating a dish in the menu...");
    }

    @Override
    public void deleteDish() {
        System.out.println("Deleting a dish from the menu...");
    }

    public void viewRevenue() {
        System.out.println("Viewing restaurant revenue...");
    }
}