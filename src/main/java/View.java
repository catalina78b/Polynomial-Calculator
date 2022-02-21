import javax.swing.*;
import java.awt.*;

public class View {
    JFrame f = new JFrame("Polynomial Calculator");
    JButton addButton,subtractButton,multiplyButton,divideButton,derivativeButton,integralButton;
    JTextField textField1;
    JTextField textField2;
    JLabel jLabel1;
    JLabel jLabel2;
    GridLayout gridLayout=new GridLayout(3,2);
    public View()
    {

        //f.setLayout(null);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiplicate");
        divideButton = new JButton("Divide");
        derivativeButton = new JButton("Derivative");
        integralButton = new JButton("Integral");
        textField1 = new JTextField(16);
        textField2=new JTextField(16);
        jLabel1=new JLabel("First polynomial");
        jLabel2=new JLabel("Second polynomial");

        jLabel1.setBounds(10,10,120,20);
        textField1.setBounds(150,10,120,20);

        jLabel2.setBounds(10,50,120,20);
        textField2.setBounds(150,50,120,20);

        textField1.setEditable(true);
        textField2.setEditable(true);
        JPanel p = new JPanel();
        p.setBackground(Color.pink);
        p.add(jLabel1);
        p.add(jLabel2);
        p.add(textField1);
        p.add(textField2);

        f.add(addButton);
        f.add(subtractButton);
        f.add(multiplyButton);
        f.add(divideButton);
        f.add(derivativeButton);
        f.add(integralButton);
        f.setLayout(new GridLayout(3,2));
        f.setSize(300, 300);
        f.add(p);

        f.setSize(250, 220);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        View view=new View();
    }
}
