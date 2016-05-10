import java.util.ArrayList;


public class Pastry extends Product
{
	Pastry() {}

	public void getSelectedButton(int[] i, String[] k)
	{
		string.add("Pastry");
		for(int x = 0; x < i.length; x++)
        {
        	string.add(k[i[x]]);
        }
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).equals("Apricot Danish"))
			{
				price.add(400);
			}
			else if(string.get(x).equals("Prune Danish"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Crossant"))
			{
				price.add(250);
			}
			else if(string.get(x).equals("English Muffin"))
			{
				price.add(300);
			}
			else if(string.get(x).equals("Blueberry Muffin"))
			{
				price.add(300);
			}
		}
	}
}
