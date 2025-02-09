package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;

public class mainView {
    private suitDetector detector = new suitDetector();
    private inputValidator inputValidator = new inputValidator();

    public void mainWindow() {
    
        // สร้าง Frame หรือ Window
        JFrame frame = new JFrame("Suit ID Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // สร้าง Label และ TextField สำหรับรับค่า suitId
        JLabel suitIdLabel = new JLabel("Enter Suit ID:");
        JTextField suitIdField = new JTextField(15);
        JButton checkButton = new JButton("Check Suit");

        // เพิ่ม listener สำหรับปุ่ม Check Suit
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String suitId = suitIdField.getText();
                if (inputValidator.isSuitHere(suitId) && inputValidator.isSuitHere(suitId)) {
                    JOptionPane.showMessageDialog(frame, "Suit ID is valid!");
                    if(detector.isSuitValid(suitId) ){
                        new suitView(suitId);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Suit is broken!");
                        new fixView(suitId);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Suit ID!");
                }
            }
        });

        // เพิ่มส่วนต่างๆ ลงใน Frame
        frame.add(suitIdLabel);
        frame.add(suitIdField);
        frame.add(checkButton);

        // แสดง Frame
        frame.setVisible(true);
    }
}
