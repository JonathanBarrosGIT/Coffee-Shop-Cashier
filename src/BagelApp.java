import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BagelApp extends JFrame{

	public JPanel parent = new JPanel();
	public JPanel panel1 = new JPanel();
	public JPanel panel2a = new JPanel();
	public JPanel panel2b = new JPanel();
	public JPanel panel2c = new JPanel();
	public JPanel panel3 = new JPanel();
	public JLabel title;


	public JRadioButton product1 = new JRadioButton("Coffee");
	public JRadioButton product2 = new JRadioButton("Bagel");
	public JRadioButton product3 = new JRadioButton("Pastry");

	public ButtonGroup productgroup = new ButtonGroup();

	public JPanel subpanel1 = new JPanel();
	public JPanel subpanel2 = new JPanel();
	public JPanel subpanel3 = new JPanel();
	public JPanel subpanel4 = new JPanel();
	public JPanel subpanel5 = new JPanel();
	public JPanel subpanel6 = new JPanel();
	public JPanel subpanel7 = new JPanel();
	public JPanel subpanel8 = new JPanel();
	public JPanel subpanel9 = new JPanel();

	public JTextArea text = new JTextArea();

	public JScrollPane scroll = new JScrollPane(text);

	public JPanel buttons = new JPanel();

	public JButton button1 = new JButton("Enter Item");
	public JButton button2 = new JButton("Total");
	public JButton button3 = new JButton("New Order");

	public JRadioButton small = new JRadioButton("Small");
	public JRadioButton medium = new JRadioButton("Medium");
	public JRadioButton large = new JRadioButton("Large");
	public ButtonGroup group1 = new ButtonGroup();

	public JRadioButton decafe = new JRadioButton("DeCafe");
	public JRadioButton regular = new JRadioButton("Regular");
	public JRadioButton roast = new JRadioButton("French Roast");
	public ButtonGroup group2 = new ButtonGroup();

	public JCheckBox cream = new JCheckBox("Cream");
	public JCheckBox sugar = new JCheckBox("Sugar");

	// PANEL 2B

	public JRadioButton white = new JRadioButton("White");
	public JRadioButton wheat = new JRadioButton("Wheat");
	public JRadioButton salt = new JRadioButton("Salt");
	public JRadioButton seseme = new JRadioButton("Seseme");
	public JRadioButton popy = new JRadioButton("Popy");
	public ButtonGroup group4 = new ButtonGroup();

	public JRadioButton cc = new JRadioButton("Cream Cheese ");
	public JRadioButton lcc = new JRadioButton("Lowfat Cream Cheese ");
	public JRadioButton gc = new JRadioButton("Garlic Cream ");
	public JRadioButton butter = new JRadioButton("Butter ");
	public JRadioButton jam = new JRadioButton("Jam ");
	public ButtonGroup group5 = new ButtonGroup();

	public JCheckBox lox = new JCheckBox("Lox");
	public JCheckBox novalox = new JCheckBox("Nova Lox");

	public String[] pastrylist = {"Apricot Danish", "Prune Danish", "Crossant", "English Muffin", "Blueberry Muffin"};
	public JList list = new JList(pastrylist);
	public int[] indices = {};

	public JLabel quantitylabel = new JLabel("Quantity: ");
	public JTextField quantity = new JTextField(5);
	public JRadioButton membery = new JRadioButton("Member");
	public JRadioButton membern = new JRadioButton("Not Member");
	public ButtonGroup membergroup = new ButtonGroup();
	public JButton delete = new JButton("Delete Previous");
	public int q = 1;

	public BorderLayout layout;

	public boolean isMember;

	public Order order = Order.instance();
	public Coffee coffee = new Coffee();
	public Bagel bagel = new Bagel();
	public Pastry pastry = new Pastry();

	public BagelApp()
	{
		setTitle("Bagel Order Application");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		setBackground(Color.LIGHT_GRAY);

		buildPanel();
		add(panel3, BorderLayout.CENTER);
		add(title, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		add(parent, BorderLayout.WEST);

		setVisible(true);
	}

	private void buildPanel()
	{
		/* A very big build method because
		 * all the panels are pre-made
		 */

		// PARENT PANEL

		parent.setLayout(new BorderLayout(10,10));

		title = new JLabel("Order Entry Screen");
		title.setHorizontalAlignment(SwingConstants.CENTER);

		// PANEL1

		panel1.setBorder(BorderFactory.createTitledBorder("Products"));
		panel1.setLayout(new GridLayout(3,1));

		productgroup.add(product1);
		productgroup.add(product2);
		productgroup.add(product3);

		product1.addActionListener(new ButtonListener());
		product2.addActionListener(new ButtonListener());
		product3.addActionListener(new ButtonListener());

		panel1.add(product1);
		panel1.add(product2);
		panel1.add(product3);

		panel2a.setLayout(new GridLayout(3,1));
		panel2a.setPreferredSize(new Dimension(180, 650));
		panel2b.setLayout(new GridLayout(3,1));
		panel2b.setPreferredSize(new Dimension(180, 650));
		panel2c.setLayout(new GridLayout(2,1));
		panel2c.setPreferredSize(new Dimension(180, 650));

		// PANEL 2A

		subpanel1.setLayout(new GridLayout(3,1));
		subpanel2.setLayout(new GridLayout(3,1));
		subpanel3.setLayout(new GridLayout(2,1));

		subpanel1.setBorder(BorderFactory.createTitledBorder("Size"));

		small.setActionCommand("Small");
		medium.setActionCommand("Medium");
		large.setActionCommand("Large");

		small.addActionListener(new ButtonListener());
		medium.addActionListener(new ButtonListener());
		large.addActionListener(new ButtonListener());

		group1.add(small);
		group1.add(medium);
		group1.add(large);

		subpanel1.add(small);
		subpanel1.add(medium);
		subpanel1.add(large);

		subpanel2.setBorder(BorderFactory.createTitledBorder("Type"));

		regular.setActionCommand("Regular");
		decafe.setActionCommand("DeCafe");
		roast.setActionCommand("French Roast");

		regular.addActionListener(new ButtonListener());
		decafe.addActionListener(new ButtonListener());
		roast.addActionListener(new ButtonListener());

		group2.add(regular);
		group2.add(decafe);
		group2.add(roast);

		subpanel2.add(regular);
		subpanel2.add(decafe);
		subpanel2.add(roast);

		subpanel3.setBorder(BorderFactory.createTitledBorder("Extras"));

		cream.addActionListener(new ButtonListener());
		sugar.addActionListener(new ButtonListener());

		subpanel3.add(cream);
		subpanel3.add(sugar);

		panel2a.add(subpanel1);
		panel2a.add(subpanel2);
		panel2a.add(subpanel3);

		// PANEL 2B

		subpanel4.setLayout(new GridLayout(5,1));
		subpanel5.setLayout(new GridLayout(5,1));
		subpanel6.setLayout(new GridLayout(2,1));

		subpanel4.setBorder(BorderFactory.createTitledBorder("Bagel"));

		white.setActionCommand("White");
		wheat.setActionCommand("Wheat");
		salt.setActionCommand("Salt");
		seseme.setActionCommand("Seseme");
		popy.setActionCommand("Popy");

		white.addActionListener(new ButtonListener());
		wheat.addActionListener(new ButtonListener());
		salt.addActionListener(new ButtonListener());
		seseme.addActionListener(new ButtonListener());
		popy.addActionListener(new ButtonListener());

		group4.add(white);
		group4.add(wheat);
		group4.add(salt);
		group4.add(seseme);
		group4.add(popy);

		subpanel4.add(white);
		subpanel4.add(wheat);
		subpanel4.add(salt);
		subpanel4.add(seseme);
		subpanel4.add(popy);

		subpanel5.setBorder(BorderFactory.createTitledBorder("Spreads"));

		cc.setActionCommand("Cream Cheese ");
		lcc.setActionCommand("Lowfat Cream Cheese ");
		gc.setActionCommand("Garlic Cream ");
		butter.setActionCommand("Butter ");
		jam.setActionCommand("Jam ");

		cc.addActionListener(new ButtonListener());
		lcc.addActionListener(new ButtonListener());
		gc.addActionListener(new ButtonListener());
		butter.addActionListener(new ButtonListener());
		jam.addActionListener(new ButtonListener());

		group5.add(cc);
		group5.add(lcc);
		group5.add(gc);
		group5.add(butter);
		group5.add(jam);

		subpanel5.add(cc);
		subpanel5.add(lcc);
		subpanel5.add(gc);
		subpanel5.add(butter);
		subpanel5.add(jam);

		subpanel6.setBorder(BorderFactory.createTitledBorder("Toppings"));

		lox.addActionListener(new ButtonListener());
		novalox.addActionListener(new ButtonListener());

		subpanel6.add(lox);
		subpanel6.add(novalox);

		panel2b.add(subpanel4);
		panel2b.add(subpanel5);
		panel2b.add(subpanel6);

		// PANEL 2C

		subpanel7 = new JPanel();

		subpanel7.setLayout(new GridLayout());
		subpanel7.setBorder(BorderFactory.createTitledBorder("Pastries"));

		list.addListSelectionListener(new ListListener());

		subpanel7.add(list);
		panel2c.add(subpanel7);

		parent.add(panel1, BorderLayout.WEST);
		parent.add(panel2a, BorderLayout.CENTER);
		layout = (BorderLayout)parent.getLayout();

		product1.doClick();
		membern.doClick();

		// PANEL3

		panel3.setLayout(new BorderLayout());

		subpanel9.setLayout(new BorderLayout());

		membery.setActionCommand("Member");
		membern.setActionCommand("Not Member");

		delete.addActionListener(new ButtonListener());
		quantity.addActionListener(new ButtonListener());
		membern.addActionListener(new ButtonListener());
		membery.addActionListener(new ButtonListener());

		membergroup.add(membery);
		membergroup.add(membern);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);

		subpanel8.add(quantitylabel);
		subpanel8.add(quantity);
		subpanel8.add(membery);
		subpanel8.add(membern);
		subpanel8.add(delete);
		subpanel9.add(scroll, BorderLayout.CENTER);

		panel3.add(subpanel8, BorderLayout.SOUTH);
		panel3.add(subpanel9, BorderLayout.CENTER);

		// BUTTON PANEL

		buttons.setBackground(Color.black);

		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());

		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);


	}

	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(product1.isSelected())
			{
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2a, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				if(group1.getSelection() == null)
				{
					small.doClick();
				}
				if(group2.getSelection() == null)
				{
					regular.doClick();
				}
			}
			else if(product2.isSelected())
			{
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2b, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				if(group4.getSelection() == null)
				{
					white.doClick();
				}
			}
			else if(product3.isSelected())
			{
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2c, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
			}
			if(arg0.getActionCommand() == "Enter Item")
			{
				if(!quantity.getText().isEmpty())
				{
					try
					{
						q = Integer.parseInt(quantity.getText());
					}
					catch(NumberFormatException e)
					{
						q = 1;
					}
				}
				else
				{
					q = 1;
				}

				if(product1.isSelected())
				{
					coffee.getSelectedButton(group1, group2);
					if(sugar.isSelected())
					{
						coffee.getString().add("Extra Sugar");
						sugar.doClick();
					}
					if(cream.isSelected())
					{
						coffee.getString().add("Extra Cream");
						cream.doClick();
					}
					coffee.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(coffee.getPrice(), coffee.getString());
					}
					q = 1;
					coffee.clear();
					small.doClick();
					regular.doClick();
				}
				else if(product2.isSelected())
				{
					bagel.getSelectedButton(group4, group5);
					if(lox.isSelected())
					{
						bagel.getString().add("Lox Topping");
						lox.doClick();
					}
					if(novalox.isSelected())
					{
						bagel.getString().add("Nova Lox Topping");
						novalox.doClick();
					}
					bagel.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(bagel.getPrice(), bagel.getString());
					}
					q = 1;
					bagel.clear();
					white.doClick();
					group5.clearSelection();
				}
				else if(product3.isSelected())
				{
					pastry.getSelectedButton(indices, pastrylist);
					pastry.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(pastry.getPrice(), pastry.getString());
					}
					q = 1;
					pastry.clear();
				}

				printOrder(order.getOrder(), order.getOrderprice());
				quantity.setText("");

			}
			else if(arg0.getActionCommand() == "New Order")
			{
				order.clear();
				product1.doClick();
				small.doClick();
				regular.doClick();
				white.doClick();
				group5.clearSelection();
				text.setText("");
			}
			else if(arg0.getActionCommand() == "Total")
			{
				text.append(String.format("%n%100s%2s%.2f", "Subtotal: ","$", (float)order.calculateSubtotal()/100));
				text.append(String.format("%n%102s%2s%.2f", "Total: ","$", (float)order.calculateTotal(isMember)/100));
			}
			if(arg0.getActionCommand() == "Delete Previous")
			{
				int i = order.getOrder().size()-1;
				int k = order.getOrderprice().size()-1;
				boolean yes = false;
				int y = i;
				int x = k;

				while(!yes && !(i == -1 && k == -1))
				{
					if(order.getOrder().get(y).equals("Coffee")||order.getOrder().get(y).equals("Bagel")||order.getOrder().get(y).equals("Pastry"))
					{
						order.getOrder().remove(y);
						yes = true;
					}
					else
					{
						order.getOrder().remove(y);
						order.getOrderprice().remove(x);
						y--;
						x--;
					}
				}
				printOrder(order.getOrder(), order.getOrderprice());

			}
			if(membern.isSelected())
			{
				isMember = false;
			}
			else if(membery.isSelected())
			{
				isMember = true;
			}
		}
	}

	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0)
		{
			JList source;
			if (!arg0.getValueIsAdjusting())
			{
	            source = (JList)arg0.getSource();
				indices = source.getSelectedIndices();
	        }
		}
	}

	public void printOrder(ArrayList<String> list, ArrayList<Integer> list2)
	{
		int y = 0;
		text.setText("");
		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x).equals("Coffee")||list.get(x).equals("Bagel")||list.get(x).equals("Pastry"))
			{
				text.append(list.get(x)+"\n");
			}
			else
			{
				text.append("           "+list.get(x)+"\n");
				text.append(String.format("%107s%.2f\n","$", (float)list2.get(y)/100));
				y++;
			}
		}
	}

	public static void main(String[] args)
	{
		BagelApp app = new BagelApp();
	}

	//Getters and Setters
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
}
