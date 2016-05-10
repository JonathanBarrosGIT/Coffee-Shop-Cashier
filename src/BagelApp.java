import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BagelApp extends JFrame{

	BagelAppProperties properties = new BagelAppProperties();

	private BagelApp()
	{
		setTitle("Bagel Order Application");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		setBackground(Color.LIGHT_GRAY);
		
		buildPanel();
		add(properties.panel3, BorderLayout.CENTER);
		add(properties.title, BorderLayout.NORTH);
		add(properties.buttons, BorderLayout.SOUTH);
		add(properties.parent, BorderLayout.WEST);
		
		setVisible(true);
		
		// CALL CLASSES
		properties.order = new Order();
		properties.coffee = new Coffee();
		properties.bagel = new Bagel();
		properties.pastry = new Pastry();
	}
	
	private void buildPanel()
	{
		/* A very big build method because
		 * all the panels are pre-made
		 */
		
		// PARENT PANEL
		
		properties.parent = new JPanel();
		properties.parent.setLayout(new BorderLayout(10,10));
		
		properties.title = new JLabel("Order Entry Screen");
		properties.title.setHorizontalAlignment(SwingConstants.CENTER);
		
		properties.panel1 = new JPanel();
		properties.panel2a = new JPanel();
		properties.panel2b = new JPanel();
		properties.panel2c = new JPanel();
		properties.panel3 = new JPanel();
		
		// PANEL1
		
		properties.panel1.setBorder(BorderFactory.createTitledBorder("Products"));
		properties.panel1.setLayout(new GridLayout(3,1));
		
		properties.product1 = new JRadioButton("Coffee");
		properties.product2 = new JRadioButton("Bagel");
		properties.product3 = new JRadioButton("Pastry");
		properties.productgroup = new ButtonGroup();
		
		properties.productgroup.add(properties.product1);
		properties.productgroup.add(properties.product2);
		properties.productgroup.add(properties.product3);
		
		properties.product1.addActionListener(new ButtonListener());
		properties.product2.addActionListener(new ButtonListener());
		properties.product3.addActionListener(new ButtonListener());
		
		properties.panel1.add(properties.product1);
		properties.panel1.add(properties.product2);
		properties.panel1.add(properties.product3);

		properties.panel2a.setLayout(new GridLayout(3,1));
		properties.panel2a.setPreferredSize(new Dimension(180, 650));
		properties.panel2b.setLayout(new GridLayout(3,1));
		properties.panel2b.setPreferredSize(new Dimension(180, 650));
		properties.panel2c.setLayout(new GridLayout(2,1));
		properties.panel2c.setPreferredSize(new Dimension(180, 650));

		properties.subpanel1 = new JPanel();
		properties.subpanel2 = new JPanel();
		properties.subpanel3 = new JPanel();
		
		// PANEL3

		properties.panel3.setLayout(new BorderLayout());

		properties.subpanel8 = new JPanel();
		properties.subpanel9 = new JPanel();
		properties.subpanel9.setLayout(new BorderLayout());

		properties.quantitylabel = new JLabel("Quantity: ");
		properties.quantity = new JTextField(5);
		properties.membery = new JRadioButton("Member");
		properties.membern = new JRadioButton("Not Member");
		properties.membergroup = new ButtonGroup();
		properties.delete = new JButton("Delete Previous");

		properties.membery.setActionCommand("Member");
		properties.membern.setActionCommand("Not Member");

		properties.delete.addActionListener(new ButtonListener());
		properties.quantity.addActionListener(new ButtonListener());
		properties.membern.addActionListener(new ButtonListener());
		properties.membery.addActionListener(new ButtonListener());

		properties.membergroup.add(properties.membery);
		properties.membergroup.add(properties.membern);

		properties.text = new JTextArea();
		properties.scroll = new JScrollPane(properties.text);
		properties.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		properties.text.setLineWrap(true);
		properties.text.setWrapStyleWord(true);
		properties.text.setEditable(false);

		properties.subpanel8.add(properties.quantitylabel);
		properties.subpanel8.add(properties.quantity);
		properties.subpanel8.add(properties.membery);
		properties.subpanel8.add(properties.membern);
		properties.subpanel8.add(properties.delete);
		properties.subpanel9.add(properties.scroll, BorderLayout.CENTER);

		properties.panel3.add(properties.subpanel8, BorderLayout.SOUTH);
		properties.panel3.add(properties.subpanel9, BorderLayout.CENTER);
		
		// BUTTON PANEL

		properties.buttons = new JPanel();
		properties.button1 = new JButton("Enter Item");
		properties.button2 = new JButton("Total");
		properties.button3 = new JButton("New Order");
		properties.buttons.setBackground(Color.black);

		properties.button1.addActionListener(new ButtonListener());
		properties.button2.addActionListener(new ButtonListener());
		properties.button3.addActionListener(new ButtonListener());

		properties.buttons.add(properties.button1);
		properties.buttons.add(properties.button2);
		properties.buttons.add(properties.button3);
		
		//panel2a

		properties.subpanel1.setLayout(new GridLayout(3,1));
		properties.subpanel2.setLayout(new GridLayout(3,1));
		properties.subpanel3.setLayout(new GridLayout(2,1));

		properties.subpanel1.setBorder(BorderFactory.createTitledBorder("Size"));

		properties.small = new JRadioButton("Small");
		properties.medium = new JRadioButton("Medium");
		properties.large = new JRadioButton("Large");
		properties.group1 = new ButtonGroup();

		properties.small.setActionCommand("Small");
		properties.medium.setActionCommand("Medium");
		properties.large.setActionCommand("Large");

		properties.small.addActionListener(new ButtonListener());
		properties.medium.addActionListener(new ButtonListener());
		properties.large.addActionListener(new ButtonListener());

		properties.group1.add(properties.small);
		properties.group1.add(properties.medium);
		properties.group1.add(properties.large);

		properties.subpanel1.add(properties.small);
		properties.subpanel1.add(properties.medium);
		properties.subpanel1.add(properties.large);

		properties.subpanel2.setBorder(BorderFactory.createTitledBorder("Type"));

		properties.regular = new JRadioButton("Regular");
		properties.decafe = new JRadioButton("DeCafe");
		properties.roast = new JRadioButton("French Roast");
		properties.group2 = new ButtonGroup();

		properties.regular.setActionCommand("Regular");
		properties.decafe.setActionCommand("DeCafe");
		properties.roast.setActionCommand("French Roast");

		properties.regular.addActionListener(new ButtonListener());
		properties.decafe.addActionListener(new ButtonListener());
		properties.roast.addActionListener(new ButtonListener());

		properties.group2.add(properties.regular);
		properties.group2.add(properties.decafe);
		properties.group2.add(properties.roast);

		properties.subpanel2.add(properties.regular);
		properties.subpanel2.add(properties.decafe);
		properties.subpanel2.add(properties.roast);

		properties.subpanel3.setBorder(BorderFactory.createTitledBorder("Extras"));

		properties.cream = new JCheckBox("Cream");
		properties.sugar = new JCheckBox("Sugar");

		properties.cream.addActionListener(new ButtonListener());
		properties.sugar.addActionListener(new ButtonListener());

		properties.subpanel3.add(properties.cream);
		properties.subpanel3.add(properties.sugar);

		properties.panel2a.add(properties.subpanel1);
		properties.panel2a.add(properties.subpanel2);
		properties.panel2a.add(properties.subpanel3);
		
		//panel2b

		properties.subpanel4 = new JPanel();
		properties.subpanel5 = new JPanel();
		properties.subpanel6 = new JPanel();

		properties.subpanel4.setLayout(new GridLayout(5,1));
		properties.subpanel5.setLayout(new GridLayout(5,1));
		properties.subpanel6.setLayout(new GridLayout(2,1));

		properties.subpanel4.setBorder(BorderFactory.createTitledBorder("Bagel"));

		properties.white = new JRadioButton("White");
		properties.wheat = new JRadioButton("Wheat");
		properties.salt = new JRadioButton("Salt");
		properties.seseme = new JRadioButton("Seseme");
		properties.popy = new JRadioButton("Popy");
		properties.group4 = new ButtonGroup();

		properties.white.setActionCommand("White");
		properties.wheat.setActionCommand("Wheat");
		properties.salt.setActionCommand("Salt");
		properties.seseme.setActionCommand("Seseme");
		properties.popy.setActionCommand("Popy");

		properties.white.addActionListener(new ButtonListener());
		properties.wheat.addActionListener(new ButtonListener());
		properties.salt.addActionListener(new ButtonListener());
		properties.seseme.addActionListener(new ButtonListener());
		properties.popy.addActionListener(new ButtonListener());

		properties.group4.add(properties.white);
		properties.group4.add(properties.wheat);
		properties.group4.add(properties.salt);
		properties.group4.add(properties.seseme);
		properties.group4.add(properties.popy);

		properties.subpanel4.add(properties.white);
		properties.subpanel4.add(properties.wheat);
		properties.subpanel4.add(properties.salt);
		properties.subpanel4.add(properties.seseme);
		properties.subpanel4.add(properties.popy);

		properties.subpanel5.setBorder(BorderFactory.createTitledBorder("Spreads"));

		properties.cc = new JRadioButton("Cream Cheese ");
		properties.lcc = new JRadioButton("Lowfat Cream Cheese ");
		properties.gc = new JRadioButton("Garlic Cream ");
		properties.butter = new JRadioButton("Butter ");
		properties.jam = new JRadioButton("Jam ");
		properties.group5 = new ButtonGroup();

		properties.cc.setActionCommand("Cream Cheese ");
		properties.lcc.setActionCommand("Lowfat Cream Cheese ");
		properties.gc.setActionCommand("Garlic Cream ");
		properties.butter.setActionCommand("Butter ");
		properties.jam.setActionCommand("Jam ");

		properties.cc.addActionListener(new ButtonListener());
		properties.lcc.addActionListener(new ButtonListener());
		properties.gc.addActionListener(new ButtonListener());
		properties.butter.addActionListener(new ButtonListener());
		properties.jam.addActionListener(new ButtonListener());

		properties.group5.add(properties.cc);
		properties.group5.add(properties.lcc);
		properties.group5.add(properties.gc);
		properties.group5.add(properties.butter);
		properties.group5.add(properties.jam);

		properties.subpanel5.add(properties.cc);
		properties.subpanel5.add(properties.lcc);
		properties.subpanel5.add(properties.gc);
		properties.subpanel5.add(properties.butter);
		properties.subpanel5.add(properties.jam);

		properties.subpanel6.setBorder(BorderFactory.createTitledBorder("Toppings"));

		properties.lox = new JCheckBox("Lox");
		properties.novalox = new JCheckBox("Nova Lox");

		properties.lox.addActionListener(new ButtonListener());
		properties.novalox.addActionListener(new ButtonListener());

		properties.subpanel6.add(properties.lox);
		properties.subpanel6.add(properties.novalox);

		properties.panel2b.add(properties.subpanel4);
		properties.panel2b.add(properties.subpanel5);
		properties.panel2b.add(properties.subpanel6);
		
		//panel2c

		properties.subpanel7 = new JPanel();

		properties.subpanel7.setLayout(new GridLayout());
		properties.subpanel7.setBorder(BorderFactory.createTitledBorder("Pastries"));

		properties.list = new JList(properties.pastrylist);

		properties.list.addListSelectionListener(new ListListener());

		properties.subpanel7.add(properties.list);
		properties.panel2c.add(properties.subpanel7);

		properties.parent.add(properties.panel1, BorderLayout.WEST);
		properties.parent.add(properties.panel2a, BorderLayout.CENTER);
		properties.layout = (BorderLayout)properties.parent.getLayout();

		properties.product1.doClick();
		properties.membern.doClick();
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(properties.product1.isSelected())
			{
				properties.parent.remove(properties.layout.getLayoutComponent(BorderLayout.CENTER));
				properties.parent.add(properties.panel2a, BorderLayout.CENTER);
				properties.parent.revalidate();
				properties.parent.repaint();
				if(properties.group1.getSelection() == null)
				{
					properties.small.doClick();
				}
				if(properties.group2.getSelection() == null)
				{
					properties.regular.doClick();
				}
			}
			else if(properties.product2.isSelected())
			{
				properties.parent.remove(properties.layout.getLayoutComponent(BorderLayout.CENTER));
				properties.parent.add(properties.panel2b, BorderLayout.CENTER);
				properties.parent.revalidate();
				properties.parent.repaint();
				if(properties.group4.getSelection() == null)
				{
					properties.white.doClick();
				}
			}
			else if(properties.product3.isSelected())
			{
				properties.parent.remove(properties.layout.getLayoutComponent(BorderLayout.CENTER));
				properties.parent.add(properties.panel2c, BorderLayout.CENTER);
				properties.parent.revalidate();
				properties.parent.repaint();
			}
			if(arg0.getActionCommand() == "Enter Item")
			{
				if(!properties.quantity.getText().isEmpty())
				{
					try
					{
						properties.q = Integer.parseInt(properties.quantity.getText());
					}
					catch(NumberFormatException e)
					{
						properties.q = 1;
					}
				}
				else
				{
					properties.q = 1;
				}

				if(properties.product1.isSelected())
				{
					properties.coffee.getSelectedButton(properties.group1, properties.group2);
					if(properties.sugar.isSelected())
					{
						properties.coffee.getString().add("Extra Sugar");
						properties.sugar.doClick();
					}
					if(properties.cream.isSelected())
					{
						properties.coffee.getString().add("Extra Cream");
						properties.cream.doClick();
					}
					properties.coffee.pricing();
					for(int x = 0; x < properties.q; x++)
					{
						properties.order.getOrder(properties.coffee.getPrice(), properties.coffee.getString());
					}
					properties.q = 1;
					properties.coffee.clear();
					properties.small.doClick();
					properties.regular.doClick();
				}
				else if(properties.product2.isSelected())
				{
					properties.bagel.getSelectedButton(properties.group4, properties.group5);
					if(properties.lox.isSelected())
					{
						properties.bagel.getString().add("Lox Topping");
						properties.lox.doClick();
					}
					if(properties.novalox.isSelected())
					{
						properties.bagel.getString().add("Nova Lox Topping");
						properties.novalox.doClick();
					}
					properties.bagel.pricing();
					for(int x = 0; x < properties.q; x++)
					{
						properties.order.getOrder(properties.bagel.getPrice(), properties.bagel.getString());
					}
					properties.q = 1;
					properties.bagel.clear();
					properties.white.doClick();
					properties.group5.clearSelection();
				}
				else if(properties.product3.isSelected())
				{
					properties.pastry.getSelectedButton(properties.indices, properties.pastrylist);
					properties.pastry.pricing();
					for(int x = 0; x < properties.q; x++)
					{
						properties.order.getOrder(properties.pastry.getPrice(), properties.pastry.getString());
					}
					properties.q = 1;
					properties.pastry.clear();
				}

				printOrder(properties.order.getOrder(), properties.order.getOrderprice());
				properties.quantity.setText("");

			}
			else if(arg0.getActionCommand() == "New Order")
			{
				properties.order.clear();
				properties.product1.doClick();
				properties.small.doClick();
				properties.regular.doClick();
				properties.white.doClick();
				properties.group5.clearSelection();
				properties.text.setText("");
			}
			else if(arg0.getActionCommand() == "Total")
			{
				properties.text.append(String.format("%n%100s%2s%.2f", "Subtotal: ","$", (float)properties.order.calculateSubtotal()/100));
				properties.text.append(String.format("%n%102s%2s%.2f", "Total: ","$", (float)properties.order.calculateTotal(properties.isMember)/100));
			}
			if(arg0.getActionCommand() == "Delete Previous")
			{
				int i = properties.order.getOrder().size()-1;
				int k = properties.order.getOrderprice().size()-1;
				boolean yes = false;
				int y = i;
				int x = k;

				while(!yes && !(i == -1 && k == -1))
				{
					if(properties.order.getOrder().get(y).equals("Coffee")||properties.order.getOrder().get(y).equals("Bagel")||properties.order.getOrder().get(y).equals("Pastry"))
					{
						properties.order.getOrder().remove(y);
						yes = true;
					}
					else
					{
						properties.order.getOrder().remove(y);
						properties.order.getOrderprice().remove(x);
						y--;
						x--;
					}
				}
				printOrder(properties.order.getOrder(), properties.order.getOrderprice());

			}
			if(properties.membern.isSelected())
			{
				properties.isMember = false;
			}
			else if(properties.membery.isSelected())
			{
				properties.isMember = true;
			}
		}
	}

	class ButtonListenerProduct1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(properties.product1.isSelected())
			{
				properties.parent.remove(properties.layout.getLayoutComponent(BorderLayout.CENTER));
				properties.parent.add(properties.panel2a, BorderLayout.CENTER);
				properties.parent.revalidate();
				properties.parent.repaint();
				if(properties.group1.getSelection() == null)
				{
					properties.small.doClick();
				}
				if(properties.group2.getSelection() == null)
				{
					properties.regular.doClick();
				}
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
				properties.indices = source.getSelectedIndices();
	        }
		}
	}
	
	private void printOrder(ArrayList<String> list, ArrayList<Integer> list2)
	{
		int y = 0;
		properties.text.setText("");
		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x).equals("Coffee")||list.get(x).equals("Bagel")||list.get(x).equals("Pastry"))
			{
				properties.text.append(list.get(x)+"\n");
			}
			else
			{
				properties.text.append("           "+list.get(x)+"\n");
				properties.text.append(String.format("%107s%.2f\n","$", (float)list2.get(y)/100));
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
		return properties.text;
	}

	public void setText(JTextArea text) {
		this.properties.text = text;
	}
	
	public boolean isMember() {
		return properties.isMember;
	}

	public void setMember(boolean isMember) {
		this.properties.isMember = isMember;
	}
}