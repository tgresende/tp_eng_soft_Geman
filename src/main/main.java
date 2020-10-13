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
import presentation.OS_selecao_apr;
import presentation.Relatorio_selecao_apr;
import presentation.TechnicianSelectionPresentation;

public class main{
	
	TechnicianSelectionPresentation usuario_selecao = new TechnicianSelectionPresentation();
	EquipmentSelectionPresentation maquina_selecao  = new EquipmentSelectionPresentation();
	OS_selecao_apr OS_selecao = new OS_selecao_apr();
	Relatorio_selecao_apr relatorio_selecao = new Relatorio_selecao_apr();
	menuButton botao_menu = new menuButton();
	panelFunctions pnlFunc = new panelFunctions();
	JPanel mainPanel;
	
	ActionListener abrirTelaUsuario = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JPanel panelusuario = usuario_selecao.render();
        	pnlFunc.telaConstructor(mainPanel, panelusuario);
        	
        }
	};
	
	ActionListener abrirTelaMaquina = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JPanel panelmaquina = maquina_selecao.render();
        	pnlFunc.telaConstructor(mainPanel, panelmaquina);
        	
        }
	};
	
	ActionListener abrirTelaOS = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JPanel panelOS = OS_selecao.render();
			pnlFunc.telaConstructor(mainPanel, panelOS);		
		}
		
	};
	
	ActionListener abrirTelaRelatorio = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JPanel panelRelatorio = relatorio_selecao.render();	
			pnlFunc.telaConstructor(mainPanel, panelRelatorio);
		}
	};
	
	private void construirMenu(JPanel menuPanel) {
		menuPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

		
		menuPanel.setBackground(Color.white);
		JButton botao_usuario = botao_menu.getButton("Técnico",abrirTelaUsuario);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		menuPanel.add(botao_usuario);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton botao_maquina = botao_menu.getButton("Máquinas",abrirTelaMaquina);
		menuPanel.add(botao_maquina);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton botao_OS = botao_menu.getButton("OS", abrirTelaOS);
		menuPanel.add(botao_OS);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

		JButton botao_Relatorio = botao_menu.getButton("Relatórios", abrirTelaRelatorio);
		menuPanel.add(botao_Relatorio);
		menuPanel.add(Box.createRigidArea(new Dimension(0,50)));

	}
	
	public main() {
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		
		construirMenu(menuPanel);		
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		mainPanel.setLayout(new GridLayout(0,1));
		mainPanel.setBackground(Color.white);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		mainPanel.setBorder(blackline);

		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(menuPanel, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Gerenciamento de Manutenção");
		frame.setSize(new Dimension(800, 500));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new main();
	}
}
