import java.util.Timer;

import Storages.Storage;

class Auction {
    public Timer time;
    public static int NumberOfUser; // All time Numer Of users
    public static int Auctions; // How many auction have been executed "today"
    public static int ActiveNumberOfUsers; // How many users are now bidding
    public static int BidValue; // Current Bid
    public static int ALlTimeUsers; // Active users
    public static boolean Active = false; // If auction is rolling now

    // Setup timer
    public static void Timer() {
        long startTime = System.nanoTime(); // Start nanoTimer
    }

    // Function which save / edit / delete data durring live auction
    public static void ProcessBid(int bid, Storage storage) {
        if (bid > storage.MinimumPrice) {
            BidValue = bid;
        }
    }

    // Will add user to auction
    public static void AddUser() {
        ActiveNumberOfUsers++;
        NumberOfUser++;

    }

    // Will remove user to auction
    public static void RemoveUser() {

    }

    // Will start Auction
    public static void SetupAuction() {
        Active = true;
    }

    // Place where all begins
    public static void main(String[] args) {

        // Print E aukcion
        System.out.println(
                "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\         ");
        System.out.println(
                "        /::\\    \\                /::\\____\\                /::\\____\\                /::\\    \\                /::\\    \\                /::\\    \\        ");
        System.out.println(
                "       /::::\\    \\              /:::/    /               /:::/    /               /::::\\    \\               \\:::\\    \\              /::::\\    \\       ");
        System.out.println(
                "      /::::::\\    \\            /:::/    /               /:::/    /               /::::::\\    \\               \\:::\\    \\            /::::::\\    \\      ");
        System.out.println(
                "     /:::/\\:::\\    \\          /:::/    /               /:::/    /               /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\     ");
        System.out.println(
                "    /:::/__\\:::\\    \\        /:::/    /               /:::/____/               /:::/  \\:::\\    \\               \\:::\\    \\        /:::/__\\:::\\    \\    ");
        System.out.println(
                "   /::::\\   \\:::\\    \\      /:::/    /               /::::\\    \\              /:::/    \\:::\\    \\              /::::\\    \\      /::::\\   \\:::\\    \\   ");
        System.out.println(
                "  /::::::\\   \\:::\\    \\    /:::/    /      _____    /::::::\\____\\________    /:::/    / \\:::\\    \\    ____    /::::::\\    \\    /::::::\\   \\:::\\    \\  ");
        System.out.println(
                " /:::/\\:::\\   \\:::\\    \\  /:::/____/      /\\    \\  /:::/\\:::::::::::\\    \\  /:::/    /   \\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/\\:::\\   \\:::\\    \\ ");
        System.out.println(
                "/:::/  \\:::\\   \\:::\\____\\|:::|    /      /::\\____\\/:::/  |:::::::::::\\____\\/:::/____/     \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\");
        System.out.println(
                "\\::/    \\:::\\  /:::/    /|:::|____\\     /:::/    /\\::/   |::|~~~|~~~~~     \\:::\\    \\      \\::/    /\\:::\\  /:::/    \\::/    /\\::/    \\:::\\  /:::/    /");
        System.out.println(
                " \\/____/ \\:::\\/:::/    /  \\:::\\    \\   /:::/    /  \\/____|::|   |           \\:::\\    \\      \\/____/  \\:::\\/:::/    / \\/____/  \\/____/ \\:::\\/:::/    / ");
        System.out.println(
                "          \\::::::/    /    \\:::\\    \\ /:::/    /         |::|   |            \\:::\\    \\               \\::::::/    /                    \\::::::/    /  ");
        System.out.println(
                "           \\::::/    /      \\:::\\    /:::/    /          |::|   |             \\:::\\    \\               \\::::/____/                      \\::::/    /   ");
        System.out.println(
                "           /:::/    /        \\:::\\__/:::/    /           |::|   |              \\:::\\    \\               \\:::\\    \\                      /:::/    /    ");
        System.out.println(
                "          /:::/    /          \\::::::::/    /            |::|   |               \\:::\\    \\               \\:::\\    \\                    /:::/    /     ");
        System.out.println(
                "         /:::/    /            \\::::::/    /             |::|   |                \\:::\\    \\               \\:::\\    \\                  /:::/    /      ");
        System.out.println(
                "        /:::/    /              \\::::/    /              \\::|   |                 \\:::\\____\\               \\:::\\____\\                /:::/    /       ");
        System.out.println(
                "        \\::/    /                \\::/____/                \\:|   |                  \\::/    /                \\::/    /                \\::/    /        ");
        System.out.println(
                "         \\/____/                  ~~                       \\|___|                   \\/____/                  \\/____/                  \\/____/         ");

        System.out.println("Prihlásenie ");
    }

}