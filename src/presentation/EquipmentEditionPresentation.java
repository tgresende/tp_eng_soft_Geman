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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.ButtonsContainer;
import UIComponents.FieldLabel;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.primaryButton;
import UIComponents.primaryTextField;
import business.EquipmentBusiness;
import dataAccessObjectPresentationBusiness.EquipmentDAOPresentationBusiness;

public class EquipmentEditionPresentation {
	
	int id = 0;
	EquipmentBusiness equipmentBusiness;
	List<JButton> buttonList;
	primaryTextField textprimary;
	FieldLabel fieldlabel;
	
	JButton btnSave;
	JButton btnCancel;
	JButton backbutton;
	
	JTextField txtName;
	JTextField txtModel;
	JTextField txtManufacturer;


	JLabel labelName;
	JLabel HourPrice;
	JLabel labelModel;
	JLabel labelManufacturer;

	
	JPanel header;
	JPanel mainPanel;
	JPanel pnlName;
	JPanel buttonContainer;
	JPanel fieldContainer;
	JPanel pnlModel;
	JPanel pnlManufacturer;
	
	ActionListener cancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
	};
	
	private int getId() {
		return this.id;
	}
	
	private boolean HasBlankFields() {
		String message = "";
		
		if (txtName.getText().length() == 0)
			message = "Informar o nome do equipamento.";
		else if (txtModel.getText().length() == 0)
			message = "Informar o modelo do equipamento.";
		else if (txtManufacturer.getText().length() == 0)
			message = "Informar o fabricante do equipamento.";
		
		if (message.length() > 0) {
    		JOptionPane.showMessageDialog(null, message);
			return true;
		}
		return false;
	}
	
	ActionListener save = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (HasBlankFields()) { 
        		return;
        	}
        	
        	int id = getId();
    		String model = txtModel.getText();
    		String manufacturer = txtManufacturer.getText();
    		String name = txtName.getText();
    		EquipmentDAOPresentationBusiness DAOPresentBusiness = 
    				new EquipmentDAOPresentationBusiness(id, name, model, manufacturer);
    		
        	if (equipmentBusiness.save(DAOPresentBusiness))
        		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        	
        }
        
	};
	
	public EquipmentEditionPresentation() {
		backbutton = new GoBackButton().getButton(cancel);
		btnSave = new primaryButton().getButton("Salvar", save);
		btnCancel = new primaryButton().getButton("Cancelar", cancel);
		equipmentBusiness = new EquipmentBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnSave);
		buttonList.add(btnCancel);
		fieldlabel = new FieldLabel();		
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
	
	private void mountNamePanel() {
		pnlName   = new JPanel();
		pnlName.setOpaque(false);
		pnlName.setMaximumSize(new Dimension(655, 35));
		labelName = fieldlabel.getLabel("Nome:");
		txtName =  textprimary.getTextField("");
		pnlName.add(labelName);
		pnlName.add(txtName);
	}

	private void mountMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(header);
		mainPanel.add(buttonContainer);
		mainPanel.add(fieldContainer);
	}
	
	private void mountFieldContainer() {
		fieldContainer = new JPanel();
		fieldContainer.setOpaque(false);
		fieldContainer.setLayout(new BoxLayout(fieldContainer, BoxLayout.Y_AXIS));
		fieldContainer.add(pnlName);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlModel);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlManufacturer);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
	}
	
	private void mountModelPanel() {
		pnlModel   = new JPanel();
		pnlModel.setMaximumSize(new Dimension(655, 35));
		pnlModel.setOpaque(false);
		labelModel= fieldlabel.getLabel("Modelo:");
		txtModel =  textprimary.getTextField("");
		pnlModel.add(labelModel);
		pnlModel.add(txtModel);
	}
	
	private void mountManufacturerPanel() {
		pnlManufacturer   = new JPanel();
		pnlManufacturer.setMaximumSize(new Dimension(655, 35));
		pnlManufacturer.setOpaque(false);
		labelManufacturer= fieldlabel.getLabel("Fabricante:");
		txtManufacturer =  textprimary.getTextField("");
		pnlManufacturer.add(labelManufacturer);
		pnlManufacturer.add(txtManufacturer);
	}
	
	private void FillEquipmentProperties(int id) {
		if (id ==0)
			return;
		
		EquipmentDAOPresentationBusiness equipment = equipmentBusiness.get(id);
		if (equipment == null) {
			JOptionPane.showMessageDialog(null, "Registro não encontrado.");
			return;
		}
		
		txtModel.setText(equipment.getModel());
		txtName.setText(equipment.getName());
		txtManufacturer.setText(equipment.getManufacturer());
		this.id = id;
	}
	
	public JPanel render(int id) {
		textprimary = new primaryTextField();
		header = new Header().getHeader("Edição de Máquinas",backbutton);
		buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		mountNamePanel();
		mountModelPanel();
		mountManufacturerPanel();
		mountFieldContainer();
		mountMainPanel();
		FillEquipmentProperties(id);
		return mainPanel;
	}
}
