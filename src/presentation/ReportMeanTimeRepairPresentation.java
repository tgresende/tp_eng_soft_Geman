package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

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

public class ReportMeanTimeRepairPresentation {

	OrderServiceBusiness orderServiceBusiness;
	
	List<JButton> buttonList;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	
	ActionListener goBackAction;
	
	public ReportMeanTimeRepairPresentation() {
		backbutton = new GoBackButton().getButton();
		orderServiceBusiness = new OrderServiceBusiness();
	}	
	
	public JPanel render(ActionListener goBackAction) {
		this.goBackAction = goBackAction;
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Relatório de Tempo médio de Parada", backbutton);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		backbutton.addActionListener(goBackAction);
		mainContainer = new JPanel();
		mainContainer.setOpaque(false);
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = orderServiceBusiness.getMeanTimeRepairModel();
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
