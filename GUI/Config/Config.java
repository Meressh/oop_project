package GUI.Config;

import Users.User;
import Users.VIPUser;

import java.util.Timer;

import java.util.ArrayList;

import Storages.Garage;
import Storages.SpecialGarage;
import Users.Caller;

public class Config {
    public static Caller caller;
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
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static void createCaller(String id, String name, String psc, String adress, String region, String state) throws Exception {
        caller = new Caller(id, name, psc, adress, region, state);
    }
    public static void createUser(String id, String name, String psc, String adress, String region, String state) {
        
        User CurretnUser = caller.AddUser(id, name, psc, adress, region, state);
        Users.add(ActiveNumberOfUsers, CurretnUser);
        
        ActiveNumberOfUsers++;  
        ALlTimeUsers++;
    }
    
    public static void createVIPUser(String id, String name, String psc, String adress, String region, String state) {
        VIPUser CurretnVIPUser = caller.AddVIPUser(id, name, psc, adress, region, state);
        VIPUsers.add(ActiveNumberOfVIPUsers, CurretnVIPUser);
        
        ActiveNumberOfVIPUsers++;
        ALlTimeVIPUsers++;
    }
    
    
    public static void createGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {
        Garage CurrentGarage = caller.AddGarage(old_owner, owner, locked, description, size, sold, minimumprice, name);
        
        Garages.add(ActiveNumberOfStorages, CurrentGarage);
        
        ActiveNumberOfStorages++;
        AllTimeStorages++;
    }
    
    public static void createSpecialGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String special_items, String history, String name) {
        SpecialGarage CurrentSpecialGarage = caller.AddSpecialGarage(old_owner, owner, locked, description, size, sold, minimumprice, name);
        CurrentSpecialGarage.setSpecialItems(special_items);
        CurrentSpecialGarage.setHistory(history);
        
        SpecialGarages.add(ActiveNumberOfStoragesSpecial, CurrentSpecialGarage);
        
        ActiveNumberOfStoragesSpecial++;
        AllTimeStoragesSpecial++;
    }

    public static boolean addBid(String garage, String id_user, Integer price){
        //Check variables
        Integer check_garage = 0;
        Integer check_users= 0;

        //??Users
        for (int i = 0; i < Users.size(); i++) {
            if(Users.get(i).getName().equals(id_user)){
                check_users = 1;
            }
        }

        if(check_users == 0){
            for (int i = 0; i < VIPUsers.size(); i++) {
                if (VIPUsers.get(i).getName().equals(id_user)) {
                    check_users = 1;
                }
            }
        }

        if(check_users == 0){
            return false;
        }

        //??Garages
        for (int i = 0; i < Garages.size(); i++) {
            if (Garages.get(i).getName().equals(garage)) {

                if(Garages.get(i).getMinimumPrice() >= price){
                    return false;
                }

                Garages.get(i).setOwner(id_user);
                Garages.get(i).setMinPrice(price);

                System.out.println(Garages.get(i).getName());
                System.out.println(Garages.get(i).getOwner());
                System.out.println(Garages.get(i).getPrice());

                check_garage = 1;
            }
        }
        if(check_garage == 0){
            for (int i = 0; i < SpecialGarages.size(); i++) {
                if (SpecialGarages.get(i).getName().equals(garage)) {

                    if (SpecialGarages.get(i).getMinimumPrice() >= price) {
                        return false;
                    }

                    SpecialGarages.get(i).setOwner(id_user);
                    SpecialGarages.get(i).setMinPrice(price);

                    check_garage = 1;
                }
            }
        }

        if (check_garage == 0) {
            return false;
        }

        return true;
    }
}