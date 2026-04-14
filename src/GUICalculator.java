import javax.swing.*;
import java.awt.*;

public class GUICalculator extends JFrame {

    public static void main(String[] args) {
        new GUICalculator();
    }

    private JTextField display;
    private String operator = "";
    private double firstNum = 0;
    private boolean startNewNumber = true;


    private Logic calc = new Logic();

    private final Color bg = new Color(255, 235, 240);       // Soft blush pink background
    private final Color numColor = new Color(255, 182, 193);      // Light pink for number buttons
    private final Color operationColor = new Color(255, 182, 193);       // Hot pink for operations (+, -, *, /)
    private final Color textColor = new Color(80, 20, 50);

    public GUICalculator() {
        setTitle("Calculator");
        setSize(345, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 36));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBounds(10, 10, 310, 60);
        display.setBackground(new Color(255, 240, 245));
        display.setForeground(textColor);
        add(display);


        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(10, 80, 70, 60);
        btnClear.addActionListener(e -> clearDisplay());
        btnClear.setBackground(textColor);
        btnClear.setForeground(Color.WHITE);
        add(btnClear);

        JButton btnDiv = new JButton("/");
        btnDiv.setBounds(90, 80, 70, 60);
        btnDiv.setBackground(operationColor);
        btnDiv.setForeground(textColor);
        btnDiv.setFont(new Font("Arial", Font.BOLD, 20));
        btnDiv.addActionListener(e -> setOperator("/"));
        add(btnDiv);

        JButton btnMul = new JButton("*");
        btnMul.setBounds(170, 80, 70, 60);
        btnMul.setBackground(operationColor);
        btnMul.setForeground(textColor);
        btnMul.setFont(new Font("Arial", Font.BOLD, 20));
        btnMul.addActionListener(e -> setOperator("*"));
        add(btnMul);

        JButton btnSub = new JButton("-");
        btnSub.setBounds(250, 80, 70, 60);
        btnSub.setBackground(operationColor);
        btnSub.setForeground(textColor);
        btnSub.setFont(new Font("Arial", Font.BOLD, 20));
        btnSub.addActionListener(e -> setOperator("-"));
        add(btnSub);


        JButton btn7 = new JButton("7");
        btn7.setBounds(10, 150, 70, 60);
        btn7.addActionListener(e -> addNumberToDisplay("7"));
        add(btn7);

        JButton btn8 = new JButton("8");
        btn8.setBounds(90, 150, 70, 60);
        btn8.addActionListener(e -> addNumberToDisplay("8"));
        add(btn8);

        JButton btn9 = new JButton("9");
        btn9.setBounds(170, 150, 70, 60);
        btn9.addActionListener(e -> addNumberToDisplay("9"));
        add(btn9);


        JButton btnAdd = new JButton("+");
        btnAdd.setBounds(250, 150, 70, 130);
        btnAdd.setBackground(operationColor);
        btnAdd.setForeground(textColor);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnAdd.addActionListener(e -> setOperator("+"));
        add(btnAdd);

        JButton btn4 = new JButton("4");
        btn4.setBounds(10, 220, 70, 60);
        btn4.addActionListener(e -> addNumberToDisplay("4"));
        add(btn4);

        JButton btn5 = new JButton("5");
        btn5.setBounds(90, 220, 70, 60);
        btn5.addActionListener(e -> addNumberToDisplay("5"));
        add(btn5);

        JButton btn6 = new JButton("6");
        btn6.setBounds(170, 220, 70, 60);
        btn6.addActionListener(e -> addNumberToDisplay("6"));
        add(btn6);


        JButton btn1 = new JButton("1");
        btn1.setBounds(10, 290, 70, 60);
        btn1.addActionListener(e -> addNumberToDisplay("1"));
        add(btn1);

        JButton btn2 = new JButton("2");
        btn2.setBounds(90, 290, 70, 60);
        btn2.addActionListener(e -> addNumberToDisplay("2"));
        add(btn2);

        JButton btn3 = new JButton("3");
        btn3.setBounds(170, 290, 70, 60);
        btn3.addActionListener(e -> addNumberToDisplay("3"));
        add(btn3);


        JButton btnEq = new JButton("=");
        btnEq.setBounds(250, 290, 70, 130);
        btnEq.setBackground(operationColor);
        btnEq.setForeground(textColor);
        btnEq.setFont(new Font("Arial", Font.BOLD, 20));
        btnEq.addActionListener(e -> calculateResult());
        add(btnEq);


        JButton btn0 = new JButton("0");
        btn0.setBounds(10, 360, 150, 60);
        btn0.addActionListener(e -> addNumberToDisplay("0"));
        add(btn0);

        JButton btnDot = new JButton(".");
        btnDot.setBounds(170, 360, 70, 60);
        btnDot.addActionListener(e -> addNumberToDisplay("."));
        add(btnDot);

        setResizable(false);
        setVisible(true);
    }

    private void addNumberToDisplay(String num) {
        if (startNewNumber) {
            display.setText(num);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + num);
        }
    }

    private void setOperator(String operate) {
        if (!operator.isEmpty() && !startNewNumber) {
            calculateResult();
        }
        firstNum = Double.parseDouble(display.getText());
        operator = operate;
        startNewNumber = true;
    }

    private void clearDisplay() {
        display.setText("0");
        firstNum = 0;
        operator = "";
        startNewNumber = true;
    }

    private void calculateResult() {
        if (operator.isEmpty()) {
            return;
        }
        double secondNum = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+": result = calc.add(firstNum, secondNum); break;
            case "-": result = calc.subtract(firstNum, secondNum); break;
            case "*": result = calc.multiply(firstNum, secondNum); break;
            case "/": result = calc.divide(firstNum, secondNum); break;
        }

        if (result % 1 == 0) {
            display.setText(String.valueOf((int) result));
        } else {
            display.setText(String.valueOf(result));
        }

        startNewNumber = true;
        operator = "";
    }



}