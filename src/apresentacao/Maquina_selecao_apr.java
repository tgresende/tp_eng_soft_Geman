package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import UIComponents.ButtonsContainer;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.SelectionContainer;
import UIComponents.primaryButton;
import UIComponents.primaryTextField;
import UIFunctions.panelFunctions;

public class Maquina_selecao_apr {
	
	Maquina_edicao_apr  maquina_edicao_apr = new Maquina_edicao_apr();
	panelFunctions pnlFunc = new panelFunctions();
	JPanel mainContainer = new JPanel();
	
	
	ActionListener abrirTelaMaquinaEdicao = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JPanel panelmaquina = maquina_edicao_apr.render();
			pnlFunc.telaConstructor(mainContainer, panelmaquina);
		}
	};
	
	ActionListener goBackAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// Implementar ação para o botão GoBackButton	
		}
	};
	
	ActionListener actionExcluir = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Implemetar acão para o botão excluir
			
		}
	};
	
	
	public JPanel render() {
		JButton backbutton = new GoBackButton().getButton(goBackAction);
		JButton btnInsert = new primaryButton().getButton("Inserir", abrirTelaMaquinaEdicao);
		JButton btnDelete = new primaryButton().getButton("Excluir", actionExcluir);
		
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnDelete);
		
		
		JPanel header = new Header().getHeader("Máquinas", backbutton);
		JPanel buttonContainer = new ButtonsContainer().getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		
		
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		
		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		return mainContainer;
		
		/**
		primaryButton buttonprimary = new primaryButton();
		primaryTextField textprimary = new primaryTextField();
		JTextField txtTeste = textprimary.getTextField("Inserir");
		JButton testebutton = buttonprimary.getButton("Inserir", abrirTelaMaquinaEdicao);
		painel.add(testebutton);
		painel.add(txtTeste);
		return painel;
		*/
	}
}
