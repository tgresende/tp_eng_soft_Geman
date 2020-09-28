package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.ButtonsContainer;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.TextFieldContainer;
import UIComponents.primaryButton;
import UIComponents.primaryLabel;
import UIComponents.primaryTextField;

public class Maquina_edicao_apr {
	JPanel mainContainer = new JPanel();
	
	ActionListener actionInserir = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Insere os dados dos campos de texto no banco de dados	
		}
		
	};
	
	ActionListener actionSalvar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Insere os dados dos campos de texto no banco de dados	
		}
		
	};
	
	ActionListener goBackAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// Implementar ação para o botão GoBackButton	
		}
	};
	
	public JPanel render() {
		JButton backbutton = new GoBackButton().getButton(goBackAction);
		JButton btnInserir = new primaryButton().getButton("Inserir", actionInserir);
		JButton btnSalvar = new primaryButton().getButton("Salvar", actionSalvar);
		primaryTextField textprimary = new primaryTextField();
		
		
		primaryLabel lbPrimary = new primaryLabel();
		
		JLabel lbId = lbPrimary.getLabel("Id:");
		JTextField idtext = textprimary.getTextField("Inserir");
		
		JLabel lbNome = lbPrimary.getLabel("Nome:");
		JTextField nometext = textprimary.getTextField("Inserir");
		
		JLabel lbFabricante = lbPrimary.getLabel("Fabricante:");
		JTextField fabricantetext = textprimary.getTextField("Inserir");
		
		JLabel lbModelo = lbPrimary.getLabel("Modelo:");
		JTextField modelotext = textprimary.getTextField("Inserir");
		
		
		
		List<JTextField> textFieldList = new ArrayList<>();
		textFieldList.add(idtext);
		textFieldList.add(nometext);
		textFieldList.add(fabricantetext);
		textFieldList.add(modelotext);
		
		List<JLabel> labelList = new ArrayList<>();
		labelList.add(lbId);
		labelList.add(lbNome);
		labelList.add(lbFabricante);
		labelList.add(lbModelo);
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(btnInserir);
		buttonList.add(btnSalvar);
		
		//Cria cabeçalho
		JPanel header = new Header().getHeader("Máquinas", backbutton);
		JPanel buttonContainer = new ButtonsContainer().getContainer(buttonList);
		JPanel textFieldContainer = new TextFieldContainer().getContainer(textFieldList, labelList);
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		
		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(textFieldContainer);
	
		return mainContainer;
	}
	
	
	
	
}
