package gui.tab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.downPanel.ReservationDownPanel;
import gui.main.MenuPage;
import gui.table_demo.TableSelectionDemo;
import gui.topPanel.SearchTopPanel;
import hospital.Main;
import hospital.reservation.ReservationMgr;

public class ReservationTab {
    private static ReservationTab reservationTab = null;
    ReservationTab() {}
    public static ReservationTab getInstance() {
        if (reservationTab == null)
            reservationTab = new ReservationTab();
        return reservationTab;
    }

    public static void startGUI() {
        Main hospitalmain = Main.getInstance();

        ReservationTab.getInstance().createAndShowReservation();
    }
    public JFrame reservationFrame = new JFrame("예약");
    private void createAndShowReservation() {
        setupResevationPane();

        reservationFrame.setBounds(100, 100, 720, 600);
        reservationFrame.setBackground(Color.WHITE);
        reservationFrame.add(reservationPane);
        reservationFrame.pack();
        reservationFrame.setLocationRelativeTo(null); // 창이 가운데 생성되도록
        reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reservationFrame.setResizable(false);

        reservationTop.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPage start = new MenuPage();
                reservationFrame.dispose();
            }
        });
    }
    //예방접종 예약 탭
    private JPanel reservationPane;
    TableSelectionDemo reservationTable = new TableSelectionDemo();
    public SearchTopPanel reservationTop = new SearchTopPanel();
    ReservationDownPanel reservationDown = new ReservationDownPanel();
    private void setupResevationPane() {
        reservationPane = new JPanel(new BorderLayout());
        reservationPane.setPreferredSize(new Dimension(720,600));

        reservationTop.setBackground(new Color(147, 251, 206));
        reservationDown.setBackground(Color.WHITE);
        //Create and set up the content pane.
        reservationTable.tableTitle = "reservation";
        reservationTable.addComponentsToPane(ReservationMgr.getInstance());  // 싱글톤
        reservationTop.setupTopPane(reservationTable);
        reservationPane.add(reservationTop, BorderLayout.NORTH);
        reservationPane.add(reservationTable, BorderLayout.CENTER);

        reservationDown.setupDownPane(reservationTable);
        reservationPane.add(reservationDown, BorderLayout.SOUTH);
    }
}