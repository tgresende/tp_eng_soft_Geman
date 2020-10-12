package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UIComponents.ButtonsContainer;
import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.SelectionContainer;
import UIComponents.primaryButton;
import UIFunctions.panelFunctions;
import business.TechnicianBusiness;
import objetoAcessoDados.usuario_objAcessoDados;

public class Usuario_selecao_apr {

	
	TechnicianBusiness _usuario_logica;
	TechnicianPresentation usuarioEdicao;
	panelFunctions pnlFunc = new panelFunctions();

	List<JButton> buttonList;
	
	JTable table;
    JScrollPane rollBar;
	DefaultTableModel model;
	JPanel mainContainer;
	JButton backbutton;
	JButton btnInsert;
	JButton btnEdit;
	JButton btnDelete;
	Method _a;

	public JPanel render() {
		JPanel tablePanel;
		JPanel header = new Header().getHeader("Usuários",backbutton);
		JPanel buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		mainContainer = new JPanel();
		mainContainer.setOpaque(false);

		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = _usuario_logica.getModelList();
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1, 1));
		table = new JTable(model);
        table.setFont(new Font("", 1, 14));
        table.setBackground(Color.white);
        table.getTableHeader().setBackground(Color.white);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));

		rollBar = new JScrollPane(table);
		tablePanel.add(rollBar);

		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}


	ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<usuario_objAcessoDados> usuarios = _usuario_logica.getList();
        	for(usuario_objAcessoDados usuario : usuarios){
        		JOptionPane.showMessageDialog(null, usuario.getNome());
        	}
        	
        }
	};
	
	ActionListener deleteRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	_usuario_logica.delete((int)table.getValueAt(table.getSelectedRow(), 0));
        	model.removeRow(table.getSelectedRow());
        }
        
	};
	
	ActionListener editRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (table.getSelectedRow() == -1)
        		return;
        	JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
        }
	};
	
	ActionListener newRegister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	usuarioEdicao = new TechnicianPresentation();
        	JPanel panelEdicao = usuarioEdicao.render();
        	pnlFunc.telaConstructor(mainContainer, panelEdicao);
        	
        }
	};
	
	ActionListener goBackAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<usuario_objAcessoDados> usuarios = _usuario_logica.getList();
        	for(usuario_objAcessoDados usuario : usuarios){
        		JOptionPane.showMessageDialog(null, usuario.getNome());
        	}
        	
        }
	};
	
	public Usuario_selecao_apr() {
		backbutton = new GoBackButton().getButton(goBackAction);
		btnInsert = new primaryButton().getButton("Inserir", newRegister);
		btnEdit = new primaryButton().getButton("Editar", editRegister);
		btnDelete = new primaryButton().getButton("Excluir", deleteRegister);
		_usuario_logica = new TechnicianBusiness();
		buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	}	
}
