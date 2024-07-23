import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class MaterialManager {
    private List<Material> materials;

    public MaterialManager() {
        this.materials = new ArrayList<>();
    }

    public void addMaterial(Material material) {
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

    public double getTotalDiscountedCost() {
        double totalDiscountedCost = 0;
        for (Material material : materials) {
            if (material instanceof Discount) {
                totalDiscountedCost += ((Discount) material).getRealMoney();
            }
        }
        return totalDiscountedCost;
    }

    public void sortMaterialsByCost() {
        materials.sort(Comparator.comparingDouble(Material::getAmount));
    }

    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();

        // Thêm 5 đối tượng bột
        manager.addMaterial(new CrispyFlour("CF01", "Bột A", LocalDate.now(), 100, 5));
        manager.addMaterial(new CrispyFlour("CF02", "Bột B", LocalDate.now(), 150, 10));
        manager.addMaterial(new CrispyFlour("CF03", "Bột C", LocalDate.now(), 200, 20));
        manager.addMaterial(new CrispyFlour("CF04", "Bột D", LocalDate.now(), 250, 15));
        manager.addMaterial(new CrispyFlour("CF05", "Bột E", LocalDate.now(), 300, 25));

        // Thêm 5 đối tượng thịt
        manager.addMaterial(new Meat("M01", "Thịt A", LocalDate.now(), 100, 2.5));
        manager.addMaterial(new Meat("M02", "Thịt B", LocalDate.now(), 200, 1.5));
        manager.addMaterial(new Meat("M03", "Thịt C", LocalDate.now(), 150, 3.0));
        manager.addMaterial(new Meat("M04", "Thịt D", LocalDate.now(), 180, 2.0));
        manager.addMaterial(new Meat("M05", "Thịt E", LocalDate.now(), 120, 4.0));

        // Hiển thị thông tin vật liệu
        System.out.println("Thông tin vật liệu:");
        manager.displayMaterials();

        // Tính tổng tiền không chiết khấu
        double totalCost = manager.getTotalCost();
        System.out.println("Tổng tiền không chiết khấu: " + totalCost);

        // Tính tổng tiền sau chiết khấu
        double totalDiscountedCost = manager.getTotalDiscountedCost();
        System.out.println("Tổng tiền sau chiết khấu: " + totalDiscountedCost);

        // Tính chênh lệch giữa chiết khấu và không chiết khấu
        double discountDifference = totalCost - totalDiscountedCost;
        System.out.println("Chênh lệch giữa chiết khấu và không chiết khấu: " + discountDifference);

        // Sắp xếp vật liệu theo giá trị
        manager.sortMaterialsByCost();
        System.out.println("Vật liệu sau khi sắp xếp theo giá trị:");
        manager.displayMaterials();
    }
}