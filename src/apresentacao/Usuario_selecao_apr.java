package apresentacao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import logica.usuario_logica;
import objetoAcessoDados.usuario_objAcessoDados;

public class Usuario_selecao_apr {

	
	usuario_logica _usuario_logica;
	JTable table;
    JScrollPane rollBar;

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
        	JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
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
        	if (table.getSelectedRow() == -1)
        		return;
        	JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
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
	
	public JPanel render() {
		_usuario_logica = new usuario_logica();
		JButton backbutton = new GoBackButton().getButton(goBackAction);
		JButton btnInsert = new primaryButton().getButton("Inserir", newRegister);
		JButton btnEdit = new primaryButton().getButton("Editar", editRegister);
		JButton btnDelete = new primaryButton().getButton("Excluir", deleteRegister);

		DefaultTableModel model;
		JPanel tablePanel;
		
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(btnInsert);
		buttonList.add(btnEdit);
		buttonList.add(btnDelete);
	
		JPanel header = new Header().getHeader("Usu�rios",backbutton);
		JPanel buttonContainer =  new ButtonsContainer().getContainer(buttonList);
		JScrollPane contentContainer = new SelectionContainer().getPanel();
		JPanel mainContainer = new JPanel();
		
		mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
		model = _usuario_logica.getModelList();
		tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(1, 1));
		table = new JTable(model);
		rollBar = new JScrollPane(table);
		tablePanel.add(rollBar);

		mainContainer.add(header);
		mainContainer.add(buttonContainer);
		mainContainer.add(contentContainer);
		mainContainer.add(tablePanel);
		
		return mainContainer;
	}
}
