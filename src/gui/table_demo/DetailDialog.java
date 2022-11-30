package gui.table_demo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import facade.UIData;
import gui.main.GUIMain;
import hospital.reservation.ReservationMgr;

import java.awt.BorderLayout;
import java.util.List;

public class DetailDialog extends javax.swing.JDialog {
	DefaultTableModel tableModel;
	String[] itemDetails;
	String[] patientDetails;
	DefaultTableModel model;
	int selectedIndex = -1;
	JTable table;
	JScrollPane scroll;

	ReservationMgr rMgr = new ReservationMgr();

	String title[] = { "백신종류", "1차", "2차", "3차", "추4차", "추5차", "추6차" };
	String data[][] = { { "BCG" }, { "HepB" }, { "DTaP" }, { "Tdap" }, { "IPV" }, { "Hib" }, { "PCV" }, { "MMR" },
			{ "VAR" }, { "HepA" }, { "IJEV" }, { "LJEV" }, { "RV1" }, { "RV5" } };

	JLabel details[] = new JLabel[5];

	DetailDialog(String[] texts) {
		super(GUIMain.mainFrame);
		itemDetails = texts;
	}

	void setup() {
		setTitle("예방접종현황");

		JPanel pane = new JPanel(new BorderLayout());
		model = new DefaultTableModel(title, 14);
		table = new JTable(model);

		scroll = new JScrollPane(table);
		add(scroll);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				table.setValueAt(data[i][j], i, j); // data값을 i번 행, j번 열에 넣어라
			}
		}

		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> reservationList = rMgr.search(itemDetails[0]);
		tableModel.setRowCount(0);
		for (Object r : reservationList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
    
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		for(int k=0; k<reservationList.size(); k++) {
			String symtom = (String) jtable.getValueAt(k, 3);

			if (symtom.contains("BCG")) {
				if (itemDetails[2].contains("6차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 0, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 0, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 0, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 0, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 0, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 0, 1);
			}

			if (symtom.contains("HepB")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 1, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 1, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 1, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 1, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 1, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 1, 1);
			}

			if (symtom.contains("DTaP")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 2, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 2, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 2, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 2, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 2, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 2, 1);
			}

			if (symtom.contains("Tdap")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 3, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 3, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 3, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 3, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 3, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 3, 1);
			}

			if (symtom.contains("IPV")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 4, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 4, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 4, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 4, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 4, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 4, 1);
			}

			if (symtom.contains("Hib")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 5, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 5, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 5, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 5, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 5, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 5, 1);
			}

			if (symtom.contains("PCV")) {
				if (itemDetails[2].contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 6, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 6, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 6, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 6, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 6, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 6, 1);
			}

			if (symtom.contains("MMR")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 7, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 7, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 7, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 7, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 7,  i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 7, 1);
			}

			if (symtom.contains("VAR")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 8, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 8, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 8, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 8, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 8, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 8, 1);
			}

			if (symtom.contains("HepA")) {
				if (itemDetails[2].contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 9, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 9, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 9, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 9, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 9, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 9, 1);
			}

			if (symtom.contains("IJEV")) {
				if (itemDetails[2].contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 10, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 10, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 10, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 10, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 10, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 10, 1);
			}

			if (symtom.contains("LJEV")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 11, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 11, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 11, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 11, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 11, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 11, 1);
			}

			if (symtom.contains("RV1")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 12, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 12, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 12, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 12, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 12, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 12, 1);
			}

			if (symtom.contains("RV5")) {
				if (symtom.contains("6차"))
					for (int i = 1; i <= 6; i++) {
						table.setValueAt("O", 13, i);
					}
				if (symtom.contains("5차"))
					for (int i = 1; i <= 5; i++) {
						table.setValueAt("O", 13, i);
					}
				if (symtom.contains("4차"))
					for (int i = 1; i <= 4; i++) {
						table.setValueAt("O", 13, i);
					}
				if (symtom.contains("3차"))
					for (int i = 1; i <= 3; i++) {
						table.setValueAt("O", 13, i);
					}
				if (symtom.contains("2차"))
					for (int i = 1; i <= 2; i++) {
						table.setValueAt("O", 13, i);
					}
				if (symtom.contains("1차"))
					table.setValueAt("O", 13, 1);
			}
		
		}
		pack();
		setVisible(true);
	}
}
