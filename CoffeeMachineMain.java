import java.util.Scanner;

abstract class Coffee {
    protected String name;
    protected int water;
    protected int coffeeBeans;
    protected double price;

    public Coffee(String name, int water, int coffeeBeans, double price) {
        this.name = name;
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public abstract void brew();
}

class Espresso extends Coffee {
    public Espresso() {
        super("Espresso", 50, 18, 25000);
    }

    @Override
    public void brew() {
        System.out.println("Menyeduh Espresso...");
    }
}

class Latte extends Coffee {
    public Latte() {
        super("Latte", 200, 24, 30000);
    }

    @Override
    public void brew() {
        System.out.println("Menyeduh Latte...");
    }
}

class CoffeeMachine {
    private Coffee[] coffees;

    public CoffeeMachine() {
        this.coffees = new Coffee[]{new Espresso(), new Latte()};
    }

    public void displayMenu() {
        System.out.println("Coffee yang tersedia:");
        for (int i = 0; i < coffees.length; i++) {
            System.out.println((i + 1) + ". " + coffees[i].getName());
        }
    }

    public void showCoffeePrice(int choice) {
        if (choice > 0 && choice <= coffees.length) {
            Coffee selectedCoffee = coffees[choice - 1];
            System.out.println("Harga dari " + selectedCoffee.getName() + " is Rp. " + selectedCoffee.getPrice());
            confirmPurchase(selectedCoffee);
        } else {
            System.out.println("Pilih ulang.");
        }
    }

    private void confirmPurchase(Coffee coffee) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to proceed with the purchase? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            coffee.brew();
            System.out.println("Selamat menikmati kopi " + coffee.getName() + "-nya");
        } else {
            System.out.println("Dibatalkan.");
        }
    }
}

public class CoffeeMachineMain {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        machine.displayMenu();
        System.out.print("Pilih kopi yang anda inginkan: ");
        int choice = scanner.nextInt();

        machine.showCoffeePrice(choice);
    }
}