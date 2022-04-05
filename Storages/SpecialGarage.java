package Storages;

public class SpecialGarage extends Garage {
    private static String[] SpecialItems; // Special Items like Golden Fish and so
    private static String History; // Some History of Special Storage

    public SpecialGarage() {}

    // public SpecialGarage(String OldOwner, String Owner, String Locked, String Description, Integer Size, Boolean Sold, Integer MinimumPrice) {
    // super(OldOwner, Owner, Locked, Description, Size, Sold, MinimumPrice);
    // }
    public void setSpecialItems(String specialitems) {

        SpecialItems = specialitems.split(",");
    }

    public void setHistory(String history) {
        History = history;
    }

    public String[] getSpecialItems() {
        return SpecialItems;
    }

    public String getHistory() {
        return History;
    }
}
