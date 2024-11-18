package NHOM;

import java.util.HashMap;

class Admin {
   public ListRestaurant listRestaurant;
   public ListCustomer listCustomer;
   Admin()
   {
     this.listCustomer=new ListCustomer();
     this.listRestaurant=new ListRestaurant();
   }
}
