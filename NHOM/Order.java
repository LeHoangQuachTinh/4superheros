package NHOM;

import java.util.List;

public class Order {
    private String orderID;
    private List<Dish> dishes;

    public Order(String orderID, List<Dish> dishes) {
        this.orderID = orderID;
        this.dishes = dishes;
    }
    
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    // Tính tổng giá trị đơn hàng
    public double getTotalPrice() {
        double tongTien = 0.0;
        for (Dish dish : dishes) {
            tongTien += dish.getTotalPrice();
        }
        return tongTien;
    }

    @Override
    public String toString() {
        String orderDetails = "---------------------------------------------------------------------------\n";
        orderDetails += "| Món ăn                        | Giá (VND)            | Số lượng               |\n";
        orderDetails += "--------------------------------------------------------------------------\n";
        
        // Duyệt qua danh sách các món ăn trong đơn hàng
        for (Dish dish : dishes) {
            orderDetails += String.format("| %-27s | %-21s | %-21s |\n", 
                                           dish.getNameDish(), 
                                           String.format("%,d", dish.getPrice()), 
                                           dish.getQuality());
        }
        
        orderDetails += "--------------------------------------------------------------------------\n";
        orderDetails += String.format("| %-27s | %-21s | %-21s |\n", "Tổng tiền", "", String.format("%,d", getTotalPrice()));
        orderDetails += "--------------------------------------------------------------------------\n";
        
        return orderDetails;
    }
    
    
}
