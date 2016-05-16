import Product.Bagel.Extra;
import Product.Product;

import javax.swing.ButtonGroup;


public class Bagel extends Products
{
	Bagel() {}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		string.add("Bagel");
		String product = group.getSelection().getActionCommand();
		string.add(product);

		if(group2.getSelection() != null)
		{
			product = group2.getSelection().getActionCommand();
			string.add(product);
		}
	}
}
