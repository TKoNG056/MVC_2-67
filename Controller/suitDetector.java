package Controller;

import Model.*;

public class suitDetector {

    // ตรวจสอบว่าชุดทรงพลังมีความทนทานมากกว่าหรือเท่ากับ 70 หรือไม่
    public static boolean isPowerSuitDurabilityValid(String suitId) {
        Suit suit = new Suit();
        int durability = suit.getSuitDurability(suitId);
        
        if (durability >= 70) {
            return true;
        } else {
            System.out.println("ชุดทรงพลังไต้องมากกว่าหรือเท่ากับ 70");
            return false;
        }
    }

    // ตรวจสอบว่าชุดลอบเร้นมีความทนทานมากกว่าหรือเท่ากับ 50 หรือไม่
    public static boolean isStealthSuitDurabilityValid(String suitId) {
        Suit suit = new Suit();
        int durability = suit.getSuitDurability(suitId);

        if (durability >= 50) {
            return true;
        } else {
            System.out.println("ชุดลอบเร้นต้องมากกว่าหรือเท่ากับ 50");
            return false;
        }
    }

    // ตรวจสอบว่าชุดปกปิดตัวตนมีความทนทานที่ไม่ลงท้ายด้วยเลข 3 หรือ 7 หรือไม่
    public static boolean isSpySuitDurabilityValid(String suitId) {
        Suit suit = new Suit();
        int durability = suit.getSuitDurability(suitId);

        // ตรวจสอบว่าความทนทานไม่ลงท้ายด้วยเลข 3 หรือ 7
        if (durability % 10 == 3 || durability % 10 == 7) {
            System.out.println("ชุดปกปิดตัวตนไม่ลงท้ายด้วยเลข 3 หรือ 7");
            return false;
        } else {
            return true;
        }
    }

    // ฟังก์ชันตรวจสอบความทนทานของชุดทั้งหมด
    public boolean isSuitValid(String suitId) {
        String suitType = new Suit().getSuitTypeById(suitId);
        
        if (suitType == null) {
            System.out.println("ไม่พบชุด");
            return false;
        }

        boolean isValid = false;
        switch (suitType) {
            case "power":
                isValid = isPowerSuitDurabilityValid(suitId);
                break;
            case "stealth":
                isValid = isStealthSuitDurabilityValid(suitId);
                break;
            case "spy":
                isValid = isSpySuitDurabilityValid(suitId);
                break;
            default:
                System.out.println("ไม่พบประเภทของชุด");
                break;
        }

        return isValid;
    }
}
