//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;

import javax.swing.JOptionPane;

//	Let's play a game of War!
public class war {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] deck = null;
		int[] hand1 = new int[52];
		int[] hand2 = new int[52];
//		Introduce the whole deck.
		String[] card = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		deck = makeDeck();
		hand1 = dealHands(deck);
		
		for (int i = 0; i <= 26; i++)
			System.out.println(hand1);
		
		for (int i=0; i < 4; i++) {
			String suit1 = suit[deck[i] / 13];
			String rank = card[deck[i] % 13];
			System.out.println("Card number " + deck[i+1] + ": " + rank + " of " + suit1);
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
	public static int[] makeDeck() {
		// Initializes and shuffles the deck.
		int temp, tempCard;
		
		int[] deck = new int[52];
		for (int i = 0; i <= deck.length-1; i++) 
			deck[i] = i;
		
		for (int i = 0; i <= deck.length-1; i++){
			tempCard = (int)(Math.random() * 52);
			temp = deck[i];
			deck[i] = deck[tempCard];
			deck[tempCard] = temp;
		}
		return deck;
	}
	
	public static int[] dealHands(int[] deck) {
		int[] hand1 = null;
		for (int i = 0; i <= deck.length-1; i++) {
			for (int j = 0; j <= 26; j++){
				if ((deck[i] & 1) == 0)
					hand1[j] = deck[i];
			}
		}
		return hand1;
	}
}
