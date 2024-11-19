/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.List;

public class Order {
    private String orderID;
    private List<Dish> dishes;


    public Order(String orderID, List<Dish> dishes) {
        this.orderID = orderID;
        this.dishes = dishes;
    }


    // Tính tổng giá trị đơn hàng
    public double getTotalPrice() {
        double tongTien = 0.0;
        for (Dish dish : dishes) {
            tongTien += dish.getTotalPrice();
        }
        return tongTien;
    }
    
    public List<Dish> getDishes() {
        return dishes;
    }

    public void chiTietDonHang() {
        int tongTien=0;
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n", "Món ăn", "Giá (VND)", "Số lượng");
        System.out.println("---------------------------------------------------------------------------");
    
        // Duyệt qua các món ăn trong giỏ hàng (HashMap)
        for (Dish dish : dishes) {
            tongTien+=dish.getQuality()*dish.getPrice();
            System.out.printf("| %-27s | %-21s | %-21d |\n",
                    dish.getNameDish(),
                    String.format("%,.0f", dish.getPrice()), // Hiển thị giá với định dạng phân cách hàng nghìn
                    dish.getQuality());
        }
    
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n", 
                "Tổng tiền", 
                "", 
                String.format("%,.0f", tongTien)); // Gọi phương thức tính tổng tiền
        System.out.println("---------------------------------------------------------------------------");
    }
    
    
    
}
