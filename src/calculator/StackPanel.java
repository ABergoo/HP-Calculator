package calculator;
import javax.swing.*;

import java.awt.*;

public class StackPanel extends JPanel {
	private JTextField[]  text;
	
	public StackPanel() {		
		setLayout(new GridLayout(4, 1));
		text = new JTextField[4];
		for(int i = 3; i >= 0; i--) {
			text[i] = new JTextField("0");
			text[i].setEditable(false);
			text[i].setHorizontalAlignment(JTextField.RIGHT);
			add(text[i]);
		}
	}
	
	/**
	 * Adds a representation of stack in this StackPanel.
	 * @param stack the stack which's content is to be represented
	 * in this StackPanel.
	 */
	public void update(Stack stack) {
		for(int i = 0; i < 4; i++) {
			text[i].setText(Integer.toString(stack.getElement(i)));
		}
	}
}
