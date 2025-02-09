package View;

import Controller.fixSuit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fixView {

    public fixView(String suitId) {
        // สร้างหน้าต่างสำหรับซ่อมชุด
        JFrame frame = new JFrame("Repair Suit");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // สร้าง Label สำหรับแสดงข้อความ
        JLabel label = new JLabel("Suit have issue ID: " + suitId);
        frame.add(label);

        // สร้างปุ่มสำหรับซ่อมชุด
        JButton repairButton = new JButton("Repair Suit");
        repairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เมื่อกดปุ่ม ให้เรียกฟังก์ชันซ่อมชุด
                fixSuit repair = new fixSuit();
                repair.repairSuit(suitId); // ซ่อมชุดที่มี suitId ที่ส่งมา
                JOptionPane.showMessageDialog(frame, "Suit ID: " + suitId + " is repaired!");
            }
        });
        
        // เพิ่มปุ่มไปที่หน้าต่าง
        frame.add(repairButton);

        // แสดงหน้าต่าง
        frame.setVisible(true);
    }
}
