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

    public static void Bid(){
        // ++ prida viac penazi za prihodenie
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

    public Garage AddGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {

        Garage garage = new Garage(old_owner, owner, locked, description, size, sold, minimumprice, name);

        return garage;
    }

    public SpecialGarage AddSpecialGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {
        
        SpecialGarage special_garage = new SpecialGarage(old_owner, owner, locked, description, size, sold, minimumprice, name);

        return special_garage;

    }
}
