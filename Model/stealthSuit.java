package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class stealthSuit {
    
    private String heroSuitsFile = "Model/heroSuits.csv";
    
    // อ่านค่าความทนทานของ Stealth Suit ตาม ID
    public int getStealthSuitDurability(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(heroSuitsFile))) {
            String line;
            br.readLine(); // ข้ามหัวตาราง
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String suitId = data[0].trim();
                String suitType = data[1];
                int durability = Integer.parseInt(data[2].trim());

                if (suitId.equals(id) && suitType.equals("stealth")) {
                    return durability;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // ไม่พบชุดที่ต้องการ
    }

    // อัปเดตค่าความทนทานของ Stealth Suit ตาม ID
    public void setStealthSuitDurability(String id, int newDurability) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(heroSuitsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String suitId = data[0].trim();
                String suitType = data[1];
                int durability = Integer.parseInt(data[2].trim());

                if (suitId.equals(id) && suitType.equals("stealth")) {
                    durability = Math.min(newDurability, 100); // ค่าทนทานสูงสุดคือ 100
                    updated = true;
                }
                lines.add(suitId + "," + suitType + "," + durability);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(heroSuitsFile))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine(); // เพิ่มการขึ้นบรรทัดใหม่
                }
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
}
