//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;
import javax.swing.JOptionPane;

//	Let's play a game of War!
public class war {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] deck;
//		Introduce the whole deck.
		String[] card = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		deck = new int[52];
		for (int i = 0; i <= deck.length-1; i++) {
			deck[i] = i;
		}
		for (int i=0; i < 4; i++) {
			String suit1 = suit[deck[i] / 13];
			String rank = card[deck[i] % 13];
			System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit1);
		}
		
		
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
			
		}
	}
}
