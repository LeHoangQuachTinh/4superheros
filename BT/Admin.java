 package BT;


class Admin {
   public ListRestaurant listRestaurant;
   public ListCustomer listCustomer;
   private String maQuanTri;
 
    Admin()
   {
     this.listCustomer=new ListCustomer();
     this.listRestaurant=new ListRestaurant();
     this.maQuanTri="anhem";
   }
   public String getMaQuanTri() {
    return maQuanTri;
    }
    public void setMaQuanTri(String maQuanTri) {
        this.maQuanTri = maQuanTri;
    }
}
