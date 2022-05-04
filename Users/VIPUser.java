package Users;

public class VIPUser extends User {

    public VIPUser(String id, String name, String psc, String adress, String region, String state) {
        super(id, name, psc, adress, region, state);
    }

    // Can add more between bids max 10s;
    public static void AddMoreTime() {

    }

    @Override
    // polymorfism
    public String getName() {
        return "*****| Meno VIP Usera je " + this.getAdress() + " |*****";
    }

    @Override
    public String getID() {
        return "*****| Meno VIP Usera je " + this.getName() + " |*****";
    }
}
