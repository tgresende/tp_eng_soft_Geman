package UIFunctions;


import javax.swing.JPanel;

public final class PanelFunctions {

	
	public static void panelConstructor(JPanel painelPai, JPanel painelFilho ) {
		painelPai.removeAll();
		painelPai.revalidate();
		painelPai.repaint();
		painelPai.add(painelFilho);
	}
}
