package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.primaryButton;
import UIComponents.primaryTextField;

public class Maquina_edicao_apr {
	
	ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Insere os dados dos campos de texto no banco de dados	
		}
		
	};
	
	
	public JPanel render() {
		primaryButton buttonprimary = new primaryButton();
		primaryTextField textprimary = new primaryTextField();
		JButton testebutton = buttonprimary.getButton("Inserir", action);
		JTextField idtext = textprimary.getTextField("Inserir");
		JTextField nometext = textprimary.getTextField("Inserir");
		JTextField fabricantetext = textprimary.getTextField("Inserir");
		JTextField modelotext = textprimary.getTextField("Inserir");
		JPanel painel= new JPanel();
		painel.add(testebutton);
		painel.add(idtext);
		painel.add(nometext);
		painel.add(fabricantetext);
		painel.add(modelotext);
		
		return painel;
	}
	
	
	
	
}
