import javax.swing.*;
import java.awt.*;

public class WarGUI extends JFrame {
	
	public static JLabel card1 = new JLabel();
	public static JLabel card2 = new JLabel();
	public static JLabel result = new JLabel();
	public static Card playerCard = new Card();
	public static Card computerCard = new Card();
	
	public static void getCard(Card[] deck, Card[] deck2) {
		playerCard = deck[0];
		computerCard = deck2[0];
	}
	
	public static void setLabels(Card playerCard, Card computerCard) {
		card1.setText(playerCard.rank + " of " + playerCard.suit);
		card2.setText(computerCard.rank + " of " + computerCard.suit);
		result.setText("words");
	}
	
	public WarGUI() {
		JFrame F = new JFrame("War!");
		JPanel P1Card, P2Card, PBottom;
		JButton btn;
		
		P1Card = new JPanel();
		P2Card = new JPanel();
		PBottom = new JPanel();
		P1Card.add(card1);
		P2Card.add(card2);
		PBottom.add(result);
		
	}
		
}
