import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;

import GUI.App;

import java.util.ArrayList;

import Storages.Garage;
import Storages.SpecialGarage;
import Storages.Storage;
import Users.Caller;
import javafx.stage.Stage;

class Auction {
        public Timer time;
        public static int Auctions; // How many auction have been executed "today"
        public static int ActiveNumberOfUsers = 0; // How many users are now bidding
        public static int ActiveNumberOfVIPUsers = 0; // How many VIP users are now bidding

        public static int ActiveNumberOfStorages = 0; // How many Storages are now in auction
        public static int ActiveNumberOfStoragesSpecial = 0; // How many Special Storages are now in auction

        public static int ALlTimeUsers = 0; // All time users
        public static int ALlTimeVIPUsers = 0; // All time users

        public static int AllTimeStorages = 0; // All time Garages
        public static int AllTimeStoragesSpecial = 0; // All time Special Garages

        public static boolean Active = false; // If auction is rolling now

        public static ArrayList<User> Users = new ArrayList<User>(); // Create ArrayList for store Users which are added to auction
        public static ArrayList<VIPUser> VIPUsers = new ArrayList<VIPUser>(); // Create ArrayList for store VIPusers which are added to auction
        public static ArrayList<Garage> Garages = new ArrayList<Garage>(); // Create ArrayList for store Garages which are added to auction
        public static ArrayList<SpecialGarage> SpecialGarages = new ArrayList<SpecialGarage>(); // Create ArrayList for store SpecialGarages which are added to auction

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

        // Place where all begins
        public static void main(String[] args) {
                
                // Print E-Aukcion in ASCII art
                // Gui_Design gui_design = new Gui_Design();
                // App.start(Stage primaryStage);

                // !! Start E-Auction and Add caller
                // Start scenner
                System.out.println("Prosim zvolte si moznost:");
                System.out.println("(1) Prihlasenie Vyvolavaca E-Aukcie");
                System.out.println("(2) Ukončenie E-Aukcie");

                Scanner scanner = new Scanner(System.in);

                String option = scanner.nextLine();

                String id = null;
                String name = null;

                if (option.equals("2")) {
                        System.exit(0);
                }

                if (!option.equals("1")) {
                        System.out.println("Zadali ste neplatnu moznost.");
                        System.exit(0);
                }

                // Add Caller
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

                System.out.println(caller.getName());
                System.out.println("Vyvolavac uspesne registrovany!");

                // ?? Add some storages which will be sold -> iny sposob pridavania ako pri pridavani Vyvolavaca/Caller -> getters/setters
                System.out.println("Pridajte sklady na predaj!");

                do {
                        Scanner scanner_while = new Scanner(System.in);

                        System.out.println("Prosim zvolte si moznost:");
                        System.out.println("(1) Zakladne garaze");
                        System.out.println("(2) Specialne garaze");
                        System.out.println("(3) Pridat pouzivatela");
                        System.out.println("(4) Pridat VIP pouzivatela");
                        System.out.println("(5) Spustit Aukciu");

                        // Stats from all period when application was running
                        System.out.println("(0) Ukoncit aukciu a vypisat statistiky dna");

                        option = scanner_while.nextLine();

                        // ?? Basic Garage
                        if (option.equals("1")) {
                                Garages.add(ActiveNumberOfStorages, caller.AddGarage());

                                ActiveNumberOfStorages++;
                                AllTimeStorages++;
                        }

                        // ?? Special Garage
                        if (option.equals("2")) {
                                SpecialGarages.add(ActiveNumberOfStoragesSpecial, caller.AddSpecialGarage());

                                ActiveNumberOfStoragesSpecial++;
                                AllTimeStoragesSpecial++;
                        }

                        // ?? User
                        if (option.equals("3")) {
                                Users.add(ActiveNumberOfUsers, caller.AddUser());

                                ActiveNumberOfUsers++;
                                ALlTimeUsers++;
                        }

                        // ?? VIPUser
                        if (option.equals("4")) {
                                VIPUsers.add(ActiveNumberOfVIPUsers, caller.AddVIPUser());

                                ActiveNumberOfVIPUsers++;
                                ALlTimeVIPUsers++;
                        }

                        if (option.equals("0")) {
                                System.out.println("Koniec aukčného dňa!");

                                // ?? Print stats
                                System.out.println("Statistiky dňa:");
                                // Todo vypisat statistiky dna !
                                System.exit(0);
                        }

                        scanner_while.close();

                } while (!option.equals("5"));

                // ?? Start timer
                Timer();

                // ?? Start Auction
                Active = true;
                Auctions++;

                for (int i = 0; i < Garages.size(); i++) {
                        System.out.println("Nazov skladu je " + Garages.get(i).getName());
                        System.out.println("Minimalna cena skladu je " + Garages.get(i).getMinimumPrice());
                        System.out.println("Predchadzajúci majiteľ skladu je " + Garages.get(i).getOldOwner());
                        System.out.println("Majiteľ skladu je " + Garages.get(i).getOwner());
                        System.out.println("Sklad je zamknutý" + Garages.get(i).getLocked());
                        System.out.println("Popis skladu" + Garages.get(i).getDescription());
                        System.out.println("Rozmery skladu su " + Garages.get(i).getSize());
                        System.out.println("Sklad je predaný" + Garages.get(i).getSold());

                        // System.out.println("Minimalna cena skladu je " + Garages.get(i).getPrice());
                }

                // Close scanner
                scanner.close();
        }
}