package main;


import java.sql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UIComponents.primaryButton;
import apresentacao.maquina_apresentacao;
import apresentacao.usuario_apresentacao;
import connections.sqllConnection;

public class main implements ActionListener {
	
	usuario_apresentacao usuario_Apr = new usuario_apresentacao();
	maquina_apresentacao maquina_Apr = new maquina_apresentacao();
	
	Connection connection=null;
	int count = 0;
	JLabel label, labelForm;

	public main() {
		connection = sqllConnection.dbConnector();
		JFrame frame = new JFrame();
		
		
		JPanel panelusuario = usuario_Apr.render();
		JPanel panelmaquina = maquina_Apr.render();
		
		label = new JLabel("Click in the button");
		labelForm = new JLabel("Form chamado");
		
		primaryButton buttonprimary = new primaryButton();
		
		JButton button = new JButton("Click me teste de pull");
		JButton menuButton = new JButton("Alterar Form");
		//JButton testebutton = buttonprimary.getButton("botao de teste");
		menuButton.setSize(new Dimension(100,100));
		
		JPanel panelForm = new JPanel();
		panelForm.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panelForm.setLayout(new GridLayout(0,1));
		panelForm.add(labelForm);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		//panel.add(testebutton);
		panel.add(label);

		button.addActionListener(this);
		menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panel.removeAll();
            	panel.revalidate();
            	panel.repaint();
            	panel.add(panelusuario);
                JOptionPane.showMessageDialog(null, "teste");
            }
        });
		
		
		
		
		
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		mainPanel.setLayout(new GridLayout(5,1));
		mainPanel.setBackground(Color.blue);
		mainPanel.add(menuButton);
	
		
		frame.add(panel, BorderLayout.CENTER);
		frame.add(mainPanel, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minha tela");
		frame.setSize(new Dimension(800, 500));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new main();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText(count + " times clicked");
		
		try {
			String query = "Select * from teste";
			String update = "insert into teste (NOME) values ('teste de insert')";
			PreparedStatement pst = connection.prepareStatement(query);
			PreparedStatement pst_upd = connection.prepareStatement(update);
		   // pst.setString(0, label.getText()); //para passar os parametros, o zero indica o index do ? na query "Select * from teste	where x=? and y=?" 
			
			ResultSet res = pst.executeQuery();
		 	pst_upd.executeUpdate();
			
		
			while(res.next())
				count++;
			
			res.close();
			pst.close();
			
			label.setText(count + " rows encountered");
			
		}catch(Exception excep) {
			JOptionPane.showMessageDialog(null,excep);
		}
	}

}
