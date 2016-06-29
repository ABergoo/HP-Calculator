package calculator;

public class Stack {
	private int[] stack;
	private int consoleValue;
	private int sign = 1;
	private boolean entPressed;

	/**
	 * Creates a representation of a stack pressent in a HP-calculator.
	 */
	public Stack() {
		stack = new int[4];
		consoleValue = 0;
		for (int i = 0; i < 4; i++) {
			stack[i] = 0;
		}
	}
	
	/**
	 * Returns the size of the stack array. (Method written for JUnit test.)
	 * @return the size of the stack array.
	 */
	public int size() {
		return stack.length;
	}
	
	/**
	 * Returns the number at stack level index.
	 * @param index the stack level the element is taken from.
	 * @return the element occurring at stack level index.
	 */
	public int getElement(int index) {
		return stack[index];
	}
	
		
	/**
	 * Adds the two first elements in the stack and puts the sum
	 * as the first element. All other elements gets up one level
	 * in the stack.
	 */
	private void plus() {
		stack[0] = stack[1] + stack[0];
		for (int i = 1; i < 3; i++) {
			stack[i] = stack[i+1];
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Subtracts the first two elements in the stack and puts the difference
	 * as the first element. All other elements gets up one level in the stack.
	 */
	private void minus() {
		stack[0] = stack[1] - stack[0];
		for (int i = 1; i < 3; i++) {
			stack[i] = stack[i+1];
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Multiplies the first two elements in the stack and puts the product
	 * as the first element. All other elements gets up one level in the stack.
	 */
	private void times() {
		stack[0] = stack[1] * stack[0];
		for (int i = 1; i < 3; i++) {
			stack[i] = stack[i+1];
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Divides the first two elements in the stack and puts the the quotient
	 * as the first element. All other elements gets up one level in the stack.
	 * If the lowest element is 0, nothing happens.
	 */
	private void divides() {
		if(stack[0] == 0) {
			return;
		}
		stack[0] = stack[1] / stack[0];
		for (int i = 1; i < 3; i++) {
			stack[i] = stack[i+1];
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Clears the top element in the stack. All other elements gets up one
	 * level.
	 */
	private void clear() {
		for (int i = 0; i < 3; i++) {
			stack[i] = stack[i+1];
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Clears the whole stack.
	 */
	private void clearStack() {
		for (int i = 0; i < 4; i++) {
			stack[i] = 0;
		}
		consoleValue = 0;
		entPressed = false;
	}

	/**
	 * Changes the sign of the top element.
	 */
	private void chs() {
		if(stack[0] == 0) {
			return;
		}
		sign *= -1;
		stack[0] = consoleValue * sign;
		entPressed = false;
	}

	/**
	 * Duplicates the top element to the second element. All existing elements gets down
	 * one level. If the bottom element is occupied, it's replaced by the element above it.
	 */
	private void enter() {
		for(int i = 3; i > 0; i--) {
			stack[i] = stack[i-1];
		}
		consoleValue = 0;
		entPressed = true;
	}
	
	/**
	 * Adds number to the Integer in the top element in the stack if this method call
	 * is preceded by another addNumberToStack call. Otherwise, all elements gets 
	 * up one level in the stack and number is the new top element.
	 * If the method call was preceded by enter(), the top element is overwritten.
	 * Ex. if number is 2 and the top element is 1, the new top element is 12.
	 * Ex2. If the top element is 1 and enter() preceded this method call, the
	 * new top element is number.
	 * @param number the number to be inserted in the top element.
	 */
	private void addNumberToStack(int number) {
		if(consoleValue == 0 && !entPressed) {
			for(int i = 3; i > 0; i--) {
				stack[i] = stack [i-1];
			}
		}
		consoleValue = consoleValue * 10 + number;
		stack[0] = consoleValue * sign;
	}
	

	/** Performs the specified operation on the stack.
	 * @param operation the operation type that is to be performed.
	 */
	public void execute(Operation operation) {
		switch (operation) {
			case PLUS: plus(); break;
			case MINUS: minus(); break;
			case TIMES: times(); break;
			case DIVIDES: divides(); break;
			case ENTER: enter(); break;
			case CLEAR: clear(); break;
			case CHS: chs(); break;
			case CLEARSTACK: clearStack(); break;
			case ZERO: addNumberToStack(0); break;
			case ONE: addNumberToStack(1); break;
			case TWO: addNumberToStack(2); break;
			case THREE: addNumberToStack(3); break;
			case FOUR: addNumberToStack(4); break;
			case FIVE: addNumberToStack(5); break;
			case SIX: addNumberToStack(6); break;
			case SEVEN: addNumberToStack(7); break;
			case EIGHT: addNumberToStack(8); break;
			case NINE: addNumberToStack(9); break;
		}
	}
}
