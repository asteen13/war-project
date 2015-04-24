//	Test everything using Scanner first and switch to JOptionPane when we're all done.
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

//	Let's play a game of War!
public class war {
	public static Card[] deck = new Card[52];
	public static Card[] myHand = new Card[52];
	public static Card[] hand2 = new Card[52];
	public static int roundsPlayed, numberOfWars;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		deck = makeDeck();
		dealHands(deck);
		shufflePlayerDeck(myHand);
		shufflePlayerDeck(hand2);
		
		while (hasCards(myHand) && hasCards(hand2)) {
			System.out.println("Card Count: \nPlayer One: " + numCardsRemaining(myHand) 
					+ "\nPlayer Two: " + numCardsRemaining(hand2) + "\n");
			playRound(myHand, hand2);
			
			if (!hasCards(myHand))
				System.out.println("Player One is out of cards! \nPlayer Two Wins!");
			if (!hasCards(hand2))
				System.out.println("Player Two is out of cards! \nPlayer One Wins!");
			if (roundsPlayed == 1000) {
				System.out.println("Game over.");
				System.out.println("number of wars: " + numberOfWars);
				System.exit(0);
			}
		}
		
		
		//for (int i=0; i < 26; i++) {
		//	System.out.println(myHand[i].rank + " of " + myHand[i].suit);
		//}
		//System.out.println(countCards(deck));
	}
	
	public static Card[] makeDeck() {
		// Initializes and shuffles the deck.
		
		int temp1, temp2;
		Card tempCard;
	
		for (int i = 0; i <= deck.length-1; i++) {
			deck[i] = new Card();
			deck[i].value = i % 13 + 1;
		
			// Assigns the rank of each card.
			if (deck[i].value == 1)
				deck[i].rank = "Ace";
			else if (deck[i].value == 11)
				deck[i].rank = "Jack";
			else if (deck[i].value == 12)
				deck[i].rank = "Queen";
			else if (deck[i].value == 13)
				deck[i].rank = "King";
			else 
				deck[i].rank = Integer.toString(deck[i].value);
			
			// Assigns the suit of each card.
			if (i == 0 || i < 13)
				deck[i].suit = "Spades";
			else if (i == 13 || i < 26)
				deck[i].suit = "Hearts";
			else if (i == 26 || i < 39)
				deck[i].suit = "Clubs";
			else deck[i].suit = "Diamonds";
		}
		
		// Shuffles the deck.
		for (int i = 0; i <= 10000; i++) {
			temp1 = (int)(Math.random() * 52);
			temp2 = (int)(Math.random() * 52);
			tempCard = deck[temp1];
			deck[temp1] = deck[temp2];
			deck[temp2] = tempCard;
		}
		
		return deck;
	}
	
	public static void shufflePlayerDeck(Card[] deck) {
		// Shuffles the deck of each player.
		
		int temp1, temp2;
		Card tempCard;
		
		for (int i = 0; i <= 10000; i++) {
			temp1 = (int)(Math.random() * 26);
			temp2 = (int)(Math.random() * 26);
			tempCard = deck[temp1];
			deck[temp1] = deck[temp2];
			deck[temp2] = tempCard;
		}
	}
	
	public static void dealHands(Card[] deck) {
	// Deals the hands.
		
		for (int i=0; i<52; i++) {
			if (i % 2 == 0) {
				myHand[i/2] = deck[i];
			}
			else 
				hand2[i/2] = deck[i];
		}
	}	
		
	public static void playRound(Card[] myHand, Card[] hand2) {
		// Plays a round.
		
		Card[] pot = new Card[52];
		Card playerOneCard, playerTwoCard;
		int compResult;
		
		roundsPlayed++;
		System.out.println("Next Round!");
		
		playerOneCard = myHand[0];
		playerTwoCard = hand2[0];
		
		removeTopCard(myHand);
		addCardToBottom(pot, playerOneCard);
		removeTopCard(hand2);
		addCardToBottom(pot, playerTwoCard);
		
		compResult = compareCards(playerOneCard, playerTwoCard);
		printResults(playerOneCard, playerTwoCard);
		
		while (compResult == 0) {
			numberOfWars++;
			for (int i = 0; i < 3; i++) {
				if (!hasCards(myHand) || !hasCards(hand2))
					return;
				addCardToBottom(pot, myHand[0]);
				addCardToBottom(pot, hand2[0]);
				removeTopCard(myHand);
				removeTopCard(hand2);
			}
			
			if (!hasCards(myHand) || !hasCards(hand2))
				return;
			
			playerOneCard = myHand[0];
			playerTwoCard = hand2[0];
			
			removeTopCard(myHand);
			addCardToBottom(pot, playerOneCard);
			removeTopCard(hand2);
			addCardToBottom(pot, playerTwoCard);
			
			compResult = compareCards(playerOneCard, playerTwoCard);
			printResults(playerOneCard, playerTwoCard);
		}
			
		if (compResult > 0) {
			while (hasCards(pot)) {
				addCardToBottom(myHand, pot[0]);
				removeTopCard(pot);
			}	
		}
		else if (compResult < 0) {
			while (hasCards(pot)) {
				addCardToBottom(hand2, pot[0]);
				removeTopCard(pot);
			}
		}
	}
	
	public static void printResults(Card playerOneCard, Card playerTwoCard) {
		// Tells what card was drawn by each player, and which player wins or 
		// if there is a war.
		
		int result;
		
		System.out.println("Player one draws " + playerOneCard.rank+ " of " +
				playerOneCard.suit);
		System.out.println("Player two draws " + playerTwoCard.rank + " of " +
				playerTwoCard.suit);
		result = compareCards(playerOneCard, playerTwoCard);
		
		if (result == 0)
			System.out.println("War!\n");
		else if (result > 0)
			System.out.println("Player one wins this round.\n");
		else 
			System.out.println("Player two wins this round.\n");
	}
	
	public static void removeTopCard(Card[] hand) {
		// Removes the first card from the deck.
		
		for (int i = 0; i < hand.length-1; i++)
			hand[i] = hand[i+1];
		
	}
	
	public static void addCardToBottom(Card[] deck, Card newCard) {
		// Adds a won card to the winner's deck.
		
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] == null) {
				deck[i] = newCard;
				return;
			}
		}
		
	}
	
	public static int compareCards(Card card1, Card card2) {
		// Compares two cards to determine which has a higher value.
		// A value of 0 means a tie, a positive value means player one's
		// card is higher, and a negative value means player two's card
		// is higher.
		
		if (card1.value == card2.value) 
			return 0;
		else if (card1.value == 1)
			return 1;
		else if (card2.value == 1)
			return -1;
		else if (card1.value > card2.value)
			return 1;
		else 
			return -1;
		
	}
	
	public static boolean hasCards(Card[] deck) {
		// Checks to see if a deck has any cards in it.
		
		for (int i=0; i < deck.length; i ++) {
			if (deck[i] != null)
				return true;
		}
		return false;
	}
	
	public static int numCardsRemaining(Card[] deck) {
		// Counts the number of cards in a deck and returns this value.
		
		int cardsLeft;
		cardsLeft = 0;
		
		for (int i = 0; i < deck.length; i++){
			if (deck[i] != null)
				cardsLeft++;
		}
		return cardsLeft;
	}
	
}
