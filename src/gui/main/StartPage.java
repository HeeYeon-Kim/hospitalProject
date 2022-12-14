package gui.main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartPage {

    private JFrame frame;
    public StartPage() {

        initialize();
    }

    private void initialize() {

        frame = new JFrame("AH 소아과 관리 프로그램");
        frame.setBackground(Color.ORANGE);
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(900,600);
        frame.setResizable(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        frame.setPreferredSize(new Dimension(450, 300));
        frame.getContentPane().add(titlePanel, BorderLayout.CENTER);
        titlePanel.setLayout(null);

        JLabel titleLable = new JLabel("AH 소아과 관리 프로그램");
        titleLable.setBounds(266, 74, 359, 40);
        titleLable.setFont(new Font("수성돋움체", Font.BOLD, 30));
        titlePanel.add(titleLable);

        ImageIcon logo = new ImageIcon("src\\image\\logo.png");
        Image img = logo.getImage();
        Image changeImg = img.getScaledInstance(359, 286, Image.SCALE_SMOOTH);
        ImageIcon changelogo = new ImageIcon(changeImg);
        JLabel logoImg = new JLabel(changelogo);
        logoImg.setBounds(266, 124, 359, 286);
        titlePanel.add(logoImg);

        ImageIcon chicken = new ImageIcon("src/image/chicken.png");
        Image img2 = chicken.getImage();
        Image changeImg2 = img2.getScaledInstance(163, 150, Image.SCALE_SMOOTH);
        ImageIcon changelogo2 = new ImageIcon(changeImg2);
        JLabel chickenImg2 = new JLabel(changelogo2);
        chickenImg2.setBounds(670, 364, 163, 150);
        titlePanel.add(chickenImg2);

        ImageIcon flower = new ImageIcon("src/image/flower.png");
        Image img3 = flower.getImage();
        Image changeImg3 = img3.getScaledInstance(230, 123, Image.SCALE_SMOOTH);
        ImageIcon changelogo3 = new ImageIcon(changeImg3);
        JLabel flowerImg3 = new JLabel(changelogo3);
        flowerImg3.setBounds(43, 391, 230, 123);
        titlePanel.add(flowerImg3);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.CYAN);
        loginButton.setFont(new Font("수성돋움체", Font.BOLD, 20));
        loginButton.setForeground(Color.BLACK);
        loginButton.setBounds(388, 440, 116, 40);
        loginButton.setBackground(new Color(147, 251, 206));
        titlePanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login login = new Login(); // 로그인창 보이기
                login.setVisible(true);
            }
        });
        frame.setLocationRelativeTo(null); // 창이 가운데 생성되도록
        frame.setVisible(true);
    }
}