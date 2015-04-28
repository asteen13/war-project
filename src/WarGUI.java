import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarGUI extends JFrame {


	public static void showResults(Card playerCard, Card computerCard, String winner) throws InterruptedException {

		JFrame F = new JFrame("War!");
		JPanel P1Card, P2Card, PBottom;
		//JButton btn = new JButton ("Play next round");
		JLabel card1 = new JLabel("Player one draws " + playerCard.rank + " of " + playerCard.suit);
		JLabel card2 = new JLabel("Player two draws " + computerCard.rank + " of " + computerCard.suit);
		JLabel result = new JLabel(winner);
		
		P1Card = new JPanel();
		P2Card = new JPanel();
		PBottom = new JPanel();
		
		//theHandler handler = new theHandler();
		
		//btn.addActionListener(handler);
		P1Card.add(card1);
		P2Card.add(card2);
		PBottom.add(result);
		//PBottom.add(btn);
		
		F.add(P1Card);
		F.add(P2Card);
		F.add(PBottom);
		F.setLayout(new FlowLayout());
		F.setSize(280, 150);
		F.setLocationRelativeTo(null);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread.sleep(5000);
		F.setVisible(false);
	}
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
		}
	}
}
