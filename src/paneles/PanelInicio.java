package paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JProgressBar;

public class PanelInicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelInicio window = new PanelInicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de librería");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon((Icon) new ImageIcon("/Users/raulsantiago/workspace-eclipse/BibliotecaSanta/cafelibro.jpg").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/raulsantiago/workspace-eclipse/BibliotecaSanta/cafelibro.jpg"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(new Color(238, 238, 238));
		progressBar.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 5;
		gbc_progressBar.gridy = 7;
		panel.add(progressBar, gbc_progressBar);
		
		JLabel lblCreadoPorRaul = new JLabel("Creado por: Raul Santiago Prieto");
		lblCreadoPorRaul.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCreadoPorRaul = new GridBagConstraints();
		gbc_lblCreadoPorRaul.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreadoPorRaul.gridx = 5;
		gbc_lblCreadoPorRaul.gridy = 8;
		panel.add(lblCreadoPorRaul, gbc_lblCreadoPorRaul);
	}

}
