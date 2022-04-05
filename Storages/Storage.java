package Storages;

public class Storage {
    // !! zmenit staticke
    private static String OldOwner; // Old Owner -> but not current owner
    private static String Name; // Old Owner -> but not current owner
    private static String Owner; // Current Owner
    private static Boolean Locked; // If is Locked or Not
    private static String Description; // Description of Storage
    private static Integer Size; // Size of storage in m2
    private static Boolean Sold; // Check if storage is sold
    private static Integer MinimumPrice; // Minimum price of storage
    private static Integer price; // Current price of storage

    public Storage() {}

    public Storage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice) {

        OldOwner = old_owner;
        Owner = owner;
        Locked = locked;
        Description = description;
        Size = size;
        Sold = sold;
        MinimumPrice = minimumprice;
    }

    // ?? Setters
    public void setOldOwner(String oldowner) {
        OldOwner = oldowner;
    }

    public void setOwner(String setowner) {
        Owner = setowner;
    }

    public void setLocked(Boolean setlocked) {
        Locked = setlocked;
    }

    public void setDescription(String setdescription) {
        Description = setdescription;
    }

    public void setSize(Integer setsize) {
        Size = setsize;
    }

    public void setSold(Boolean setsold) {
        Sold = setsold;
    }

    public void setMinimumPrice(Integer minimumprice) {
        MinimumPrice = minimumprice;
    }

    public void setPrice(Integer Price) {
        price = Price;
    }

    // ?? Getters
    public Integer getMinimumPrice() {
        return MinimumPrice;
    }

    public String getOldOwner() {
        return OldOwner;
    }

    public String getOwner() {
        return Owner;
    }

    public Boolean getLocked() {
        return Locked;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getSize() {
        return Size;
    }

    public Boolean getSold() {
        return Sold;
    }

    public Integer setSold() {
        return MinimumPrice;
    }

    public String getName() {
        return Name;
    }

    public Integer getPrice() {
        return price;
    }

}
