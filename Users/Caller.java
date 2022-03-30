package Users;

import java.util.Scanner;

import Storages.Garage;
import Storages.SpecialGarage;

public class Caller extends Being {

    public Caller() {}

    public static String data_id;
    public static String data_name;

    public Caller(String id, String name) {
        super(id, name);
    }

    @Override
    // polymorfism
    public String getName() {
        return "Meno Vyvolavaca je " + Name;
    }

    public String getID() {
        return "Meno Vyvolavaca je " + ID;
    }

    // Start Auction
    public void StartAuction() {
        // Auction = new Auction;
    }

    // Setup Timer
    public void SetupTimer() {

    }

    // End Timer
    public void EndTimer() {

    }

    public User AddUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prosim zadajte ID pouzivatela:");
        data_id = scanner.next();
        System.out.println("Prosim zadajte Meno pouzivatela:");
        data_name = scanner.next();

        User user = new User(data_id, data_name);

        scanner.close();
        return user;
    }

    public VIPUser AddVIPUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosim zadajte ID VIP pouzivatela:");
        data_id = scanner.next();
        System.out.println("Prosim zadajte Meno VIP pouzivatela:");
        data_name = scanner.next();

        VIPUser vipUser = new VIPUser(data_id, data_name);

        scanner.close();
        return vipUser;

    }

    public Garage AddGarage() {
        Scanner scanner = new Scanner(System.in);

        Garage garage = new Garage();

        System.out.print("Majitel tohto skladu:");
        garage.setOldOwner(scanner.next());

        // System.out.println(":");
        // garage.setOwner(scanner.next());

        System.out.println("Prosim zvolte si moznost:");
        System.out.println("Sklad je zamknuty:");
        System.out.println("(1) Ano");
        System.out.println("(2) Nie");
        int is_locked = scanner.nextInt();

        if (is_locked == 1) {
            garage.setLocked(true);
        }
        else {
            garage.setLocked(false);
        }

        System.out.println("Zakladny popis skladu:");
        garage.setDescription(scanner.next());

        System.out.println("Velkost skladu v m3:");
        garage.setSize(scanner.nextInt());

        garage.setSold(false);

        System.out.println("Prosim zadajte vyvolavaciu cenu (minimalnu):");
        garage.setMinimumPrice(scanner.nextInt());

        scanner.close();
        return garage;
    }

    public SpecialGarage AddSpecialGarage() {

        // ??Inicialize
        Scanner scanner = new Scanner(System.in);
        SpecialGarage special_garage = new SpecialGarage();

        // ??Who will not be and is owner of this storage
        System.out.print("Majitel tohto skladu:");
        special_garage.setOldOwner(scanner.next());

        // System.out.print(":");
        // special_garage.setOwner(scanner.next());

        System.out.println("Prosim zvolte si moznost:");
        // ??Check if storage is locked or not
        System.out.println("Sklad je zamknuty:");
        System.out.println("(1) Ano");
        System.out.println("(2) Nie");
        int is_locked = scanner.nextInt();

        if (is_locked == 1) {
            special_garage.setLocked(true);
        }
        else {
            special_garage.setLocked(false);
        }

        // ??Add basic description of storage
        System.out.println("Zakladny popis skladu:");
        special_garage.setDescription(scanner.next());

        // ??Add Size of storage
        System.out.println("Velkost skladu v m3:");
        special_garage.setSize(scanner.nextInt());

        // ??Set sold to false
        special_garage.setSold(false);

        // ??Set beginning price for storage
        System.out.println("Prosim zadajte vyvolavaciu cenu (minimalnu):");
        special_garage.setMinimumPrice(scanner.nextInt());

        // ??Add Special Items
        System.out.println("Zadajte specialne/vzacne predmety, ktore mozno najst v sklade. Pridávanie Specialnych predmetov ukoncite znakom 0:");

        String input = "0";
        String input_price = "0";
        do {
            System.out.println("Prosim vlozte nazov specialneho predmetu:");
            input = scanner.next();
            System.out.println("Prosim vlozte pribliznu hodnotu specialneho predmetu:");
            input_price = scanner.next();

            if (input != "0") {
                special_garage.setSpecialItems(input, input_price);
            }
        } while (input != "0");

        // ??Add History of storage
        System.out.println("Historia skladu:");
        special_garage.setHistory(scanner.next());

        scanner.close();
        return special_garage;

    }
}
