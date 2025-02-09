package View;

import Model.Suit;
import javax.swing.*;
import java.awt.*;

public class suitView {


    public suitView(String suitId) {
        // สร้าง Frame หรือ Window สำหรับแสดงข้อมูลชุด
        JFrame frame = new JFrame("Suit Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // ดึงข้อมูลจาก Suit Model ตาม suitId
        Suit suit = new Suit();
        String suitType = suit.getSuitTypeById(suitId);
        int durability = suit.getSuitDurability(suitId);

        if (suitType != null && durability != -1) {
            // สร้าง Label แสดงข้อมูลชุด
            JLabel suitInfo = new JLabel("Suit ID: " + suitId);
            JLabel typeInfo = new JLabel("Type: " + suitType);
            JLabel durabilityInfo = new JLabel("Durability: " + durability);

            // เพิ่มข้อมูลไปที่ Frame
            frame.add(suitInfo);
            frame.add(typeInfo);
            frame.add(durabilityInfo);
        } else {
            JLabel errorMessage = new JLabel("Invalid Suit ID or No data found.");
            frame.add(errorMessage);
        }

        // แสดง Frame
        frame.setVisible(true);
    }
}
