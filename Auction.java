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

        option = scanner.nextInt();

        if (option == 1) {
            Garage garage = new Garage();

            garage.setOldOwner(scanner.next());
            garage.setOwner(scanner.next());
            garage.setLocked(scanner.next());
            garage.setDescription(scanner.next());
            garage.setSize(scanner.nextInt());
            garage.setSold(false);
            garage.setMinimumPrice(scanner.nextInt());

        }

        if (option == 2) {
            SpecialGarage special_garage = new SpecialGarage();

            special_garage.setOldOwner(scanner.next());
            special_garage.setOwner(scanner.next());
            special_garage.setLocked(scanner.next());
            special_garage.setDescription(scanner.next());
            special_garage.setSize(scanner.nextInt());
            special_garage.setSold(false);
            special_garage.setMinimumPrice(scanner.nextInt());

            special_garage.setSpecialItems(scanner.next());
            special_garage.setHistory(scanner.next());

        }

        // Close scanner
        scanner.close();
    }

}