package NHOM;

import java.util.List;

 public interface IDish {
    void addDish(String tenMon, int soLuong,List<Dish> menu);
    void editDish(String tenMon, int soLuong);
    void deleteDish(String tenMon);
 } 
