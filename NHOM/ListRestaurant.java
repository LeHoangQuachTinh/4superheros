package NHOM;

import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class ListRestaurant implements IListAccount{
    private Hashtable<String, Restaurant> listNhaHang = new Hashtable<>();

    //Phương thức đăng kí nhà hàng (giữ nguyên)
    public void registerAccount(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập mã nhà hàng");
        String idNhaHang = sc.nextLine();

        if(listNhaHang.contains(idNhaHang)){
            System.out.println("Mã nhà hàng đã được đăng kí. Xin vui lòng nhập lại!");
            return;
        }
        System.out.println("Nhập tên nhà hàng: ");
        String tenNhahang = sc.nextLine();

        System.out.println("Nhập chủ nhà hàng ");
        String chuNhaHang = sc.nextLine();

        System.out.println("Thiết lập mật khẩu: ");
        String password = sc.nextLine();

        System.out.println("Nhập số điện thoại nhà hàng: ");
        String sdt = sc.nextLine();

        System.out.println("Nhập địa chỉ nhà hàng: ");
        String diaChi = sc.nextLine();

        Restaurant newRestaurant = new Restaurant( password, sdt, diaChi, idNhaHang, tenNhahang);
        listNhaHang.put(idNhaHang, newRestaurant);
        System.out.println("Tao tai khoan nha hang thanh cong!");
    }
    
    public Restaurant search(String id){
        return listNhaHang.get(id);
    }

    @Override
    public void editAccount() {
        int choice;
        do {
            System.out.println("=====Cập nhật thông tin nhà hàng=====");
            System.out.println("""
                    1.Cập nhật tên nhà hàng
                    2.Cập nhật địa chỉ nhà hàng
                    3.Cập nhật số điện thoại nhà hàng
                    4.Thoát
                    """);
            
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1:
                //Đổi tên nhà hàng
                    System.out.println("Nhập tên nhà hàng mới: ");
                    String newRestaurant = sc.nextLine();
                    if(!newRestaurant.isEmpty()){
                        if(newRestaurant.equals(tenNhaHang)){
                            System.out.println("Tên nhà hàng mới trùng với tên nhà hàng cũ!. Không có thay đổi nào được thực hiện!");
                        }
                        else{
                            this.tenNhaHang=newRestaurant;
                        System.out.println("Tên nhà hàng đã được cập nhật: "+this.tenNhaHang);
                        }
                    }
                    else
                        System.out.println("Tên nhà hàng chưa được cập nhật.");
                break;
                case 2:
                //Đổi địa chỉ nhà hàng
                    System.out.println("Nhập địa chỉ mới của nhà hàng: ");
                    String newAdress = sc.nextLine();
                    if(!newAdress.isEmpty()){
                        if(newAdress.equals(diachi)){
                            System.out.println("Địa nhà hàng mới trùng với địa chỉ nhà hàng cũ!. Không có thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setDiachi(newAdress);
                            System.out.println("Địa chỉ đã cập nhật thành công: "+this.diachi);
                        }
                    }
                    else
                        System.out.println("Địa chỉ chưa được cập nhật");
                break;
                case 3:
                //Đổi số điện thoại
                    System.out.println("Nhập số điện thoại mới: ");
                    String newSdt = sc.nextLine();
                    if(!newSdt.isEmpty()){
                        if(newSdt.equals(sdt)){
                            System.out.println("Số điện thoại mới trùng với số điện thoại cũ! Không có sự thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setSDT(newSdt);
                            System.out.println("Số điện thoại đã được cập nhật: "+this.SDT);
                        }
                    }
                    else
                        System.out.println("Số điện thoại chưa được cập nhật");
                break;
                case 4:
                //Thoát chương trình
                    System.out.println("Thoát cập nhật!");
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 4);
    }

    @Override
    public void forgotPassWord() {
        System.out.println("Nhập số điện thoại đã đăng kí với tài khoản của bạn: ");
        String sdtNhap = sc.nextLine();
        if(!sdtNhap.equals(SDT)){
            System.out.println("Không tìm thấy số điện thoại!");
            return;
        }

        //Tạo mã OTP
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(999999);
        System.out.println("Mã OTP của bạn là: "+otp);

        //Nhập OTP xác nhận
        System.out.println("Vui lòng nhập mã OTP để xác nhận");
        int otpNhap = sc.nextInt();

        if(otpNhap==otp){
            System.out.println("Mã OTP chính xác!");
            sc.nextLine();

            //Đổi mật khẩu
            System.out.println("Nhập mật khẩu mới: ");
            String newPassword = sc.nextLine();
            this.password = newPassword;
            System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
        }
        else
            System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
    }
        

    @Override
    public void lockAccount(String matk) {
        if(listNhaHang.get(matk)!=null)
            listNhaHang.get(matk).isLocked=true;
        else
             System.out.println();
    }

    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        int dem = 0;
        String id;

        Account restaurant = null;
        while(restaurant == null){
            System.out.println("Nhập mã nhà hàng: ");
            id = sc.nextLine();
            restaurant = listNhaHang.get(id);
            if(restaurant == null){
                System.out.println("Mã nhà hàng không tồn tại. Vui lòng nhập lại!");
            }
        }

        //Kiểm tra mật khẩu
        while(dem<5){
            System.out.println("Nhập mật khẩu của tài khoản: ");
            String password = sc.nextLine();

            //Kiểm tra mật khẩu
            if(restaurant.getPassword().equals(password)){
                System.out.println("Đăng nhập thành công!");
                return true;
            }
            else{
                dem++;
                System.out.println("Sai mật khẩu. Bạn còn "+(5-dem)+" lần thử.");

            }
        }

        //Sau khi hết 5 lần thử hỏi người dùng có muốn thiết lập lại mật khẩu không
        System.out.println("Bạn đã nhập sai mật khẩu quá 5 lần.");
        System.out.println("Bạn có muốn quên mật khẩu? (y/n): ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("y")){
            forgotPassWord();

            //Sau khi đổi mật khẩu thành công, yêu cầu nhập lại mật khẩu vừa tạo để đăng nhập
            System.out.println("Mật khẩu được đổi thành công!");
            System.out.println("Vui lòng nhập lại mật khẩu để đăng nhập: ");
            String newPass = sc.nextLine();

            //Kiểm tra mật khẩu mới 
            if(restaurant.getPassword.equals(newPass)){
                System.out.println("Đăng nhập thành công với mật khẩu mới!");
                return true;
            }
            else{
                System.out.println("Mật khẩu không đúng, đăng nhập không thành công");
            }
        }
        else{
            System.out.println("Đăng nhập không thành công!");
        }
        return false;
    }
}
