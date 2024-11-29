package BT;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private String orderID;
    private List<Dish> dishes;
    private String status;
    private LocalDateTime time;

    public Order(String orderID, List<Dish> dishes) {
        this.orderID = orderID;
        this.dishes = dishes;
        this.status = "Đang giao";
        this.time = LocalDateTime.now();
    }


    // Tính tổng giá trị đơn hàng
    public double getTotalPrice() {
        double tongTien = 0.0;
        for (Dish dish : dishes) {
            tongTien += dish.getTotalPrice();
        }
        return tongTien;
    }
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    public List<Dish> getDishes() {
        return dishes;
    }

    public void chiTietDonHang() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        System.out.printf("\nMã đơn hàng: %s\n",this.orderID);
        System.out.printf("Trạng thái đơn hàng: %s\n",this.status);
        System.out.printf("Thời gian đặt: %s\n",this.time.format(formatter).toString());

        double tongTien=0;
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n", "Món ăn", "Số lượng","Giá (VND)");
        System.out.println("---------------------------------------------------------------------------");
    
        for (Dish dish : dishes) {
            tongTien+=dish.getQuality()*dish.getPrice();
            System.out.printf("| %-27s | %-21d | %-21s |\n",
                    dish.getNameDish(),
                    dish.getQuality(),
                    Double.toString(tongTien)
            );
        }
    
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n", 
                "Tổng tiền",
                " ", 
                Double.toString(tongTien)); // Gọi phương thức tính tổng tiền
        System.out.println("---------------------------------------------------------------------------\n");
    }
    
    
    
}
