package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import business.OrderServiceBusiness;

public class OrderServiceSelectionPresentation {
	
	OrderServiceBusiness orderServiceBusiness;
	List<JButton> buttonList;
	
	JPanel mainContainer;

	JTable table;

	DefaultTableModel model;
	
	JScrollPane rollBar;
	
	JButton backbutton;
	JButton btnInsert;
	JButton btnEdit;
	JButton btnDelete;
	
	public JPanel render() {
		JPanel tablePanel;
		
		JPanel header = new Header().getHeader("Ordem de Servi�o", backbutton);
		
		JPanel buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		
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
		backbutton = new GoBackButton().getButton(goBakAction);
		btnInsert = new primaryButton().getButton("Inserir", newRegister);
		btnEdit = new primaryButton().getButton("Editar", editRegister);
		btnDelete = new primaryButton().getButton("Excluir", deleteRegister);
		orderServiceBusiness = new OrderServiceBusiness();
		buttonList  = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}
	
	ActionListener goBakAction = new ActionListener() {
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
	
	ActionListener editRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	ActionListener deleteRegister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
}



