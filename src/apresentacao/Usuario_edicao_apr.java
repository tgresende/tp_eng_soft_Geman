
package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.primaryButton;
import UIComponents.primaryTextField;
import logica.usuario_logica;
import objetoAcessoDados.usuario_objAcessoDados;

public class Usuario_edicao_apr {

	
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
	
	public JPanel render() {
		primaryButton buttonprimary = new primaryButton();
		primaryTextField textprimary = new primaryTextField();
		JPanel painel = new JPanel();
		JTextField txtTeste =  textprimary.getTextField("Inserir");
		JButton testebutton =  buttonprimary.getButton("Inserir",action);
		painel.add(testebutton);
		painel.add(txtTeste);
		return painel;
	}
}
