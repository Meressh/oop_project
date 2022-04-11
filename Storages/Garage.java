package Storages;

public class Garage extends Storage {

    public Garage(String old_owner, String owner, Boolean locked, String description, Integer size, Boolean sold, Integer minimumprice, String name) {
        super(old_owner,  owner,  locked,  description,  size,  sold, minimumprice, name);
    }

    // public Garage(String OldOwner, String Owner, String Locked, String Description, Integer Size, Boolean Sold, Integer MinimumPrice) {
    // super(OldOwner, Owner, Locked, Description, Size, Sold, MinimumPrice);
    // }
}
