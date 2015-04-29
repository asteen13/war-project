import javax.swing.*;
import java.awt.*;

public class WarGUI extends JFrame {

	public static void showResults(Card playerCard, Card computerCard,
		String winner, int playerCardsLeft, int comCardsLeft) 
			throws InterruptedException {
		JFrame F         = new JFrame("War!");
		JLabel card1     = new JLabel("Player One draws " + playerCard.rank   +
			    " of " + playerCard.suit   + ".");
		JLabel card2     = new JLabel("Player Two draws " + computerCard.rank + 
				" of " + computerCard.suit + ".");
		JLabel cardCount = new JLabel("Player One: " + playerCardsLeft + 
				" cards remaining.       Player Two: " 
				+ comCardsLeft + " cards remaining.");
		JLabel results   = new JLabel(winner);
		JPanel P1Card, P2Card, PBottom, PMid;
		
		P1Card  = new JPanel();
		P2Card  = new JPanel();
		PBottom = new JPanel();
		PMid    = new JPanel();
		
		P1Card.add(card1);
		P2Card.add(card2);
		PBottom.add(cardCount);
		PMid.add(results);
		
		F.setLayout(new FlowLayout());
		F.add(P1Card);
		F.add(P2Card);
		F.add(PMid);
		F.add(PBottom);
		
		F.setTitle("War!");
		F.setSize(500, 130);
		F.setResizable(false);
		F.setLocationRelativeTo(null);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread.sleep(5000);
		F.setVisible(false);
	}
	public static void showWarResults(Card playerCard, Card computerCard) 
				throws InterruptedException {
			JFrame F         = new JFrame("War!");
			JLabel card1     = new JLabel("Player One draws " + playerCard.rank   +
				    " of " + playerCard.suit   + ".");
			JLabel card2     = new JLabel("Player Two draws " + computerCard.rank + 
					" of " + computerCard.suit + ".");
			JLabel results   = new JLabel("This results in WAR!");
			JPanel P1Card, P2Card, PMid;
			
			P1Card  = new JPanel();
			P2Card  = new JPanel();
			PMid    = new JPanel();
			
			P1Card.add(card1);
			P2Card.add(card2);
			PMid.add(results);
			
			F.setLayout(new FlowLayout());
			F.add(P1Card);
			F.add(P2Card);
			F.add(PMid);
			
			F.setTitle("War!");
			F.setSize(500, 130);
			F.setResizable(false);
			F.setLocationRelativeTo(null);
			F.setVisible(true);
			F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Thread.sleep(5000);
			F.setVisible(false);
		}

}
