package calculator;
import javax.swing.*;
import java.awt.*;

public class CalcView {
	private CommandPanel commandPanel;
	private CommandPanel2 commandPanel2;
	private StackPanel stackPanel;
	private Stack stack;
	
	public CalcView(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stackPanel = new StackPanel();
		stack = new Stack();
		commandPanel = new CommandPanel(stack, stackPanel);
		commandPanel2 = new CommandPanel2(stack, stackPanel);
		
		frame.add(commandPanel, BorderLayout.SOUTH);
		frame.add(stackPanel, BorderLayout.NORTH);
		frame.add(commandPanel2, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);	
	}
}
