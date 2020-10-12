package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UIComponents.ButtonsContainer;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.SelectionContainer;
import UIComponents.primaryButton;
import UIFunctions.panelFunctions;
import logica.MaquinaLogica;

public class Maquina_selecao_apr {
	
	MaquinaLogica _maquina_logica;
	List<JButton> buttonList;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	JButton btnInsert;
	JButton btnEdit;
	JButton btnDelete;
	Method _a;
	
	Maquina_edicao_apr  maquina_edicao_apr = new Maquina_edicao_apr();
	panelFunctions pnlFunc = new panelFunctions();
	
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
	
	ActionListener deleteRegister  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	};
	
	ActionListener editRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	ActionListener newRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public JPanel render() {
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Máquinas", backbutton);
		JPanel buttonContainer = new ButtonsContainer().getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		mainContainer = new JPanel();
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = _maquina_logica.getModelList();
		tablePanel =new JPanel();
		tablePanel.setLayout(new GridLayout(1,1));
		table = new JTable(model);
		rollBar = new JScrollPane(table);
		tablePanel.add(rollBar);
		
		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}
	
	public Maquina_selecao_apr() {
		backbutton = new GoBackButton().getButton(goBackAction);
		btnInsert = new primaryButton().getButton("Inserir", newRegister);
		btnEdit = new primaryButton().getButton("Editar", editRegister);
		btnDelete = new primaryButton().getButton("Excluir", deleteRegister);
		_maquina_logica = new MaquinaLogica();
		buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}
}
