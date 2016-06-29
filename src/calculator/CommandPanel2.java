package calculator;

import javax.swing.*;
import static calculator.Operation.*;
import java.awt.*;

public class CommandPanel2 extends JPanel {
	
	public CommandPanel2(Stack stack, StackPanel panel) {
		setLayout(new GridLayout(1,4));
		add(new OprKey(stack, ENTER, "ENTER", panel));
		add(new OprKey(stack, CHS, "CHS", panel));
		add(new OprKey(stack, CLEAR, "CLEAR", panel));
		add(new OprKey(stack, CLEARSTACK, "CLEAR STACK", panel));
	}
	
}
