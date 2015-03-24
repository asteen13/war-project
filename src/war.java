//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;
import javax.swing.JOptionPane;

//	Let's play a game of War!
public class War {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
<<<<<<< HEAD
=======
		int[] deck;
>>>>>>> origin/master
		
		//	Introduce the whole deck.
		String[] deck = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		double card = Math.random() * deck.length ;
		double wSuit = Math.random() * suit.length;
		
<<<<<<< HEAD
		System.out.print(deck[(int) card] + " of " + suit[(int)wSuit]);
=======
		
	}
	
	public static void highestCard(int card1, int card2) {
		if (card1 > card2)
			JOptionPane.showMessageDialog(null, "You win.");
		else if (card1 < card2)
			JOptionPane.showMessageDialog(null, "You lose.");
		else if (card1 == card2) {
			int card3, card4;
			//card3 = next card from player deck
			//card4 = next card from computer deck
			highestCard(card3, card4);
		}
			
>>>>>>> origin/master
	}
	
}
