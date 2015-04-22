//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;
import javax.swing.JOptionPane;

//	Let's play a game of War!
public class war {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Card[] deck = null;
		Card[] myHand = new Card[52];
		Card[] hand2 = new Card[52];
		
		//	Introduce the whole deck.
		
		
		deck = makeDeck();
		
		// Deals the hands
		for (int i=0; i<52; i++) {
			if (i % 2 == 0) {
				myHand[i/2] = deck[i];
			}
			else 
				hand2[i/2] = deck[i];
		}
		
		for (int i=0; i < 52; i++) {
			System.out.println((deck[i].value)%13 + " of " + deck[i].suit);
		}
		System.out.println(countCards(myHand));
	}
	
	public static Card[] makeDeck() {
		// Initializes and shuffles the deck.
		int temp1, temp2;
		Card tempCard;
		
		Card[] deck = new Card[52];
		for (int i = 0; i <= deck.length-1; i++) {
			deck[i] = new Card();
			deck[i].value = i;
			if (i == 0 || i < 13)
				deck[i].suit = "Spades";
			else if (i == 13 || i < 26)
				deck[i].suit = "Hearts";
			else if (i == 26 || i < 39)
				deck[i].suit = "Clubs";
			else deck[i].suit = "Diamonds";
		}
		for (int i = 0; i <= 100; i++) {
			temp1 = (int)(Math.random() * 52);
			temp2 = (int)(Math.random() * 52);
			tempCard = deck[temp1];
			deck[temp1] = deck[temp2];
			deck[temp2] = tempCard;
		}
		
		return deck;
	}
	
	
	
	public static void playRound(Card[] myHand, Card[] hand2) {
		
	}
	
	public static void printResults(int playerOneCard, int playerTwoCard) {
		
	}
	
	public static void removeTopCard(Card[] hand) {
		for (int i = 0; i < hand.length-1; i++)
			hand[i] = hand[i+1];
		
	}
	
	public static void addCardtoBottom(Card[] deck, Card newCard) {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] == null) {
				deck[i] = newCard;
				return;
			}
		}
		
	}
	
	public static int compareCards(int card1, int card2) {
		int highCard;
		highCard = Math.max(card1, card2);
		return highCard;
		
	}
	
	public static boolean hasCards(Card[] deck) {
		for (int i=0; i < deck.length; i ++) {
			if (deck[i] != null)
				return true;
		}
		return false;
	}
	
	public static int countCards(Card[] deck) {
		int cardsLeft;
		cardsLeft = 0;
		
		for (int i = 0; i < deck.length; i++){
			if (deck[i] != null)
				cardsLeft++;
		}
		return cardsLeft;
	}
	
}


