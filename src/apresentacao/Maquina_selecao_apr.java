package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UIComponents.primaryButton;
import UIComponents.primaryTextField;
import UIFunctions.panelFunctions;

public class Maquina_selecao_apr {
	
	Maquina_edicao_apr  maquina_edicao_apr = new Maquina_edicao_apr();
	panelFunctions pnlFunc = new panelFunctions();
	JPanel painel = new JPanel();
	
	
	ActionListener abrirTelaMaquinaEdicao = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JPanel panelmaquina = maquina_edicao_apr.render();
			pnlFunc.telaConstructor(painel, panelmaquina);
		}
	};
	
	public JPanel render() {
		primaryButton buttonprimary = new primaryButton();
		primaryTextField textprimary = new primaryTextField();
		JTextField txtTeste = textprimary.getTextField("Inserir");
		JButton testebutton = buttonprimary.getButton("Inserir", abrirTelaMaquinaEdicao);
		painel.add(testebutton);
		painel.add(txtTeste);
		return painel;
	}
}
