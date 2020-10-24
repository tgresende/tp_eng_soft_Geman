package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.SelectionContainer;
import business.OrderServiceBusiness;

public class ReportPresentation {

	OrderServiceBusiness orderServiceBusiness;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	 
	ActionListener goBackAction;
	
	public ReportPresentation( ) {
		backbutton = new GoBackButton().getButton();
		orderServiceBusiness = new OrderServiceBusiness();
	}
	
	private void getModel(int reportType) {
		if (reportType == 0) {
			model = orderServiceBusiness.getCostRepairModel();
		} else if (reportType == 1) {
			model = orderServiceBusiness.getStopTimeModel();
		} else if (reportType == 2) {
			model = orderServiceBusiness.getMeanTimeRepairModel();
		}
		
		
		
	}
	
	public JPanel render(ActionListener goBackAction, int reportType) {
		this.goBackAction = goBackAction;
		JPanel tablePanel;
		JPanel header = Header.getHeader("Relatório de Tempo médio de Parada", backbutton);
		JScrollPane contentContainer = SelectionContainer.getPanel();
		backbutton.addActionListener(goBackAction);
		mainContainer = new JPanel();
		mainContainer.setOpaque(false);
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		
		getModel(reportType);
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
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}
}
