package Storages;

public class Storage implements implements_get, implements_set  {

    private String OldOwner; // Old Owner -> but not current owner
    private String Owner; // Current Owner
    private Boolean Locked; // If is Locked or Not
    private Integer Size; // Size of storage in m2
    private Boolean Sold; // Check if storage is sold

    /**
     * Main 
     */
    //!! vhniezdene triedy
    public static class main {
        protected static String Name; // Name of storage
        protected static String Description; // Description of Storage
        protected static Integer MinimumPrice; // Minimum price of storage
        protected static Integer price; // Current price of storage
    }

    public Storage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {
        OldOwner = old_owner;
        Owner = owner;
        Locked = locked;
        main.Description = description;
        Size = size;
        Sold = sold;
        main.MinimumPrice = minimumprice;
        main.Name = name;
        main.price = minimumprice;
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
        main.Description = setdescription;
    }

    public void setSize(Integer setsize) {
        Size = setsize;
    }

    public void setSold(Boolean setsold) {
        Sold = setsold;
    }

    public void setMinimumPrice(Integer minimumprice) {
        main.MinimumPrice = minimumprice;
    }

    public void setPrice(Integer Price) {
        main.price = Price;
    }
    
    public void setMinPrice(Integer Price) {
        main.MinimumPrice = Price;
    }

    // ?? Getters
    public Integer getMinimumPrice() {
        return main.MinimumPrice;
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
        return main.Description;
    }

    public Integer getSize() {
        return Size;
    }

    public Boolean getSold() {
        return Sold;
    }

    public Integer setSold() {
        return main.MinimumPrice;
    }

    public String getName() {
        return main.Name;
    }

    public Integer getPrice() {
        return main.price;
    }

}
