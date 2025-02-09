package Model;

public class Main {
    public static void main(String[] args) {
        powerSuit suit = new powerSuit();

        String suitId = "100004"; // ตัวอย่าง ID ที่มีปัญหา
        int durability = suit.getPowerSuitDurability(suitId);
        
        System.out.println("Power Suit ID: " + suitId);
        System.out.println("Durability: " + durability);
        
    }
}
