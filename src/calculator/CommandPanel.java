package calculator;

import javax.swing.*;
import static calculator.Operation.*;
import java.awt.*;

public class CommandPanel extends JPanel {
	
	public CommandPanel(Stack stack, StackPanel panel) {
		setLayout(new GridLayout(4,4));
			
		add(new OprKey(stack, PLUS, "+", panel));
		add(new OprKey(stack, SEVEN, "7", panel));
		add(new OprKey(stack, EIGHT, "8", panel));
		add(new OprKey(stack, NINE, "9", panel));

		add(new OprKey(stack, MINUS, "-", panel));
		add(new OprKey(stack, FOUR, "4", panel));
		add(new OprKey(stack, FIVE, "5", panel));
		add(new OprKey(stack, SIX, "6", panel));
		
		add(new OprKey(stack, TIMES, "*", panel));
		add(new OprKey(stack, ONE, "1", panel));
		add(new OprKey(stack, TWO, "2", panel));
		add(new OprKey(stack, THREE, "3", panel));
		
		add(new OprKey(stack, DIVIDES, "/", panel));
		add(new OprKey(stack, ZERO, "0", panel));
	}
	
}
