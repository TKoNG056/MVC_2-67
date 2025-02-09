package Controller;

import Model.*;

public class fixSuit {

    public void repairSuit(String suitId) {
        Suit suit = new Suit();
        int currentDurability = suit.getSuitDurability(suitId);

        int newDurability = currentDurability + 25;
        System.out.println(newDurability);

        System.out.println("กำลังซ่อมชุด ID: " + suitId + " ให้ความทนทานเป็น" + newDurability+"สูงสุดที่100");
        suit.updateSuitDurability(suitId, newDurability);
        System.out.println("ชุด ID: " + suitId + " ได้รับการซ่อมแซมเรียบร้อย");

    }

    // public static void main(String[] args) {
    //     String suitId = "200002"; // Example suit ID
    //     fixSuit repair = new fixSuit();
    //     repair.repairSuit(suitId);
    // }
}
