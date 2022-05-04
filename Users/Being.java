package Users;

import java.security.PrivateKey;
import java.util.ArrayList;

import Storages.Garage;

public class Being {

    // !! Agregation
    Address address;

    private static ArrayList<Garage> Garages = new ArrayList<Garage>(); // ArrayList
    private String ID; // Identification Number
    private String Name; // Name of Being

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static ArrayList<Garage> getGarages() {
        return Garages;
    }

    public static void setGarages(ArrayList<Garage> garages) {
        Garages = garages;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public void setName(String name) {
        Name = name;
    }

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
