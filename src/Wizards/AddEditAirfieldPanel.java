/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wizards;

/**
 *
 * @author Noah Fujioka, Alec
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;


public class AddEditAirfieldPanel extends JFrame {
    private AirfieldPanel AirfieldPanel;
    private RunwayPanel RunwayPanel;
    private PositionPanel PositionPanel;
    private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditAirfieldPanel frame = new AddEditAirfieldPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEditAirfieldPanel() {
		AirfieldPanel = new AirfieldPanel();
		RunwayPanel = new RunwayPanel();
		PositionPanel = new PositionPanel();
		
		setTitle("New Airfield Wizard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Submit");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		panel.add(btnNewButton_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Airfield", AirfieldPanel);
		tabbedPane.addTab("Runway", RunwayPanel);
		tabbedPane.addTab("Position", PositionPanel);
	}

}
