import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;

import Storages.Garage;
import Storages.SpecialGarage;
import Storages.Storage;
import Users.Caller;

class Auction {
    public Timer time;
    public static int NumberOfUser; // All time Numer Of users
    public static int Auctions; // How many auction have been executed "today"
    public static int ActiveNumberOfUsers; // How many users are now bidding
    public static int BidValue; // Current Bid
    public static int ALlTimeUsers; // Active users
    public static boolean Active = false; // If auction is rolling now

    // public static boolean Active = false; // If auction is rolling now
    // public static boolean Active = false; // If auction is rolling now
    // public static boolean Active = false; // If auction is rolling now
    // public static boolean Active = false; // If auction is rolling now

    // Setup timer
    public static void Timer() {
        long startTime = System.nanoTime(); // Start nanoTimer
    }

    // Function which save / edit / delete data durring live auction
    public static void ProcessBid(int bid, Storage storage) {
        if (bid > storage.MinimumPrice) {
            BidValue = bid;
        }
    }

    // Will add user to auction
    public static void AddUser() {
        ActiveNumberOfUsers++;
        NumberOfUser++;

    }

    Caller caller = new Caller();

    // Place where all begins
    public static void main(String[] args) {

        // Print E-Aukcion in ASCII art
        System.out.println(
                "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\         ");
        System.out.println(
                "        /::\\    \\                /::\\____\\                /::\\____\\                /::\\    \\                /::\\    \\                /::\\    \\        ");
        System.out.println(
                "       /::::\\    \\              /:::/    /               /:::/    /               /::::\\    \\               \\:::\\    \\              /::::\\    \\       ");
        System.out.println(
                "      /::::::\\    \\            /:::/    /               /:::/    /               /::::::\\    \\               \\:::\\    \\            /::::::\\    \\      ");
        System.out.println(
                "     /:::/\\:::\\    \\          /:::/    /               /:::/    /               /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\     ");
        System.out.println(
                "    /:::/__\\:::\\    \\        /:::/    /               /:::/____/               /:::/  \\:::\\    \\               \\:::\\    \\        /:::/__\\:::\\    \\    ");
        System.out.println(
                "   /::::\\   \\:::\\    \\      /:::/    /               /::::\\    \\              /:::/    \\:::\\    \\              /::::\\    \\      /::::\\   \\:::\\    \\   ");
        System.out.println(
                "  /::::::\\   \\:::\\    \\    /:::/    /      _____    /::::::\\____\\________    /:::/    / \\:::\\    \\    ____    /::::::\\    \\    /::::::\\   \\:::\\    \\  ");
        System.out.println(
                " /:::/\\:::\\   \\:::\\    \\  /:::/____/      /\\    \\  /:::/\\:::::::::::\\    \\  /:::/    /   \\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/\\:::\\   \\:::\\    \\ ");
        System.out.println(
                "/:::/  \\:::\\   \\:::\\____\\|:::|    /      /::\\____\\/:::/  |:::::::::::\\____\\/:::/____/     \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\");
        System.out.println(
                "\\::/    \\:::\\  /:::/    /|:::|____\\     /:::/    /\\::/   |::|~~~|~~~~~     \\:::\\    \\      \\::/    /\\:::\\  /:::/    \\::/    /\\::/    \\:::\\  /:::/    /");
        System.out.println(
                " \\/____/ \\:::\\/:::/    /  \\:::\\    \\   /:::/    /  \\/____|::|   |           \\:::\\    \\      \\/____/  \\:::\\/:::/    / \\/____/  \\/____/ \\:::\\/:::/    / ");
        System.out.println(
                "          \\::::::/    /    \\:::\\    \\ /:::/    /         |::|   |            \\:::\\    \\               \\::::::/    /                    \\::::::/    /  ");
        System.out.println(
                "           \\::::/    /      \\:::\\    /:::/    /          |::|   |             \\:::\\    \\               \\::::/____/                      \\::::/    /   ");
        System.out.println(
                "           /:::/    /        \\:::\\__/:::/    /           |::|   |              \\:::\\    \\               \\:::\\    \\                      /:::/    /    ");
        System.out.println(
                "          /:::/    /          \\::::::::/    /            |::|   |               \\:::\\    \\               \\:::\\    \\                    /:::/    /     ");
        System.out.println(
                "         /:::/    /            \\::::::/    /             |::|   |                \\:::\\    \\               \\:::\\    \\                  /:::/    /      ");
        System.out.println(
                "        /:::/    /              \\::::/    /              \\::|   |                 \\:::\\____\\               \\:::\\____\\                /:::/    /       ");
        System.out.println(
                "        \\::/    /                \\::/____/                \\:|   |                  \\::/    /                \\::/    /                \\::/    /        ");
        System.out.println(
                "         \\/____/                  ~~                       \\|___|                   \\/____/                  \\/____/                  \\/____/         ");

        // Print Zabudnutych skladov in ASCII Art
        System.out.println(
                " _______ _______ ______          ______  _              _________        _______            _______ _       _       _______ ______  _______         ");
        System.out.println(
                "/ ___   (  ___  (  ___ \\|\\     /(  __  \\( (    /|\\     /\\__   __|\\     /(  ____ |\\     /|  (  ____ | \\    /( \\     (  ___  (  __  \\(  ___  |\\     /|");
        System.out.println(
                "\\/   )  | (   ) | (   ) | )   ( | (  \\  |  \\  ( | )   ( |  ) (  ( \\   / | (    \\| )   ( |  | (    \\|  \\  / | (     | (   ) | (  \\  | (   ) | )   ( |");
        System.out.println(
                "    /   | (___) | (__/ /| |   | | |   ) |   \\ | | |   | |  | |   \\ (_) /| |     | (___) |  | (_____|  (_/ /| |     | (___) | |   ) | |   | | |   | |");
        System.out.println(
                "   /   /|  ___  |  __ ( | |   | | |   | | (\\ \\) | |   | |  | |    \\   / | |     |  ___  |  (_____  |   _ ( | |     |  ___  | |   | | |   | ( (   ) )");
        System.out.println(
                "  /   / | (   ) | (  \\ \\| |   | | |   ) | | \\   | |   | |  | |     ) (  | |     | (   ) |        ) |  ( \\ \\| |     | (   ) | |   ) | |   | |\\ \\_/ / ");
        System.out.println(
                " /   (_/| )   ( | )___) | (___) | (__/  | )  \\  | (___) |  | |     | |  | (____/| )   ( |  /\\____) |  /  \\ | (____/| )   ( | (__/  | (___) | \\   /  ");
        System.out.println(
                "(_______|/     \\|/ \\___/(_______(______/|/    )_(_______)  )_(     \\_/  (_______|/     \\|  \\_______|_/    \\(_______|/     \\(______/(_______)  \\_/   ");

        System.out.println("\n");
        System.out.println("\n");

        // !! Start E-Auction and Add caller
        // Start scenner
        System.out.println("Prosim zvolte si moznost:");
        System.out.println("(1) Prihlasenie Vyvolavaca E-Aukcie");
        System.out.println("(2) Ukončenie E-Aukcie");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        String id = null;
        String name = null;

        if (option == 2) {
            System.exit(0);
        }

        if (option != 1) {
            System.out.println("Zadali ste neplatnu moznost.");
            System.exit(0);
        }
        System.out.println("Zadajte prosim ID vyvolavaca");
        id = scanner.next();
        System.out.println("Zadajte prosim meno vyvolavaca");
        name = scanner.next();

        // Todo spravit nejak opravu aby si znova mohol vybrat moznost na vyber a nie nie ukoncit uplne aukciu
        if (id == null || name == null) {
            System.out.println("Something went wrong!");
            System.exit(0);
        }

        Caller caller = new Caller(id, name);
        System.out.println("Vyvolavac uspesne registrovany!");

        // !! Add some storages which will be sold -> iny sposob pridavania ako pri pridavani Vyvolavaca/Caller -> getters/setters
        System.out.println("Pridajte sklady na predaj!");

        System.out.println("Prosim zvolte si moznost:");
        System.out.println("(1) Zakladne garaze");
        System.out.println("(2) Specialne garaze");
        System.out.println("(3) Pridat pouzivatela");
        System.out.println("(4) Pridat VIP pouzivatela");
        System.out.println("(5) Spustit Aukciu");

        option = scanner.nextInt();

        // ?? Basic Garage
        if (option == 1) {
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

        }

        // ?? Special Garage
        if (option == 2) {
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
        }

        if (option == 3) {

            System.out.println("Prosim zadajte ID pouzivatela:");
            id = scanner.next();
            System.out.println("Prosim zadajte Meno pouzivatela:");
            name = scanner.next();

            User user = new User(id, name);
        }

        if (option == 4) {
            System.out.println("Prosim zadajte ID pouzivatela:");
            id = scanner.next();
            System.out.println("Prosim zadajte Meno pouzivatela:");
            name = scanner.next();

            VIPUser vipUser = new VIPUser(id, name);

            System.out.println(vipUser.ID);
            System.out.println(vipUser.Name);
        }

        if (option == 5) {

        }

        // Todo spravit nejak opravu aby si znova mohol vybrat moznost na vyber a nie nie ukoncit uplne aukciu
        // if (option != 1 || option != 2 || option != 3 || option != 4) {
        // System.out.println("Zadali ste neplatnu moznost.");
        // System.exit(0);
        // }

        // Close scanner
        scanner.close();
    }

}