package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay
{
	//A better way of getting text on your screen
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String questionAsked)
	{
		String response ="";
		
		response += JOptionPane.showInputDialog(null, questionAsked);
		
		return response;
	}
	
}
