package calculator;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class CalcApplicationGraph {
	
	public static void main(String[] args) {
	/*	Remove the block comment bellow to get another appearance of the calculator
	 * (only tested on OS X)
	 */
/*	  try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}*/
	
		CalcView view = new CalcView("HP Calculator");
	}
}
