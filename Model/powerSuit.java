package Model;

import java.io.*;
import java.util.*;

public class powerSuit {
    private String heroSuitsFile = "Model/heroSuits.csv";

    // อ่านค่าความทนทานของ Power Suit ตาม ID
    public int getPowerSuitDurability(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(heroSuitsFile))) {
            String line;
            br.readLine(); // ข้ามหัวตาราง
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String suitId = data[0].trim();
                String suitType = data[1];
                int durability = Integer.parseInt(data[2].trim());

                if (suitId.equals(id) && suitType.equals("power")) {
                    return durability;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // ไม่พบชุดที่ต้องการ
    }

    // อัปเดตค่าความทนทานของ Power Suit ตาม ID
    public void setPowerSuitDurability(String id, int newDurability) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(heroSuitsFile))) {
            String line;
            // อ่านบรรทัดแรกเพื่อข้ามหัวตาราง
            br.readLine(); // ข้ามหัวตาราง
    
            // อ่านบรรทัดข้อมูลต่อไป
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String suitId = data[0].trim();
                String suitType = data[1];
                int durability = Integer.parseInt(data[2].trim()); // อ่าน durability
        
                // ถ้าชุดที่ตรงกับ ID และประเภท "Power" ให้ปรับ durability
                if (suitId.equals(id) && suitType.equals("power") && durability != -1) {
                    durability = Math.min(durability + 25, 100); // เพิ่ม durability 25 และไม่ให้เกิน 100
                    updated = true;
                }
        
                // เพิ่มข้อมูลที่อัปเดตกลับลงใน list
                lines.add(suitId + "," + suitType + "," + durability);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (updated) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(heroSuitsFile))) {
                // เขียนข้อมูลทั้งหมดกลับไปที่ไฟล์
                bw.write("ID,SuitType,Durability"); // เขียนหัวตาราง
                bw.newLine();
                for (String line : lines) {
                    bw.write(line); // เขียนข้อมูลใหม่ทั้งหมด
                    bw.newLine(); // ลงบรรทัดใหม่
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}