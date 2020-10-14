package main;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UIComponents.menuButton;
import UIFunctions.panelFunctions;
import presentation.EquipmentSelectionPresentation;
import presentation.OrderServiceSelectionPresentation;
import presentation.Relatorio_selecao_apr;
import presentation.TechnicianSelectionPresentation;

public class main{
	
	TechnicianSelectionPresentation technicianSelection = new TechnicianSelectionPresentation();
	EquipmentSelectionPresentation equipmentSelection  = new EquipmentSelectionPresentation();
	OrderServiceSelectionPresentation orderServiceSelection = new OrderServiceSelectionPresentation();
	Relatorio_selecao_apr reportSelection = new Relatorio_selecao_apr();
	menuButton menuButton = new menuButton();
	panelFunctions pnlFunc = new panelFunctions();
	JPanel mainPanel;
	
	ActionListener openTechnicianScreen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JPanel pnlTechnician = technicianSelection.render(openTechnicianScreen);
        	pnlFunc.telaConstructor(mainPanel, pnlTechnician);
        	
        }
	};
	
	ActionListener openEquipmentScreen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JPanel pnlEquipment = equipmentSelection.render();
        	pnlFunc.telaConstructor(mainPanel, pnlEquipment);
        	
        }
	};
	
	ActionListener openOrderServiceScreen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JPanel pnlOrderService = orderServiceSelection.render();
			pnlFunc.telaConstructor(mainPanel, pnlOrderService);		
		}
		
	};
	
	ActionListener openReportScreen = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JPanel pnlReport = reportSelection.render();	
			pnlFunc.telaConstructor(mainPanel, pnlReport);
		}
	};
	
	private void buildMenu(JPanel menuPanel) {
		menuPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.white);
		JButton technicianButton = menuButton.getButton("T�cnico",openTechnicianScreen);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		menuPanel.add(technicianButton);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton equipmentButton = menuButton.getButton("M�quinas",openEquipmentScreen);
		menuPanel.add(equipmentButton);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton orderServiceButton = menuButton.getButton("OS", openOrderServiceScreen);
		menuPanel.add(orderServiceButton);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton reportButton = menuButton.getButton("Relat�rios", openReportScreen);
		menuPanel.add(reportButton);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

	}
	
	public main() {
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		
		buildMenu(menuPanel);		
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		mainPanel.setLayout(new GridLayout(0,1));
		mainPanel.setBackground(Color.white);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		mainPanel.setBorder(blackline);

		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(menuPanel, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Gerenciamento de Manuten��o");
		frame.setSize(new Dimension(800, 500));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new main();
	}
}
