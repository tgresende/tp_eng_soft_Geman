package presentation;

import java.awt.Dimension;
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
import UIComponents.Header;
import UIComponents.SelectionContainer;
import UIComponents.PrimaryButton;
import UIFunctions.PanelFunctions;
import business.EquipmentBusiness;
import business.OrderServiceBusiness;

public class ReportSelectionPresentation {
	
	EquipmentBusiness equipmentBusiness;
	OrderServiceBusiness orderServiceBusiness;

	List<JButton> buttonList;
	
	JTable table;
	JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton btnCostMaintenance;
	JButton btnMTRR;
	JButton btnStopTime;
	JPanel tablePanel;
	
	ActionListener goBackAction;


	public JPanel render( ActionListener goBackAction) {
		this.goBackAction = goBackAction;
		JPanel header = Header.getHeader("Relat�rios");
		JPanel buttonContainer =  ButtonsContainer.getContainer(buttonList);
		JScrollPane contentContainer = SelectionContainer.getPanel();
		mainContainer = new JPanel();
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		
		return mainContainer;
	}
	
	public ReportSelectionPresentation() {
		
		btnCostMaintenance = PrimaryButton.getButton("Custo de Reparo", RepairCost);
		btnStopTime = PrimaryButton.getButton("Tempo de Parada", stopTime);
		btnMTRR = PrimaryButton.getButton("T. M�d. de Reparos", meanTimetoRepair);
		
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
	
	private void renderReport(int reportType) {
		ReportPresentation reportMeanTimeRepair = new ReportPresentation();
    	JPanel panelView = reportMeanTimeRepair.render(goBackAction, reportType);
    	PanelFunctions.panelConstructor(mainContainer, panelView);
	}
	
	ActionListener meanTimetoRepair = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			renderReport(2);
		}
		
	};
	
	ActionListener stopTime = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			renderReport(1);
			
		}
		
	};
	
	ActionListener RepairCost = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			renderReport(0);
		}	
	};

}
