package Storages;

public class SpecialGarage extends Garage {
    private static String[] SpecialItems; // Special Items like Golden Fish and so
    private static String History; // Some History of Special Storage

    public SpecialGarage() {}

    // public SpecialGarage(String OldOwner, String Owner, String Locked, String Description, Integer Size, Boolean Sold, Integer MinimumPrice) {
    // super(OldOwner, Owner, Locked, Description, Size, Sold, MinimumPrice);
    // }
    protected void setSpecialItems(String specialitems) {

        SpecialItems = specialitems.split(",");
    }

    protected void setHistory(String history) {
        History = history;
    }

    protected String[] getSpecialItems() {
        return SpecialItems;
    }

    protected String getHistory() {
        return History;
    }
}
