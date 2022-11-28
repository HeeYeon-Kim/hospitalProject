package table_demo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import hospital.Main;
import table_demo.GUIMain;
import table_demo.Login;
//import table_demo.ReceptionPane;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class MenuPage {

    static Login login;
    private static JFrame frame;
    static GUIMain main = GUIMain.getInstance();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/

        //showMenu();
    }

   /* public static void startGUI() {
        // 이벤트 처리 스레드를 만들고
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
                initialize();
            }
        });
    }*/

    /**
     * Create the application.
     */
    public MenuPage() {
        //	startGUI();

        initialize();
    }
/*
	public void showMenu(){

        login.dispose(); // 로그인창닫기
        frame.setVisible(true);
        initialize();

    }
  */
    /**
     * Initialize the contents of the frame.
     * setupReceptionPane();
     setupPatientPane();
     setupVaccinationPane();
     setupResevationPane();
     */
    public static void initialize() {
        frame = new JFrame("AH 소아과 관리 프로그램");
        frame.setBounds(100, 100, 440, 456);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        menuPanel.setLayout(null);

        JButton rcepButton = new JButton("접수");
        rcepButton.setBackground(Color.LIGHT_GRAY);
        rcepButton.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        rcepButton.setBounds(87, 144, 97, 60);
        rcepButton.setBackground(new Color(147, 251, 206));
        menuPanel.add(rcepButton);

        rcepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               main.receptionPane.setVisible(true);
               frame.dispose();// 창 안보이게 하기
            }
        });

        JButton rsvButton = new JButton("예약");
        rsvButton.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        rsvButton.setBounds(237, 144, 97, 60);
        rsvButton.setBackground(new Color(147, 251, 206));
        rsvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   main.setupReceptionPane();
                // setVisible(false); // 창 안보이게 하기
            }
        });
        menuPanel.add(rsvButton);

        JButton patiButton = new JButton("환자");
        patiButton.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        patiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        patiButton.setBounds(237, 268, 97, 60);
        patiButton.setBackground(new Color(147, 251, 206));
        menuPanel.add(patiButton);

        JButton docButton = new JButton("의사");
        docButton.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        docButton.setBounds(87, 268, 97, 60);
        docButton.setBackground(new Color(147, 251, 206));
        docButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        menuPanel.add(docButton);

        JLabel titelPanel = new JLabel("AH 소아과 관리 프로그램");
        titelPanel.setFont(new Font("수성돋움체", Font.BOLD, 16));
        titelPanel.setBounds(117, 48, 188, 65);
        menuPanel.add(titelPanel);

		/*
		JButton homeButton = new JButton(new ImageIcon("src/image/home.png"));
		homeButton.setText("Home");
		*/



        ImageIcon home = new ImageIcon("src/image/home.png");
        Image img = home.getImage();
        Image changeImg = img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon changelogo = new ImageIcon(changeImg);
        JButton homeButton = new JButton(changelogo);

        //homeButton.setOpaque(false);
        homeButton.setBounds(12, 10, 48, 49);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startPage start = new startPage();
                frame.dispose();
            }
        });
        menuPanel.add(homeButton);
        frame.setVisible(true);
    }
}