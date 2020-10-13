
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
import business.TechnicianBusiness;
import dataAccessObjectPresentationBusiness.TechnicianDAOPresentationBusiness;

public class TechnicianEditionPresentation {

	int id = 0;
	
	TechnicianBusiness technicianBusiness;
	List<JButton> buttonList;
	primaryTextField textprimary;
	FieldLabel fieldlabel;
	
	JButton btnSave;
	JButton btnCancel;
	JButton backbutton;
	
	JTextField txtName;
	JTextField txtRole;
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
			message = "Informar o nome do t�cnico.";
		else if (txtRole.getText().length() == 0)
			message = "Informar o cargo do t�cnico.";
		else if (txtHourPrice.getText().length() == 0)
			message = "Informar o valor da hora do t�cnico.";
		
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
    		String role = txtRole.getText();
    		Double hourPrice = Double.parseDouble(txtHourPrice.getText());
    		String name = txtName.getText();
    		TechnicianDAOPresentationBusiness DAOPresentBusiness = 
    				new TechnicianDAOPresentationBusiness(id, role, name, hourPrice);
    		
        	if (technicianBusiness.save(DAOPresentBusiness))
        		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        	
        }
        
	};
	
	public TechnicianEditionPresentation() {
		backbutton = new GoBackButton().getButton(cancel);
		btnSave = new primaryButton().getButton("Salvar", save);
		btnCancel = new primaryButton().getButton("Cancelar", cancel);
		technicianBusiness = new TechnicianBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnSave);
		buttonList.add(btnCancel);
		fieldlabel = new FieldLabel();		
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
		fieldContainer.add(pnlRole);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
		fieldContainer.add(pnlHourPrice);
		fieldContainer.add(Box.createRigidArea(new Dimension(0,5)));
	}
	
	private void mountRolePanel() {
		pnlRole   = new JPanel();
		pnlRole.setMaximumSize(new Dimension(655, 35));
		pnlRole.setOpaque(false);
		labelRole= fieldlabel.getLabel("Cargo:");
		txtRole =  textprimary.getTextField("");
		pnlRole.add(labelRole);
		pnlRole.add(txtRole);
	}
	
	private void mountHourPricePanel() {
		pnlHourPrice   = new JPanel();
		pnlHourPrice.setMaximumSize(new Dimension(655, 35));
		pnlHourPrice.setOpaque(false);
		labelHourPrice= fieldlabel.getLabel("Vr. Hora (R$):");
		txtHourPrice =  textprimary.getTextField("");
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
		
		txtRole.setText(technician.getRole());
		txtName.setText(technician.getName());
		txtHourPrice.setText(Double.toString(technician.getHourPrice()));
		this.id = id;
	}
	
	public JPanel render(int id, ActionListener goBackAction) {
		textprimary = new primaryTextField();
		header = new Header().getHeader("Edi��o de Usu�rio",backbutton);
		buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		backbutton.addActionListener(goBackAction);
		mountNamePanel();
		mountRolePanel();
		mountHourPricePanel();
		mountFieldContainer();
		mountMainPanel();
		FillTechnicianProperties(id);
		return mainPanel;
	}
}
