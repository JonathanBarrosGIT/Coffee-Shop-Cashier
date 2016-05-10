import java.util.ArrayList;
import javax.swing.ButtonGroup;


public class Coffee extends Product
{
	Coffee() {}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		String product = "";
		product = group.getSelection().getActionCommand()+" "+group2.getSelection().getActionCommand();
		
		string.add("Coffee");
		string.add(product);
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).startsWith("Small"))
			{
				price.add(300);
			}
			else if(string.get(x).startsWith("Medium"))
			{
				price.add(400);
			}
			else if(string.get(x).startsWith("Large"))
			{
				price.add(700);
			}
			else if(string.get(x).equals("Extra Sugar"))
			{
				price.add(20);
			}
			else if(string.get(x).equals("Extra Cream"))
			{
				price.add(20);
			}
		}
	}
}
