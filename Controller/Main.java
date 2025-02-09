package Controller;
public class Main {
    public static void main(String[] args) {
        String suitId = "100004"; // Example suit ID
        boolean exists = inputValidator.isSuitHere(suitId);
        
        if (exists) {
            System.out.println("Suit exists!");
        } else {
            System.out.println("Suit not found.");
        }
    }
}
