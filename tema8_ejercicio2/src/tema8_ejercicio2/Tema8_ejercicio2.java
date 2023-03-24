package tema8_ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Tema8_ejercicio2 {

	
	private JFrame frmTemaejercicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tema8_ejercicio2 window = new Tema8_ejercicio2();
					window.frmTemaejercicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tema8_ejercicio2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTemaejercicio = new JFrame();
		frmTemaejercicio.setTitle("Tema8_ejercicio2");
		frmTemaejercicio.setBounds(100, 100, 616, 387);
		frmTemaejercicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTemaejercicio.getContentPane().setLayout(null);
		
		String url = "jdbc:mysql://20.15.25.117:3306/tema8_ejercicio2";
		String user = "alumno";
		String password = "alumno";

		
		JLabel lblComunidadAutnoma = new JLabel("Comunidad Autónoma:");
		lblComunidadAutnoma.setBounds(73, 56, 184, 15);
		frmTemaejercicio.getContentPane().add(lblComunidadAutnoma);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(346, 56, 104, 15);
		frmTemaejercicio.getContentPane().add(lblProvincia);
		
		JComboBox comboBoxComAut = new JComboBox();
		comboBoxComAut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxComAut.getSelectedIndex() == 0) {
					try {
						Connection con = DriverManager.getConnection(url, user, password);
						PreparedStatement sel_pstmt = con.prepareStatement("SELECT nomc FROM comunidad WHERE id = 1");
						ResultSet rs_sel = sel_pstmt.executeQuery();
						while (rs_sel.next()) {
							int nomc = rs_sel.getInt("nomc");
						}
						rs_sel.close();
						sel_pstmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (comboBoxComAut.getSelectedIndex() == 1) {
					try {
						Connection con = DriverManager.getConnection(url, user, password);
						PreparedStatement sel_pstmt = con.prepareStatement("SELECT nomc FROM comunidad WHERE id = 2");
						ResultSet rs_sel = sel_pstmt.executeQuery();
						while (rs_sel.next()) {
							int nomc = rs_sel.getInt("nomc");
						}
						rs_sel.close();
						sel_pstmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						Connection con = DriverManager.getConnection(url, user, password);
						PreparedStatement sel_pstmt = con.prepareStatement("SELECT nomc FROM comunidad WHERE id = 3");
						ResultSet rs_sel = sel_pstmt.executeQuery();
						while (rs_sel.next()) {
							int nomc = rs_sel.getInt("nomc");
						}
						rs_sel.close();
						sel_pstmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
	
		comboBoxComAut.setModel(new DefaultComboBoxModel(new String[] {"Comunidad Valenciana", "Andalucía", "Castilla la Mancha"}));
		comboBoxComAut.setBounds(73, 94, 171, 24);
		frmTemaejercicio.getContentPane().add(comboBoxComAut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Valencia", "Castellón ", "Alicante"}));
		comboBox.setBounds(346, 94, 155, 24);
		frmTemaejercicio.getContentPane().add(comboBox);
	}
}
