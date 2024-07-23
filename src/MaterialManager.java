import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    private List<Material> materials;
    private Scanner sc = new Scanner(System.in);

    public MaterialManager() {
        this.materials = new ArrayList<>();
    }

    public void add(Material material) {
//        System.out.println("Nhập ID: ");
//        int id = sc.nextInt();
//        System.out.println("Nhập tên: ");
//        String name = sc.nextLine();
//        System.out.println("Nhập ngày hết hạn: ");
//        LocalDate date = LocalDate.parse(sc.nextLine());
//        System.out.println("Nhập giá: ");
//        double cost = sc.nextDouble();

        materials.add(material);
    }

    public void removeMaterial(Material material) {
        materials.remove(material);
    }


    public void displayMaterials() {
        for (Material material : materials) {
            System.out.println("ID: " + material.getId() + ", Name: " + material.getName() +
                    ", Cost: " + material.getCost() + ", Amount: " + material.getAmount() +
                    ", Expiry Date: " + material.getExpiryDate());
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Material material : materials) {
            totalCost += material.getAmount();
        }
        return totalCost;
    }

    public double getDifBetweenDisAndNonDis() {
        double totalCost = getTotalCost();
        double totalDiscountedCost = 0;

        for (Material material : materials) {
            if (material instanceof Discount) {
                totalDiscountedCost += ((Discount) material).getRealMoney();
            }
        }
        return totalCost - totalDiscountedCost;
    }


}
