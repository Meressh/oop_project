package Users;

public class Being {

    public String ID; // Identification Number
    public String Name; // Name of Being

    public Being() {}

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

}
