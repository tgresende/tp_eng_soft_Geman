package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import UIComponents.primaryButton;
import logica.usuario_logica;
import objetoAcessoDados.usuario_objAcessoDados;

public class usuario_apresentacao {

	primaryButton buttonprimary = new primaryButton();
	usuario_logica _usuario_logica = new usuario_logica();
	
	public JPanel render() {
		
		JPanel painel = new JPanel();
		
		ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	List<usuario_objAcessoDados> usuarios = _usuario_logica.getList();
            	for(usuario_objAcessoDados usuario : usuarios){
            		JOptionPane.showMessageDialog(null, usuario.Nome);
            	}
            	
            }
		};
		JButton testebutton =  buttonprimary.getButton("botao de usuario",action);
		painel.add(testebutton);
		
		return painel;
	}
}
