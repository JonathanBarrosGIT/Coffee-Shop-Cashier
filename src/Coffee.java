import Product.Product;

import javax.swing.ButtonGroup;


public class Coffee extends Products
{
	Coffee() {}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		String product = "";
		product = group.getSelection().getActionCommand()+" "+group2.getSelection().getActionCommand();
		
		string.add("Coffee");
		string.add(product);
	}
}
