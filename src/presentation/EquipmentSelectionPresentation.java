package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import UIComponents.PrimaryButton;
import UIFunctions.PanelFunctions;
import business.EquipmentBusiness;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;

public class EquipmentSelectionPresentation {
	
	EquipmentBusiness equipmentBusiness;
	EquipmentEditionPresentation equipmentEdition;
	
	List<JButton> buttonList;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	JButton btnInsert;
	JButton btnEdit;
	JButton btnDelete;
	
	ActionListener goBackAction;

	
	public JPanel render(ActionListener goBackAction) {
		this.goBackAction = goBackAction; 
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Máquinas", backbutton);
		JPanel buttonContainer = ButtonsContainer.getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		mainContainer = new JPanel();
		mainContainer.setOpaque(false);
		
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = equipmentBusiness.getModelList();
		tablePanel =new JPanel();
		tablePanel.setLayout(new GridLayout(1,1));
		table = new JTable(model);
		table.setFont(new Font("", 1, 14));
        table.setBackground(Color.white);
        table.getTableHeader().setBackground(Color.white);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		
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
        	List<EquipmentDAOPresentationBusiness> equipments = equipmentBusiness.getList();
        	for(EquipmentDAOPresentationBusiness equipment : equipments){
        		JOptionPane.showMessageDialog(null, equipment.getName());
        	}
        	
        }
	};
	
	ActionListener deleteRegister  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	equipmentBusiness.delete((int)table.getValueAt(table.getSelectedRow(), 0));
        	model.removeRow(table.getSelectedRow());
        }
	};
	
	private void renderEditionPanel(int id){
		equipmentEdition = new EquipmentEditionPresentation();
    	JPanel panelEdicao = equipmentEdition.render(id, goBackAction);
    	PanelFunctions.panelConstructor(mainContainer, panelEdicao);
	}
	
	ActionListener editRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	int id = (int)table.getValueAt(table.getSelectedRow(), 0);
        	renderEditionPanel(id);
        }
	};
	
	ActionListener newRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			renderEditionPanel(0);
        	
        }
	};
	
	public EquipmentSelectionPresentation() {
		backbutton = new GoBackButton().getButton(goBackAction);
		btnInsert = PrimaryButton.getButton("Inserir", newRegister);
		btnEdit = PrimaryButton.getButton("Editar", editRegister);
		btnDelete =  PrimaryButton.getButton("Excluir", deleteRegister);
		equipmentBusiness = new EquipmentBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}
}
