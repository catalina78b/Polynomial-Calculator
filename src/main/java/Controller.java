import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Controller {
    public View view;
    public Model model;
    int selected = 0;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void addALButton(JButton button, String text) {
        if (selected == 1) {
            if (button.getActionListeners().length != 0) {
                ActionListener actionListener = button.getActionListeners()[0];
                button.removeActionListener(actionListener);
            }
            if (text.equals(""))
                button.addActionListener(e -> view.textField1.setText(text));
            else

                button.addActionListener(e -> view.textField1.setText(view.textField1.getText() + text));

        } else if (selected == 2) {

            if (button.getActionListeners().length != 0) {
                ActionListener actionListener = button.getActionListeners()[0];
                button.removeActionListener(actionListener);
            }
            if (text.equals(""))
                button.addActionListener(e -> view.textField2.setText(text));
            else
                button.addActionListener(e -> view.textField2.setText(view.textField2.getText() + text));

        }
    }

    public void initController() {
        view.textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                selected = 1;
                buttons();
            }
        });
        view.textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                selected = 2;
                buttons();
            }
        });
    }

    public void buttons() {
        addALButton(view.button0, "0");
        addALButton(view.button1, "1");
        addALButton(view.button2, "2");
        addALButton(view.button3, "3");
        addALButton(view.button4, "4");
        addALButton(view.button5, "5");
        addALButton(view.button6, "6");
        addALButton(view.button7, "7");
        addALButton(view.button8, "8");
        addALButton(view.button9, "9");
        addALButton(view.buttonX, "x");
        addALButton(view.buttonPunct, ".");
        addALButton(view.buttonDel, "");
        addALButton(view.buttonPutere, "^");
        addALButton(view.buttonImpartire, "/");
        addALButton(view.buttonInmultire, "*");
        addALButton(view.buttonMinus, "-");
        addALButton(view.buttonPlus, "+");
    }

    Polynomial p1, p2;
    String res;

    void addActionListener() {
        view.addButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.addButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
        view.subtractButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.subtractButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
        view.multiplyButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.multiplyButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
        view.divideButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.divideButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
        view.integralButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.integralButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
        view.derivativeButton.addActionListener(e -> {
            p1 = model.getPolynomial(view.textField1.getText());
            p2 = model.getPolynomial(view.textField2.getText());
            res = model.getResult(p1, p2, view.derivativeButton.getText());
            view.textField3.setEditable(true);
            if (res.equals(""))
                view.textField3.setText("0");
            else
                view.textField3.setText(res);
        });
    }


}





