package Users;

public class VIPUser extends User {

    public VIPUser() {}

    public VIPUser(String id, String name) {
        super(id, name);
    }

    // Can add more between bids max 10s;
    public static void AddMoreTime() {

    }

    @Override
    // polymorfism
    public String getName() {
        return "*****| Meno VIP Usera je " + Name + " |*****";
    }

    public String getID() {
        return "*****| Meno VIP Usera je " + ID + " |*****";
    }
}
