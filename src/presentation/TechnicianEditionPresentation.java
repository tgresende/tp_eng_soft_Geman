
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.ButtonsContainer;
import UIComponents.ComboBox;
import UIComponents.FieldLabel;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.PrimaryButton;
import UIComponents.PrimaryTextField;
import business.TechnicianBusiness;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianEditionPresentation {

	int id = 0;
	TechnicianBusiness technicianBusiness;
	List<JButton> buttonList;
	PrimaryTextField textprimary;
	ComboBox cmbBox;
	
	JButton btnSave;
	JButton btnCancel;
	JButton backbutton;
	
	JTextField txtName;
	JTextField txtHourPrice;

	JLabel labelName;
	JLabel HourPrice;
	JLabel labelRole;
	JLabel labelHourPrice;
	
	JPanel header;
	JPanel mainPanel;
	JPanel pnlName;
	JPanel buttonContainer;
	JPanel fieldContainer;
	JPanel pnlRole;
	JPanel pnlHourPrice;
	
	JComboBox comboRole;
	
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
        	
        	int id = getId();
    		String role = comboRole.getSelectedItem().toString();
    		String hourPriceAux = Utils.replaceCommaToDot(txtHourPrice.getText());
    		
    		Double hourPrice = Double.parseDouble(Utils.onlyNumbers(hourPriceAux));
    		
    		String name = txtName.getText();
    		TechnicianDAOPresentationBusiness DAOPresentBusiness = 
    				new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
    		
        	if (technicianBusiness.save(DAOPresentBusiness)) {
        		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        		backbutton.doClick();
        	}else {
        		JOptionPane.showMessageDialog(null, technicianBusiness.feedbackMessage);
        	}
        	
        	
        }
        
	};
	
	public TechnicianEditionPresentation() {
		backbutton = new GoBackButton().getButton();
		btnSave = PrimaryButton.getButton("Salvar", save);
		btnCancel = PrimaryButton.getButton("Cancelar", cancel);
		technicianBusiness = new TechnicianBusiness();
		cmbBox = new ComboBox();
		buttonList = new ArrayList<>();
		buttonList.add(btnSave);
		buttonList.add(btnCancel);
	}	

	ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<TechnicianDAOPresentationBusiness> technicians = technicianBusiness.getList();
        	for(TechnicianDAOPresentationBusiness technician : technicians){
        		JOptionPane.showMessageDialog(null, technician.getName());
        	}
        	
        }
	};
	
	private void mountNamePanel() {
		pnlName   = new JPanel();
		pnlName.setOpaque(false);
		pnlName.setMaximumSize(new Dimension(655, 35));
		labelName = FieldLabel.getLabel("Nome:");
		txtName =  PrimaryTextField.getTextField("");
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
		fieldContainer.add(pnlRole);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlHourPrice);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
	}
	
	private void mountRolePanel() {
		pnlRole   = new JPanel();
		pnlRole.setMaximumSize(new Dimension(655, 35));
		pnlRole.setOpaque(false);
		labelRole= FieldLabel.getLabel("Cargo:");
		
		String[] roles = technicianBusiness.getAvaliableRoles();
		comboRole = ComboBox.getComboBox(roles);
		
		pnlRole.add(labelRole);
		pnlRole.add(comboRole);
	}
	
	private void mountHourPricePanel() {
		pnlHourPrice   = new JPanel();
		pnlHourPrice.setMaximumSize(new Dimension(655, 35));
		pnlHourPrice.setOpaque(false);
		labelHourPrice= FieldLabel.getLabel("Vr. Hora (R$):");
		txtHourPrice =  PrimaryTextField.getTextField("");
		pnlHourPrice.add(labelHourPrice);
		pnlHourPrice.add(txtHourPrice);
	}
	
	private void FillTechnicianProperties(int id) {
		if (id ==0)
			return;
		
		TechnicianDAOPresentationBusiness technician = technicianBusiness.get(id);
		if (technician == null) {
			JOptionPane.showMessageDialog(null, "Registro n�o encontrado.");
			return;
		}
		
		comboRole.setSelectedItem(technician.getRole());
		txtName.setText(technician.getName());
		txtHourPrice.setText(Double.toString(technician.getHourPrice()));
		this.id = id;
	}
	
	public JPanel render(int id, ActionListener goBackAction) {
		this.goBackAction = goBackAction; 
		header = Header.getHeader("Edi��o de Usu�rio",backbutton);
		buttonContainer =  ButtonsContainer.getContainer(buttonList);
		backbutton.addActionListener(goBackAction);
		btnCancel.addActionListener(goBackAction);

		mountNamePanel();
		mountRolePanel();
		mountHourPricePanel();
		mountFieldContainer();
		mountMainPanel();
		FillTechnicianProperties(id);
		return mainPanel;
	}
}
