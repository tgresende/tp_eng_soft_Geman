package presentation;

import java.awt.Dimension;
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
import UIComponents.Table;
import UIComponents.primaryButton;
import business.EquipmentBusiness;
import business.OrderServiceBusiness;
import business.TechnicianBusiness;

public class ReportSelectionPresentation {
	
	EquipmentBusiness equipmentBusiness;
	OrderServiceBusiness orderServiceBusiness;

	List<JButton> buttonList;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	JButton btnCostMaintenance;
	JButton btnMTRR;
	JButton btnStopTime;
	Method _a;


	public JPanel render() {
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Relatórios", backbutton);
		JPanel buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		mainContainer = new JPanel();
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = orderServiceBusiness.getMeanTimeRepairs();
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1,1));
		table = Table.getTable(model);
		rollBar = new JScrollPane(table);
		tablePanel.add(rollBar);
		
		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}
	
	public ReportSelectionPresentation() {
		backbutton = new GoBackButton().getButton(goBakAction);
		btnCostMaintenance = new primaryButton().getButton("Custo de Reparo", newRegister);
		btnStopTime = new primaryButton().getButton("Tempo de Parada", editRegister);
		btnMTRR = new primaryButton().getButton("T. Méd. de Reparos", deleteRegister);
		
		btnCostMaintenance.setPreferredSize(new Dimension(200,40));
		btnStopTime.setPreferredSize(new Dimension(200,40));
		btnMTRR.setPreferredSize(new Dimension(200,40));

		equipmentBusiness = new EquipmentBusiness();
		orderServiceBusiness = new OrderServiceBusiness();
		buttonList  = new ArrayList<>();
		buttonList.add(btnCostMaintenance);
		buttonList.add(btnStopTime);
		buttonList.add(btnMTRR);
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
