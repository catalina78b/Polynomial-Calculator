import javax.swing.*;
import java.awt.*;

public class View {
    JFrame f = new JFrame("Polynomial Calculator");
    JButton addButton, subtractButton, multiplyButton, divideButton, derivativeButton, integralButton,
            button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus,
            buttonMinus, buttonInmultire, buttonImpartire, buttonPutere, buttonPunct, buttonDel, buttonX;
    JTextField textField1, textField2, textField3;
    JLabel jLabel1, jLabel2, jLabel3;
    GridLayout gridLayout = new GridLayout(3, 3);
    JPanel p = new JPanel(new BorderLayout());
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel(gridLayout);
    JPanel p5 = new JPanel(gridLayout);
    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\40783\\Dropbox\\My PC (DESKTOP-MGL16OR)\\Desktop\\PT2022_30221_BURUIAN_CATALINA_ASSIGNMENT_1\\src\\main\\java\\icon.png");

    public View() {
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiplicate");
        divideButton = new JButton("Divide");
        derivativeButton = new JButton("Derivate");
        integralButton = new JButton("Integrate");

        textField1 = new JTextField(16);
        textField2 = new JTextField(16);
        textField3 = new JTextField(16);

        jLabel1 = new JLabel("First polynomial");
        jLabel2 = new JLabel("Second polynomial");
        jLabel3 = new JLabel("Result");

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonInmultire = new JButton("*");
        buttonImpartire = new JButton("/");
        buttonPutere = new JButton("^");
        buttonDel = new JButton("C");
        buttonDel.setBackground(new Color(223, 255, 128));
        buttonPunct = new JButton(".");
        buttonX = new JButton("x");


        jLabel1.setBounds(10, 10, 120, 20);
        textField1.setBounds(130, 10, 120, 20);

        jLabel2.setBounds(10, 50, 120, 20);
        textField2.setBounds(130, 50, 120, 20);

        jLabel3.setBounds(10, 90, 120, 20);
        textField3.setBounds(130, 90, 120, 20);

        textField1.setEditable(true);
        textField2.setEditable(true);
        textField3.setEditable(false);

        p1.setBackground(new java.awt.Color(149, 252, 237));
        p1.setPreferredSize(new Dimension(300, 100));
        p1.add(jLabel1);
        p1.add(jLabel2);
        p1.add(textField1);
        p1.add(textField2);
        p1.add(jLabel3);
        p1.add(textField3);

        p2.setBackground(new java.awt.Color(93, 168, 167));
        p2.add(addButton);
        p2.add(subtractButton);
        p2.add(multiplyButton);
        p2.add(divideButton);
        p2.add(derivativeButton);
        p2.add(integralButton);

        p4.add(button1);
        p4.add(button2);
        p4.add(button3);
        p4.add(button4);
        p4.add(button5);
        p4.add(button6);
        p4.add(button7);
        p4.add(button8);
        p4.add(button9);

        p5.add(button0);
        p5.add(buttonPlus);
        p5.add(buttonMinus);
        p5.add(buttonInmultire);
        p5.add(buttonImpartire);
        p5.add(buttonPutere);
        p5.add(buttonPunct);
        p5.add(buttonX);
        p5.add(buttonDel);

        p3.setBackground(new java.awt.Color(93, 168, 167));
        p3.add(p4, BorderLayout.EAST);
        p3.add(p5, BorderLayout.WEST);

        p.add(p1);
        p.add(p2);
        p.add(p3);

        p1.setLayout(null);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(new Color(93, 168, 167));

        f.add(p);
        f.setIconImage(icon);
        f.setSize(300, 350);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
