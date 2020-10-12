
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
import objetoAcessoDados.usuario_objAcessoDados;

public class TechnicianPresentation {

	
	TechnicianBusiness userBusiness;
	List<JButton> buttonList;
	primaryTextField textprimary;
	FieldLabel fieldlabel;
	
	JButton btnSave;
	JButton btnCancel;
	JButton backbutton;
	
	JTextField txtName;
	JTextField txtRole;

	JLabel labelName;
	JLabel labelRole;
	
	JPanel header;
	JPanel mainPanel;
	JPanel pnlName;
	JPanel buttonContainer;
	JPanel fieldContainer;
	JPanel pnlRole;
	


	ActionListener cancel = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
	};
	
	ActionListener save = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
	};
	
	public TechnicianPresentation() {
		backbutton = new GoBackButton().getButton(cancel);
		btnSave = new primaryButton().getButton("Salvar", save);
		btnCancel = new primaryButton().getButton("Cancelar", cancel);
		userBusiness = new TechnicianBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnSave);
		buttonList.add(btnCancel);
		fieldlabel = new FieldLabel();
		
	}	

	ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<usuario_objAcessoDados> technicians = userBusiness.getList();
        	for(usuario_objAcessoDados technician : technicians){
        		JOptionPane.showMessageDialog(null, technician.getNome());
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
	
	public JPanel render() {
		textprimary = new primaryTextField();
		header = new Header().getHeader("Edi��o de Usu�rio",backbutton);
		buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		mountNamePanel();
		mountRolePanel();
		mountFieldContainer();
		mountMainPanel();
		return mainPanel;
	}
}
