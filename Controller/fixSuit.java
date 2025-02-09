package Controller;

import Model.*;

public class fixSuit {

    // ฟังก์ชันซ่อมชุดโดยการอัปเดตค่าความทนทานของชุดเป็น 100
    public void repairSuit(String suitId) {
        // ตรวจสอบว่า Suit ID มีอยู่ในระบบหรือไม่
        if (inputValidator.isSuitHere(suitId)) {
            // ค้นหาประเภทชุดโดยใช้ ID
            Suit suit = new Suit();
            int currentDurability = suit.getSuitDurability(suitId);

            if (currentDurability == -1) {
                System.out.println("ไม่พบชุดที่มี ID นี้");
                return;
            }

            // ซ่อมชุดโดยการตั้งค่าความทนทานให้เป็น 100
            System.out.println("กำลังซ่อมชุด ID: " + suitId + " ให้ความทนทานเป็น 100");
            suit.updateSuitDurability(suitId, 100);
            System.out.println("ชุด ID: " + suitId + " ได้รับการซ่อมแซมเรียบร้อย");
        } else {
            System.out.println("ไม่พบชุดที่มี ID นี้");
        }
    }
}
