package Users;

import java.util.ArrayList;

import Storages.Garage;

public class Being {

    // !! Agregation
    Address address;

    public static ArrayList<Garage> Garages = new ArrayList<Garage>(); // ArrayList
    public String ID; // Identification Number
    public String Name; // Name of Being

    public Being() {}

    public void AddToList(Garage entryGarage) {
        Garages.add(entryGarage);
    }

    public String printList() {
        String text = "";
        for (Garage loopItem : Garages) {
            text = text + loopItem.getName() + "\n";
        }

        return text;
    }

    public Being(String id, String name, String psc, String adress, String region, String state) {
        ID = id;
        Name = name;
        address = new Address(psc, adress, region, state);
    }

    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }

    public void setAdress(String psc, String adresa, String okres, String stat) {
        address = new Address(psc, adresa, okres, stat);
    }

    public String getPSC() {
        return address.psc;
    }

    public String getAdress() {
        return address.adresa;
    }

    public String getOkres() {
        return address.okres;
    }

    public String getStat() {
        return address.stat;
    }
}
