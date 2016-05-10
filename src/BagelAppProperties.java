import javax.swing.*;
import java.awt.*;

/**
 * By Jonathan Correia de Barros on 10/05/16.
 *
 * Application of Extract Class in order to fix the Code Smell: Large Class.
 * By applying this pattern, now there is a class to keep the main variables in only one place.
 * This Code Smell has been found on the class: BagelApp.java
 */

class BagelAppProperties {
    
    public int width = 800;
    public int height = 600;
    public JPanel parent;
    public JPanel panel1;
    public JPanel panel2a;
    public JPanel panel2b;
    public JPanel panel2c;
    public JPanel panel3;
    public JLabel title;
    public JPanel buttons;

    public JRadioButton product1;
    public JRadioButton product2;
    public JRadioButton product3;
    public ButtonGroup productgroup;

    public JPanel subpanel1;
    public JPanel subpanel2;
    public JPanel subpanel3;
    public JPanel subpanel4;
    public JPanel subpanel5;
    public JPanel subpanel6;
    public JPanel subpanel7;
    public JPanel subpanel8;
    public JPanel subpanel9;

    public JTextArea text;

    public JScrollPane scroll;

    //	PANEL 2A

    public JButton button1;
    public JButton button2;
    public JButton button3;

    public JRadioButton small;
    public JRadioButton medium;
    public JRadioButton large;
    public ButtonGroup group1;

    public JRadioButton decafe;
    public JRadioButton regular;
    public JRadioButton roast;
    public ButtonGroup group2;

    public JCheckBox cream;
    public JCheckBox sugar;

    // PANEL 2B

    public JRadioButton white;
    public JRadioButton wheat;
    public JRadioButton salt;
    public JRadioButton seseme;
    public JRadioButton popy;
    public ButtonGroup group4;

    public JRadioButton cc;
    public JRadioButton lcc;
    public JRadioButton gc;
    public JRadioButton butter;
    public JRadioButton jam;
    public ButtonGroup group5;

    public JCheckBox lox;
    public JCheckBox novalox;

    public String[] pastrylist = {"Apricot Danish", "Prune Danish", "Crossant", "English Muffin", "Blueberry Muffin"};
    public JList list;
    public int[] indices = {};

    public JLabel quantitylabel;
    public JTextField quantity;
    public JRadioButton membery;
    public JRadioButton membern;
    public ButtonGroup membergroup;
    public JButton delete;
    public int q = 1;

    public BorderLayout layout;

    public boolean isMember;

    public Order order;
    public Coffee coffee;
    public Bagel bagel;
    public Pastry pastry;
    
}