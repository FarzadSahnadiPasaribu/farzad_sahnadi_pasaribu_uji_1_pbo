// Interface untuk barang yang dikenakan pajak
interface Taxable {
    double calculateTax();
}

// Abstract class Product
abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method untuk menghitung total harga (termasuk pajak jika ada)
    public abstract double getTotalPrice();

    public String getName() {
        return name;
    }
}

// Subclass Food tidak dikenakan pajak
class Food extends Product {
    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        return price; // Makanan tidak kena pajak
    }
}

// Subclass Beverage dikenakan pajak, implement Taxable
class Beverage extends Product implements Taxable {
    private static final double TAX_RATE = 0.1; // 10% pajak

    public Beverage(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public double getTotalPrice() {
        return price + calculateTax();
    }
}

// Kelas utama
public class MainApp {
    public static void main(String[] args) {
        // Membuat array belanja dengan tipe Product (polymorphism)
        Product[] cart = {
            new Food("Nasi Goreng", 15000),
            new Beverage("Teh Botol", 5000),
            new Food("Bakso", 18000),
            new Beverage("Kopi", 7000)
        };

        double total = 0;

        System.out.println("== Struk Belanja ==");
        for (Product p : cart) {
            System.out.printf("%-15s : Rp %.0f%n", p.getName(), p.getTotalPrice());
            total += p.getTotalPrice();
        }

        System.out.println("-----------------------");
        System.out.printf("Total Bayar     : Rp %.0f%n", total);
    }
}
