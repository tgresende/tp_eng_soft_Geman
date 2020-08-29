package main;


import java.sql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import connections.sqllConnection;

public class main implements ActionListener {
	
	Connection connection=null;
	int count = 0;
	JLabel label;

	public main() {
		connection = sqllConnection.dbConnector();
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Click me teste");
		button.addActionListener(this);
		
		label = new JLabel("Click in the button");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minha tela");
		frame.pack();
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
