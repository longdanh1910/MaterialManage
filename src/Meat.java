import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meat extends Material implements Discount {
    private double weight;
    private Scanner sc = new Scanner(System.in);

    public Meat(String id,String name,LocalDate manufacturingDate,int cost,double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getAmount() {
        return getCost() * getWeight();
    }

    @Override
    public double getRealMoney() {
        return getAmount() * 0.9;
    }

    public void showListMeat() {
        List<Meat> meats = new ArrayList();
    }

//        public void addMeat(){
//        System.out.println("Nhập ID: ");
//        String id = sc.nextLine();
//        System.out.println("Nhập tên: ");
//        String name = sc.nextLine();
//        System.out.println("Nhập ngày hết hạn: ");
//        LocalDate date = LocalDate.parse(sc.nextLine());
//        System.out.println("Nhập giá: ");
//        int cost = sc.nextInt();
//        System.out.println("Nhập cân nặng: ");
//        double weight = sc.nextDouble();
//        Meat meat = new Meat();
//        meats.add(meat);
//
//    }
//
//    public void displayMeatFunctional(){
//        int choice;
//        do{
//            System.out.println("Quản lý thịt: \n"+
//                    "1. Hiển thị danh sách thịt. \n"+
//                    "2. Thêm mới thịt. \n"+
//                    "3. Chỉnh sửa. \n"+
//                    "4. Xoá. \n"+
//                    "5. Trở về trang chủ. \n"+
//                    "Nhập lựa chọn của bạn");
//            choice = sc.nextInt();
//            switch (choice){
//                case 1:
//                    showListMeat();
//                    break;
//                case 2:
//                    addMeat();
//                    break;
//                case 3:
//                    editMeat();
//                    break;
//                case 4:
//                    deleteMeat();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Vui lòng nhập lại.");
//            }
//        }while (true);
//    }
}
