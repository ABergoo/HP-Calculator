package calculator;

import java.util.Scanner;
import static calculator.Operation.*;

public class CalcApplicationText {
	private Scanner scan = new Scanner(System.in);
	private Stack stack = new Stack();
	
	public static void main(String[] args) {
		new CalcApplicationText().runApplication();
	}
	
	
	/** Runs the application.
	 * @throws Checked exception if the user tries to use an unsupported operation.
	 * (Supported operations are: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,0 ,
	 * 	+, -, *, /, e, c, ch, chs.) 
	 * */
	private void runApplication() {
		printInstructions();
		while(true) {
			try {
				printStack();
				switch(scan.nextInt()) {
				case 0: stack.execute(ZERO); break;
				case 1: stack.execute(ONE); break;
				case 2: stack.execute(TWO); break;
				case 3: stack.execute(THREE); break;
				case 4: stack.execute(FOUR); break;
				case 5: stack.execute(FIVE); break;
				case 6: stack.execute(SIX); break;
				case 7: stack.execute(SEVEN); break;
				case 8: stack.execute(EIGHT); break;
				case 9: stack.execute(NINE); break;
				default: throw new Exception();
				}
			} catch (Exception e) {
				try {
					switch(scan.next()) {
					case "e": stack.execute(ENTER); break;
					case "c": stack.execute(CLEAR); break;
					case "cs": stack.execute(CLEARSTACK); break;
					case "chs": stack.execute(CHS); break;
					case "+": stack.execute(PLUS); break;
					case "-": stack.execute(MINUS); break;
					case "*": stack.execute(TIMES); break;
					case "/":
						stack.execute(DIVIDES); 
						if(stack.getElement(0) == 0) {
							System.out.println("Can't divide by zero");
						} break;
					case "x": System.exit(0);
					default: throw new Exception();
					}
				} catch (Exception e2) {
					System.out.println("\n You must either enter 0-9 or one of the specified calulation operations.");
				}
			}
		}
	}
	
	/** Prints instructions of how to use the application. */
	private void printInstructions() {
		System.out.println("To insert numbers to the Stack, just use the numbers 0-9. \n"
				+ "To use the standard operations on the stack, use +, -, * and /. \n"
				+ "To press ENTER, CLEAR, CLEARSTACK, and CHS, use e, c, cs and chs. \n"
				+ "To exit, press x. \n");
	}
	
	/** Prints a representation of the stack in the console window. */
	private void printStack() {
		System.out.println("");
		for(int i = 3; i >= 0 ; i--) {
			System.out.println("[" + Integer.toString(stack.getElement(i)) + "]");
		}
	}
	
}
