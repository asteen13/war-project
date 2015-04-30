
import javax.swing.*;

public class war {
	// Written by: Andrew Steen and Malique Williams
	// This program allows the user to play the card game war.
	public static Card[] deck         = new Card[52];
	public static Card[] playerDeck   = new Card[52];
	public static Card[] computerDeck = new Card[52];
	public static int roundsPlayed;
	
	public static void main(String[] args) throws InterruptedException {
		
		deck = makeDeck();
		dealHands(deck);
		shufflePlayerDeck(playerDeck);
		shufflePlayerDeck(computerDeck);
		
		JOptionPane.showMessageDialog(null, "Welcome to War!"+
			"\nHere are the rules: \nEach round is separated by 5 seconds.", "War!", 
			JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "The top card from each deck is drawn." + 
			"\nThe player with the highest value card wins the round. \nThat player then"+
			" takes all cards that were played. \nIf both cards have the same value, war "+
			"is declared.", "Rules", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Whenever war occurs, 3 cards are taken"    + 
			"\nfrom each player's deck and put in the pile. \nThe next card from each " +
			"deck is then played.\nIf war occurs and a player" +" does not have \nat "  +
			"least 4 cards in their deck, they lose!", "Rules", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "If there is no winner after 1000 rounds" +
			"\nhave been played, the player with \nthe most remaining cards wins.", "Rules",
			JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Time to play!", "War!", JOptionPane.PLAIN_MESSAGE);
		
		while (hasCards(playerDeck) && hasCards(computerDeck)) {
			playRound(playerDeck, computerDeck);
				
			if (!hasCards(playerDeck)) {
				JOptionPane.showMessageDialog(null,"Player One is out of cards!" +
					"\nPlayer Two Wins!");
			}
			if (!hasCards(computerDeck)){
				JOptionPane.showMessageDialog(null, "Player Two is out of cards!" +
					"\nPlayer One Wins!");
			}
			if (roundsPlayed == 1000) {
				if (numCardsRemaining(playerDeck) > numCardsRemaining(computerDeck)) {
					JOptionPane.showMessageDialog(null, "Round limit reached." +
						"\nPlayer One Wins!");
				}
				else if (numCardsRemaining(playerDeck) < numCardsRemaining(computerDeck)) {
					JOptionPane.showMessageDialog(null, "Round limit reached." +
						"\nPlayer Two Wins!");
				}
				else if (numCardsRemaining(playerDeck) == numCardsRemaining(computerDeck)) {
					JOptionPane.showMessageDialog(null, "Round limit reached." + 
						"\nThe game ends in a Draw!");
				}
				System.exit(0);
			}
		}
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
				playerDeck[i/2] = deck[i];
			}
			else 
				computerDeck[i/2] = deck[i];
		}
	}	
		
	public static void playRound(Card[] playerDeck, Card[] computerDeck) 
		throws InterruptedException {
		// Plays a round.
		Card[] pot = new Card[52];
		Card playerOneCard, playerTwoCard;
		int compResult, playerCardsLeft, computerCardsLeft;;
		String roundResults;
		
		roundsPlayed++;
		
		playerOneCard = playerDeck[0];
		playerTwoCard = computerDeck[0];
		
		removeTopCard(playerDeck);
		addCardToBottom(pot, playerOneCard);
		removeTopCard(computerDeck);
		addCardToBottom(pot, playerTwoCard);
		
		compResult = compareCards(playerOneCard, playerTwoCard);
		roundResults = roundResults(playerOneCard, playerTwoCard);
		
		if (compResult == 0)
			WarGUI.showWarResults(playerOneCard, playerTwoCard);
		
		while (compResult == 0) {
			for (int i = 0; i < 3; i++) {
				if (!hasCards(playerDeck) || !hasCards(computerDeck))
					return;
				addCardToBottom(pot, playerDeck[0]);
				addCardToBottom(pot, computerDeck[0]);
				removeTopCard(playerDeck);
				removeTopCard(computerDeck);
			}
			if (!hasCards(playerDeck) || !hasCards(computerDeck))
				return;
			
			playerOneCard = playerDeck[0];
			playerTwoCard = computerDeck[0];
			
			removeTopCard(playerDeck);
			addCardToBottom(pot, playerOneCard);
			removeTopCard(computerDeck);
			addCardToBottom(pot, playerTwoCard);
			
			compResult = compareCards(playerOneCard, playerTwoCard);
			roundResults = roundResults(playerOneCard, playerTwoCard);
		}
		if (compResult > 0) {
			while (hasCards(pot)) {
				addCardToBottom(playerDeck, pot[0]);
				removeTopCard(pot);
			}	
		}
		else if (compResult < 0) {
			while (hasCards(pot)) {
				addCardToBottom(computerDeck, pot[0]);
				removeTopCard(pot);
			}
		}
		playerCardsLeft = numCardsRemaining(playerDeck);
		computerCardsLeft = numCardsRemaining(computerDeck);
		WarGUI.showResults(playerOneCard, playerTwoCard, roundResults, 
			playerCardsLeft, computerCardsLeft);
	}
	
	public static String roundResults(Card playerOneCard, Card playerTwoCard) {
		// Tells which player wins or if there is a war.
		int result;
		
		result = compareCards(playerOneCard, playerTwoCard);
		
		if (result == 0)
			return "War!\n";
		else if (result > 0)
			return "Player One wins this round.";
		else 
			return "Player Two wins this round.";
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
