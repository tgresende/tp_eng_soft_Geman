package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
import UIComponents.PrimaryButton;
import UIFunctions.PanelFunctions;
import business.OrderServiceBusiness;

public class OrderServiceSelectionPresentation {
	
	OrderServiceBusiness orderServiceBusiness;
	OrderServiceEditionPresentation orderServiceEdition;
	List<JButton> buttonList;
	
	JPanel mainContainer;

	JTable table;

	DefaultTableModel model;
	
	JScrollPane rollBar;
	
	JButton backbutton;
	JButton btnInsert;
	JButton btnEdit;
	JButton btnDelete;
	
	ActionListener goBackAction;

	
	public JPanel render(ActionListener goBackAction) {
		this.goBackAction = goBackAction; 
		JPanel tablePanel;
		
		JPanel header = Header.getHeader("Ordem de Serviço", backbutton);
		
		JPanel buttonContainer =  ButtonsContainer.getContainer(buttonList);
		
		JScrollPane contentContainer = SelectionContainer.getPanel();
		
		mainContainer = new JPanel();
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = orderServiceBusiness.getModelList();
		tablePanel = new JPanel();
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
	
	public OrderServiceSelectionPresentation() {
		backbutton = new GoBackButton().getButton();
		btnInsert = PrimaryButton.getButton("Inserir", newRegister);
		btnEdit = PrimaryButton.getButton("Editar", editRegister);
		btnDelete = PrimaryButton.getButton("Excluir", deleteRegister);
		orderServiceBusiness = new OrderServiceBusiness();
		buttonList  = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}
	

	private void renderEditionPanel(int id) throws ParseException{
		orderServiceEdition = new OrderServiceEditionPresentation();
    	JPanel editionPanel = orderServiceEdition.render(id, goBackAction);
    	PanelFunctions.panelConstructor(mainContainer, editionPanel);
	}
	
	ActionListener newRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				renderEditionPanel(0);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
	};
	
	ActionListener editRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	int id = (int)table.getValueAt(table.getSelectedRow(), 0);
        	try {
				renderEditionPanel(id);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
        }
		
	};
	
	ActionListener deleteRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	orderServiceBusiness.delete((int)table.getValueAt(table.getSelectedRow(), 0));
        	model.removeRow(table.getSelectedRow());
        }
		
	};
}



