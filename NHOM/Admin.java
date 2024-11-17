package NHOM;

import java.util.HashMap;

class Admin {
   ListRestaurant listRestaurant;
   ListCustomer listCustomer;
   Admin()
   {
     this.listCustomer=new ListCustomer();
     this.listRestaurant=new ListRestaurant();
   }
}
