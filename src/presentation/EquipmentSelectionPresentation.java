package presentation;

import java.awt.Color;
import java.awt.Font;
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
import UIComponents.primaryButton;
import UIFunctions.panelFunctions;
import business.EquipmentBusiness;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;

public class EquipmentSelectionPresentation {
	
	EquipmentBusiness equipmentBusiness;
	EquipmentEditionPresentation equipmentEdition;
	panelFunctions pnlFunc = new panelFunctions();
	
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
	
	public JPanel render() {
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Máquinas", backbutton);
		JPanel buttonContainer = new ButtonsContainer().getContainer(buttonList);
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
	
	ActionListener editRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	int id = (int)table.getValueAt(table.getSelectedRow(), 0);
        	equipmentEdition = new EquipmentEditionPresentation();
        	JPanel panelEdicao = equipmentEdition.render(id);
        	pnlFunc.telaConstructor(mainContainer, panelEdicao);
        }
	};
	
	ActionListener newRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			equipmentEdition = new EquipmentEditionPresentation();
        	JPanel panelEdicao = equipmentEdition.render(0);
        	pnlFunc.telaConstructor(mainContainer, panelEdicao);
        	
        }
	};
	
	ActionListener goBackAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	List<EquipmentDAOPresentationBusiness> equipments = equipmentBusiness.getList();
        	for(EquipmentDAOPresentationBusiness equipment : equipments){
        		JOptionPane.showMessageDialog(null, equipment.getName());
        	}	
        }
	};
	
	public EquipmentSelectionPresentation() {
		backbutton = new GoBackButton().getButton(goBackAction);
		btnInsert = new primaryButton().getButton("Inserir", newRegister);
		btnEdit = new primaryButton().getButton("Editar", editRegister);
		btnDelete = new primaryButton().getButton("Excluir", deleteRegister);
		equipmentBusiness = new EquipmentBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}
}
