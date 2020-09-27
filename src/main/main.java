package main;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UIComponents.menuButton;
import UIFunctions.panelFunctions;
import apresentacao.maquina_apresentacao;
import apresentacao.Usuario_selecao_apr;

public class main{
	
	Usuario_selecao_apr usuario_selecao = new Usuario_selecao_apr();
	maquina_apresentacao maquina_selecao  = new maquina_apresentacao();
	menuButton botao_menu = new menuButton();
	panelFunctions pnlFunc = new panelFunctions();
	JPanel mainPanel;
	
	ActionListener abrirTelaUsuario = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	JPanel panelusuario = new JPanel();
        	usuario_selecao.render(panelusuario);
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
	
	
	
	private void construirMenu(JPanel menuPanel) {
		menuPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		menuPanel.setLayout(new GridLayout(5,1));
		menuPanel.setBackground(Color.blue);
		
		JButton botao_usuario = botao_menu.getButton("Usuário",abrirTelaUsuario);
		menuPanel.add(botao_usuario);
		
		JButton botao_maquina = botao_menu.getButton("Máquina",abrirTelaMaquina);
		menuPanel.add(botao_maquina);
	}

	public main() {
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		
		construirMenu(menuPanel);		
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		mainPanel.setLayout(new GridLayout(0,1));

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
