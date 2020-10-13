package UIComponents;



import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import UIClasses.Colors;

public class SelectionContainer {

	public JScrollPane getPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Colors.getMainWhite());
		JScrollPane scrollPane = new JScrollPane(contentPanel);
	    scrollPane.setBackground(Colors.getMainWhite());
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

	    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		return scrollPane;
	}
}
