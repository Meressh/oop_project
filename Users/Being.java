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

    public Being(String id, String name) {
        ID = id;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }

    public void setAdress(String psc, String adresa, String okres, String stat) {
        address.psc = psc;
        address.adresa = adresa;
        address.okres = okres;
        address.stat = stat;
    }

    public String getPSC() {
        return address.psc;
    }

    public String getAdresa() {
        return address.adresa;
    }

    public String getOkres() {
        return address.okres;
    }

    public String getStat() {
        return address.stat;
    }
}
