package apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.GoBackButton;
import UIComponents.Header;
import UIComponents.primaryButton;
import UIComponents.primaryTextField;
import logica.usuario_logica;
import objetoAcessoDados.usuario_objAcessoDados;

public class Usuario_selecao_apr {

	
	usuario_logica _usuario_logica = new usuario_logica();
	
	ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<usuario_objAcessoDados> usuarios = _usuario_logica.getList();
        	for(usuario_objAcessoDados usuario : usuarios){
        		JOptionPane.showMessageDialog(null, usuario.Nome);
        	}
        	
        }
	};
	
	ActionListener goBackAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	List<usuario_objAcessoDados> usuarios = _usuario_logica.getList();
        	for(usuario_objAcessoDados usuario : usuarios){
        		JOptionPane.showMessageDialog(null, usuario.Nome);
        	}
        	
        }
	};
	
	public JPanel render() {
		primaryButton buttonprimary = new primaryButton();
		primaryTextField textprimary = new primaryTextField();
		GoBackButton goBackBtn = new GoBackButton();
		
		JButton backbutton = goBackBtn.getButton(goBackAction);
		
		Header header =  new Header();
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		painel.setLayout(null);
		JPanel cabecalho = header.getHeader("Usuários",backbutton);
		
		JTextField txtTeste =  textprimary.getTextField("Inserir");
		JButton testebutton =  buttonprimary.getButton("Inserir",action);
		testebutton.setLocation(1, 0);
		txtTeste.setLocation(2, 0);
		
		painel.add(cabecalho);
		
		painel.add(testebutton);
		painel.add(txtTeste);
		
		return painel;
	}
}
