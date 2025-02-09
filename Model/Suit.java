package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Suit {

    private String heroSuitsFile = "Model/heroSuits.csv";

    // ฟังก์ชันรับ ID แล้วคืนค่า SuitType
    public String getSuitTypeById(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(heroSuitsFile))) {
            String line;
            br.readLine(); // ข้ามหัวตาราง
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String suitId = data[0].trim();
                String suitType = data[1];

                if (suitId .equals(id)) {
                    return suitType;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // ถ้าไม่พบชุด
    }


    // ฟังก์ชันอัปเดต Durability ของชุดตาม ID และ SuitType
    public void updateSuitDurability(String id, int newDurability) {
        String suitType = getSuitTypeById(id);

        if (suitType == null) {
            System.out.println("ไม่พบชุดที่มี ID นี้");
            return;
        }

        switch (suitType) {
            case "power":
                new powerSuit().setPowerSuitDurability(id, newDurability);
                break;
            case "spy":
                new spySuit().setSpySuitDurability(id, newDurability);
                break;
            case "stealth":
                new stealthSuit().setStealthSuitDurability(id, newDurability);
                break;
            default:
                System.out.println("ไม่พบประเภทของชุด");
        }
    }

    // ฟังก์ชันที่รับ ID แล้วคืนค่า Durability ของชุดที่ตรงกับ SuitType
    public int getSuitDurability(String id) {
        String suitType = getSuitTypeById(id);
        if (suitType == null) {
            return -1; // ไม่พบชุด
        }

        switch (suitType) {
            case "power":
                return new powerSuit().getPowerSuitDurability(id);
            case "spy":
                return new spySuit().getSpySuitDurability(id);
            case "stealth":
                return new stealthSuit().getStealthSuitDurability(id);
            default:
                return -1; // ไม่พบประเภทของชุด
        }
    }
}
