package UIComponents;


import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import UIClasses.Cores;

public class SelectionContainer {

	Cores cor = new Cores();

	public JScrollPane getPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(cor.getBrancoPrincipal());
		JScrollPane scrollPane = new JScrollPane(contentPanel);
	    scrollPane.setBackground(cor.getBrancoPrincipal());
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

	    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		return scrollPane;
	}
}
