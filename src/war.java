//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;

import javax.swing.JOptionPane;

//	Let's play a game of War!
public class war {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] deck = null;
		int[] myHand = new int[52];
		int[] hand2 = new int[52];
		
		//	Introduce the whole deck.
		String[] card = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		deck = makeDeck();
		
		// Deals the hands
		for (int i=0; i<52; i++) {
			if (i % 2 == 0) {
				myHand[i/2] = deck[i];
			}
			else 
				hand2[i/2] = deck[i];
		}
		
		for (int i=0; i < 26; i++) {
			String suit1 = suit[myHand[i] / 13];
			String rank = card[myHand[i] % 13];
			System.out.println("Card number " + myHand[i+1] + ": " + rank + " of " + suit1);
		}
		
	}
	
	public static int[] makeDeck() {
		// Initializes and shuffles the deck.
		int temp, tempCard;
		
		int[] deck = new int[52];
		for (int i = 0; i <= deck.length-1; i++) 
			deck[i] = i;
		
		for (int i = 0; i <= deck.length-1; i++) {
			tempCard = (int)(Math.random() * 52);
			temp = deck[i];
			deck[i] = deck[tempCard];
			deck[tempCard] = temp;
		}
		return deck;
	}
	
	
	
	public static void playRound(int[] myHand, int[] hand2) {
		
	}
	
	public static void printResults(Card playerOneCard, Card playerTwoCard) {
		
	}
	
	public static void removeTopCard(Card[] deck) {
		
	}
	
	public static void addCardtoBottom(Card[] deck, Card[] newCard) {
		
	}
	
	public static int compareCards(Card card1, Card card2) {
		
	}
	
	public static boolean hasCards(Card[] deck) {
		
	}
	
	public static int countCards(Card[] deck) {
		
	}
	
}


