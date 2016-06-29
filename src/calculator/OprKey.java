package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class OprKey extends JButton implements ActionListener {
	private Operation operation;
	private Stack stack;
	private StackPanel panel;
	
	public OprKey(Stack stack, Operation operation, String label, StackPanel panel) {
		super(label);
		this.panel = panel;
		this.stack = stack;
		this.operation = operation;
		addActionListener(this);
	}
	

	/** 
	 * Executes the specified operation and updates the calculator's stack window.
	 */
	public void actionPerformed(ActionEvent e) {
		stack.execute(operation);
		panel.update(stack);
	}

}
