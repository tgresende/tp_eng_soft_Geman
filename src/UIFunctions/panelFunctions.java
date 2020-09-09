package UIFunctions;


import javax.swing.JPanel;

public class panelFunctions {

	
	public void telaConstructor(JPanel painelPai, JPanel painelFilho ) {
		painelPai.removeAll();
		painelPai.revalidate();
		painelPai.repaint();
		painelPai.add(painelFilho);
	}
}
