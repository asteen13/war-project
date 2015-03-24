//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;
import javax.swing.JOptionPane;

//	Let's play a game of War!
public class War {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//	Introduce the whole deck.
		String[] deck = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		double card = Math.random() * deck.length ;
		double wSuit = Math.random() * suit.length;
		
		System.out.print(deck[(int) card] + " of " + suit[(int)wSuit]);
	}
}
