package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import UIComponents.primaryButton;

	public class maquina_apresentacao {
		primaryButton buttonprimary = new primaryButton();
		
	public JPanel render() {
			
			JPanel painel = new JPanel();
			ActionListener action = new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			};
			
			JButton btnmaquinas = buttonprimary.getButton("botao de maquina", action);
			painel.add(btnmaquinas);
			
			return painel;
	}

}
