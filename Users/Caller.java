package Users;

import java.util.Scanner;

import Storages.Garage;
import Storages.SpecialGarage;

public class Caller extends Being {

    public Caller() {}

    public static String data_id;
    public static String data_name;

    public Caller(String id, String name, String psc, String adress, String region, String state) {
        super(id, name, psc, adress, region, state);
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
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // your code here
                    }
                },
                5000);
    }

    // End Timer
    public void EndTimer() {

    }

    public User AddUser(String id, String name, String psc, String adress,String region, String state) {

        User user = new User(id, name, psc, adress, region, state);

        return user;
    }

    public VIPUser AddVIPUser(String id, String name, String psc, String adress,String region, String state) {

        VIPUser vipUser = new VIPUser(id, name, psc, adress, region, state);

        return vipUser;
    }

    public Garage AddGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice) {

        Garage garage = new Garage(old_owner, owner, locked, description, size, sold, minimumprice);

        return garage;
    }

    public SpecialGarage AddSpecialGarage() {
        Scanner scanner = new Scanner(System.in);
        SpecialGarage special_garage = new SpecialGarage();

        System.out.print("Majitel tohto skladu:");
        special_garage.setOldOwner(scanner.next());

        // System.out.print(":");
        // special_garage.setOwner(scanner.next());

        System.out.println("Prosim zvolte si moznost:");
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

        System.out.println("Zakladny popis skladu:");
        special_garage.setDescription(scanner.next());

        System.out.println("Velkost skladu v m3:");
        special_garage.setSize(scanner.nextInt());

        special_garage.setSold(false);

        System.out.println("Prosim zadajte vyvolavaciu cenu (minimalnu):");
        special_garage.setMinimumPrice(scanner.nextInt());

        System.out.println("Zadajte specialne/vzacne veci, ktore mozno najst v sklade. Tieto hodnoty oddelujte znakom ',':");
        special_garage.setSpecialItems(scanner.next());

        System.out.println("Historia skladu:");
        special_garage.setHistory(scanner.next());

        scanner.close();
        return special_garage;

    }
}
