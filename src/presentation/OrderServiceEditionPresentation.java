package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.ButtonsContainer;
import UIComponents.ComboBox;
import UIComponents.DateField;
import UIComponents.FieldLabel;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.PrimaryButton;
import UIComponents.PrimaryTextField;
import UIComponents.TimeField;
import business.EquipmentBusiness;
import business.OrderServiceBusiness;
import business.TechnicianBusiness;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class OrderServiceEditionPresentation {

	int id = 0;
	OrderServiceBusiness orderServiceBusiness;
	TechnicianBusiness technicianBusiness;
	EquipmentBusiness equipmentBusiness;
	
	List<JButton> buttonList;
	PrimaryTextField textprimary;
	FieldLabel fieldlabel;
	ComboBox cmbBox;
	
	JButton btnSave;
	JButton btnCancel;
	JButton backbutton;
	
	JFormattedTextField txtDate;
	JFormattedTextField txtEndTime;
	JFormattedTextField txtStartTime;
	
	JTextField txtDescription;

	JLabel labelDate;	
	JLabel labelEndTime;
	JLabel labelStartTime;
	JLabel labelTechnician;
	JLabel labelTypeService;
	JLabel labelEquipment;
	JLabel labelDescription;

	JPanel header;
	JPanel mainPanel;
	JPanel pnlDate;
	JPanel buttonContainer;
	JPanel fieldContainer;
	JPanel pnlStartTime;
	JPanel pnlEndTime;
	JPanel pnlTechnician;
	JPanel pnlTypeService;
	JPanel pnlEquipment;
	JPanel pnlDescription;
	
	JComboBox comboEquipment;
	JComboBox comboTechnician;
	JComboBox comboTypeService;
	
	ActionListener goBackAction;
	
	ActionListener cancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
	};
	
	private int getId() {
		return this.id;
	}
	
	ActionListener save = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        /*	int id = getId();
    		String role = comboRole.getSelectedItem().toString();
    		String hourPriceAux = Utils.replaceCommaToDot(txtHourPrice.getText());
    		
    		Double hourPrice = Double.parseDouble(Utils.onlyNumbers(hourPriceAux));
    		
    		String name = txtName.getText();
    		TechnicianDAOPresentationBusiness DAOPresentBusiness = 
    				new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
    	/*	
        	if (orderServiceBusiness.save(DAOPresentBusiness)) {
        		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        		backbutton.doClick();
        	}else {
        		JOptionPane.showMessageDialog(null, orderServiceBusiness.feebackMessage);
        	}
        	*/
        	
        }
        
	};
	
	public OrderServiceEditionPresentation() {
		backbutton = new GoBackButton().getButton();
		btnSave = PrimaryButton.getButton("Salvar", save);
		btnCancel = PrimaryButton.getButton("Cancelar", cancel);
		orderServiceBusiness = new OrderServiceBusiness();
		technicianBusiness = new TechnicianBusiness();
		equipmentBusiness = new EquipmentBusiness();
		cmbBox = new ComboBox();
		buttonList = new ArrayList<>();
		buttonList.add(btnSave);
		buttonList.add(btnCancel);
		fieldlabel = new FieldLabel();		
	}	

	
	private void mountMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(header);
		mainPanel.add(buttonContainer);
		mainPanel.add(fieldContainer);
	}
	
	private void mountDatePanel() {
		pnlDate   = new JPanel();
		pnlDate.setOpaque(false);
		pnlDate.setMaximumSize(new Dimension(655, 35));
		labelDate = fieldlabel.getLabel("Data:");
		txtDate =  DateField.getDateField("");
		pnlDate.add(labelDate);
		pnlDate.add(txtDate);
	}
	
	private void mountDescriptionPanel() {
		pnlDescription   = new JPanel();
		pnlDescription.setOpaque(false);
		pnlDescription.setMaximumSize(new Dimension(655, 35));
		labelDescription = fieldlabel.getLabel("Serviço:");
		txtDescription =  PrimaryTextField.getTextField("");
		pnlDescription.add(labelDescription);
		pnlDescription.add(txtDescription);
	}
	
	private void mountStartTimePanel() {
		pnlStartTime   = new JPanel();
		pnlStartTime.setOpaque(false);
		pnlStartTime.setMaximumSize(new Dimension(655, 35));
		labelStartTime = fieldlabel.getLabel("Hora Início:");
		txtStartTime =  TimeField.getTimeField("");
		pnlStartTime.add(labelStartTime);
		pnlStartTime.add(txtStartTime);
	}
	
	private void mountEndTimePanel() {
		pnlEndTime   = new JPanel();
		pnlEndTime.setOpaque(false);
		pnlEndTime.setMaximumSize(new Dimension(655, 35));
		labelEndTime = fieldlabel.getLabel("Hora Fim:");
		txtEndTime =  TimeField.getTimeField("");
		pnlEndTime.add(labelEndTime);
		pnlEndTime.add(txtEndTime);
	}
	
	private void mountTechnicianPanel() {
		pnlTechnician   = new JPanel();
		pnlTechnician.setMaximumSize(new Dimension(655, 35));
		pnlTechnician.setOpaque(false);
		labelTechnician= fieldlabel.getLabel("Cargo:");
		
		String[] technicians = technicianBusiness.getAvaliableTechnicians();
		comboTechnician = cmbBox.getComboBox(technicians);
		
		pnlTechnician.add(labelTechnician);
		pnlTechnician.add(comboTechnician);
	}
	
	private void mountTypeServicePanel() {
		pnlTypeService   = new JPanel();
		pnlTypeService.setMaximumSize(new Dimension(655, 35));
		pnlTypeService.setOpaque(false);
		labelTypeService = fieldlabel.getLabel("Tipo Serviço:");
		
		String[] typeServices = orderServiceBusiness.getAvaliableTypeService();
		
		comboTypeService = cmbBox.getComboBox(typeServices);
		
		pnlTypeService.add(labelTypeService);
		pnlTypeService.add(comboTypeService);
	}
	
	private void mountEquipmentPanel() {
		pnlEquipment   = new JPanel();
		pnlEquipment.setMaximumSize(new Dimension(655, 35));
		pnlEquipment.setOpaque(false);
		labelEquipment= fieldlabel.getLabel("Máquina:");
		
		String[] Equipments = equipmentBusiness.getAvaliableEquipments();
		comboEquipment = cmbBox.getComboBox(Equipments);
		
		pnlEquipment.add(labelEquipment);
		pnlEquipment.add(comboEquipment);
	}
	
	private void mountFieldContainer() {
		fieldContainer = new JPanel();
		fieldContainer.setOpaque(false);
		fieldContainer.setLayout(new BoxLayout(fieldContainer, BoxLayout.Y_AXIS));
		fieldContainer.add(pnlDate);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlStartTime);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlEndTime);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlEquipment);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlTechnician);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlTypeService);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlDescription);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
	}
	
	public JPanel render(int id, ActionListener goBackAction) {
		this.goBackAction = goBackAction; 
		header = Header.getHeader("Edição de Ordem de Serviço",backbutton);
		buttonContainer =  ButtonsContainer.getContainer(buttonList);
		backbutton.addActionListener(goBackAction);
		btnCancel.addActionListener(goBackAction);

		mountDatePanel();
		mountStartTimePanel();
		mountEndTimePanel();
		mountEquipmentPanel();
		mountTechnicianPanel();
		mountTypeServicePanel();
		mountDescriptionPanel();
		mountFieldContainer();
		mountMainPanel();
		//FillOrderServiceProperties(id);
		return mainPanel;
	}
}
