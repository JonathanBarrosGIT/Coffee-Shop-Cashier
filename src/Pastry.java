public class Pastry extends Products
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
}
