// Abstract class Vehicle sebagai superclass
abstract class Vehicle {
    // Method abstract yang harus di-override oleh subclass
    public abstract void startEngine();
}

// Interface Electric dengan method chargeBattery
interface Electric {
    void chargeBattery();
}

// Class Car mewarisi Vehicle dan mengimplementasikan Electric
class Car extends Vehicle implements Electric {
    @Override
    public void startEngine() {
        // Implementasi khusus untuk mobil
        System.out.println("Mobil: Menyalakan mesin dengan tombol start.");
    }

    @Override
    public void chargeBattery() {
        // Implementasi pengisian baterai untuk mobil listrik
        System.out.println("Mobil: Mengisi baterai mobil listrik...");
    }
}

// Class Motorcycle mewarisi Vehicle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        // Implementasi khusus untuk motor
        System.out.println("Motor: Menyalakan mesin dengan kick starter.");
    }
}

// Kelas utama untuk demonstrasi polymorphism
public class MainApp {
    public static void main(String[] args) {
        // Polymorphism: objek bertipe Vehicle tapi mengacu ke Car
        Vehicle myCar = new Car();
        Vehicle myMotor = new Motorcycle();

        // Memanggil method yang dioverride sesuai tipe objek sebenarnya
        myCar.startEngine();        // Akan memanggil method Car
        myMotor.startEngine();      // Akan memanggil method Motorcycle

        // Tipe casting untuk memanggil method chargeBattery dari interface Electric
        if (myCar instanceof Electric) {
            ((Electric) myCar).chargeBattery();
        }
    }
}
