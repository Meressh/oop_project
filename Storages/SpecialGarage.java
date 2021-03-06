package Storages;

public class SpecialGarage extends Garage implements SpecialGarageBase {
    private String[] SpecialItems; // Special Items like Golden Fish and so
    private String History; // Some History of Special Storage

    public SpecialGarage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {
        super(old_owner,  owner,  locked,  description,  size,  sold, minimumprice, name);
    }

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
    // Prekonávanie metódov z triedy Garage
    @Override
    public Integer getMinimumPrice() {
        return (main.MinimumPrice + 5);
    }
}
