package Storages;

import java.util.ArrayList;

public class SpecialGarage extends Garage {
    protected static Integer counter_special_items = 0;
    // public static String[] SpecialItemsArray; // Special Items like Golden Fish and so
    public static String History; // Some History of Special Storage
    public static ArrayList<SpecialItems> SpecialItemsArray = new ArrayList<SpecialItems>(); // Special Items like Golden Fish and so

    public SpecialGarage() {}

    // public SpecialGarage(String OldOwner, String Owner, String Locked, String Description, Integer Size, Boolean Sold, Integer MinimumPrice) {
    // super(OldOwner, Owner, Locked, Description, Size, Sold, MinimumPrice);
    // }
    public void setSpecialItems(String name, String price) {
        SpecialItems special_item = new SpecialItems(name, price);

        SpecialItemsArray.add(counter_special_items, special_item);
    }

    public void setHistory(String history) {
        History = history;
    }

    public String[] getSpecialItems() {
        for (int i = 0; i < SpecialItemsArray.length; i++) {
            System.out.println("");
        }
        return SpecialItemsArray;
    }

    public String getHistory() {
        return History;
    }
}

class SpecialItems {
    String name;
    String price;

    SpecialItems(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
