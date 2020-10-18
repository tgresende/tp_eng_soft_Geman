package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UIComponents.ButtonsContainer;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.SelectionContainer;
import UIComponents.Table;
import UIComponents.PrimaryButton;
import UIFunctions.PanelFunctions;
import business.TechnicianBusiness;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianSelectionPresentation {

	
	
	TechnicianBusiness technicianBusiness;
	TechnicianEditionPresentation usuarioEdicao;

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
	
	ActionListener goBackAction;
	

	public JPanel render(ActionListener goBackAction) {
		JPanel tablePanel;
		this.goBackAction = goBackAction; 
		JPanel header = Header.getHeader("Usuários",backbutton);
		JPanel buttonContainer =  ButtonsContainer.getContainer(buttonList);
		JScrollPane contentContainer = SelectionContainer.getPanel();
		mainContainer = new JPanel();
		mainContainer.setOpaque(false);

		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = technicianBusiness.getModelList();
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1, 1));
		table = Table.getTable(model);

		rollBar = new JScrollPane(table);
		tablePanel.add(rollBar);

		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}


	ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<TechnicianDAOPresentationBusiness> usuarios = technicianBusiness.getList();
        	for(TechnicianDAOPresentationBusiness usuario : usuarios){
        		JOptionPane.showMessageDialog(null, usuario.getName());
        	}
        	
        }
	};
	
	ActionListener deleteRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1) {
        		JOptionPane.showMessageDialog(null, "Selecione um registro primeiro para deletar.");
        		return;
        	}
        	
        	technicianBusiness.delete((int)table.getValueAt(table.getSelectedRow(), 0));
        	model.removeRow(table.getSelectedRow());
        }
        
	};
	
	ActionListener editRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1) {
        		JOptionPane.showMessageDialog(null, "Selecione um registro primeiro para editar.");
        		return;
        	}
        	int id = (int)table.getValueAt(table.getSelectedRow(), 0);
        	usuarioEdicao = new TechnicianEditionPresentation();
        	JPanel panelEdicao = usuarioEdicao.render(id, goBackAction);
        	PanelFunctions.panelConstructor(mainContainer, panelEdicao);
        }
	};
	
	ActionListener newRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	usuarioEdicao = new TechnicianEditionPresentation();
        	JPanel panelEdicao = usuarioEdicao.render(0, goBackAction);
        	PanelFunctions.panelConstructor(mainContainer, panelEdicao);
        	
        }
	};
	
		
	public TechnicianSelectionPresentation() {
		backbutton = new GoBackButton().getButton(goBackAction);
		btnInsert = PrimaryButton.getButton("Inserir", newRegister);
		btnEdit = PrimaryButton.getButton("Editar", editRegister);
		btnDelete = PrimaryButton.getButton("Excluir", deleteRegister);
		technicianBusiness = new TechnicianBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}	
}
