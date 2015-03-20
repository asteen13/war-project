import java.util.Scanner;
import javax.swing.JOptionPane;

public class War {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] deck;
		
		
		
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
			
	}
	
}
