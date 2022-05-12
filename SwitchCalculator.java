import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

// make a GUI out of this calculator
// will have buttons to determine which operation is to be done
// then two text fields and a label in between that changes sign (operation) based on what button was clicked
// on the end of the second text field, another label that will have an equal sign and on right of that a 
// label where the result will appear

/*
                          An Example
     --------     -----------     --------     --------------
    |Addition|   |Subtraction|   |Division|   |Multiplication|
     --------     -----------     --------     --------------

                         ---        ---
                        |   | *+/- |   | = ?
                         ---        ---

*/
public class SwitchCalculator extends JPanel{

    // GUI Setup
    private JButton totalButton, subButton, divButton, multButton, resultButton;
    private JTextField box1, box2;
    private JLabel mathOp, equalSign, answer;

    private String choice;
    //private Scanner scan;
    private double add1, add2, total, sub1, sub2, diff, mult1, mult2, prod, divis, divid, quot;


    public SwitchCalculator(){

        // JTextField Setup
        box1 = new JTextField(5);
        box2 = new JTextField(5);

        // JButton Setup
        totalButton = new JButton("Addition");
        subButton = new JButton("Subtraction");
        divButton = new JButton("Division");
        multButton = new JButton("Multiplication");
        resultButton = new JButton("Click for result");

        // Adding Action Listeners to the Buttons
        totalButton.addActionListener(new TotalButtonListener());
        subButton.addActionListener(new SubButtonListener());
        divButton.addActionListener(new DivButtonListener());
        multButton.addActionListener(new MultButtonListener());
        ResultButtonListener resultB = new ResultButtonListener();
        resultButton.addActionListener(resultB);
        box2.addActionListener(resultB);

        // JLabel Setup
        equalSign = new JLabel("=");
        mathOp = new JLabel("?");
        answer = new JLabel("");

        // Adding each component to the panel
        add(totalButton);
        add(subButton);
        add(divButton);
        add(multButton);
        add(box1);
        add(mathOp);
        add(box2);
        add(equalSign);
        add(answer);
        add(resultButton);

        setPreferredSize(new Dimension(400, 300));
    }

    public void calculator(){

        // Adjusting the string entered so it can match one of the switch cases if possible
        choice = mathOp.getText();

        // Deals with choosing a mathematical operation
        switch (getChoice()){

            case "+":
                answer.setText("" + addition());
                break;

            case "-":
                answer.setText("" + subtraction());
                break;

            case "x":
                answer.setText("" + multiplication());
                break;

            case "/":
                answer.setText("" + division());
                break;

            default:
                answer.setText("No operation was chosen.");
        }
    }

    // Methods representing one of the four operations in the calculator
    // Each has a try block to ensure that no strings are entered in place of the doubles
    // with the division method accounting for division by zero
    public double addition(){

        try{
            add1 = Double.parseDouble(box1.getText());
            add2 = Double.parseDouble(box2.getText());
            total = add1 + add2;
        } catch (NumberFormatException nfe){
            System.out.println("Expecting a decimal (double) number but a String was entered.");
        }

        return total;
    }

    public double subtraction(){
    
        try{
            sub1 = Double.parseDouble(box1.getText());
            sub2 = Double.parseDouble(box2.getText());
            diff = sub1 - sub2;
        } catch (NumberFormatException nfe){
            System.out.println("Expecting a decimal (double) number but a String was entered.");
        }

        return diff;
    }

    public double multiplication(){
        
        try{
            mult1 = Double.parseDouble(box1.getText());
            mult2 = Double.parseDouble(box2.getText());
            prod = mult1 * mult2;
        } catch (NumberFormatException nfe){
            System.out.println("Expecting a decimal (double) number but a String was entered.");
        }

        return prod;
    }

    public double division(){
        
        try{
            divid = Double.parseDouble(box1.getText());
            divis = Double.parseDouble(box2.getText());
            quot = divid / divis;
            
        } catch (ArithmeticException ae){
            System.out.println("Cannot divide by 0!");
        } catch (NumberFormatException nfe){
            System.out.println("Expecting a decimal (double) number but a String was entered.");
        }

        return quot;
    }
    
    public String getChoice(){
        return choice;
    }

    private class ResultButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            calculator();
        }
    }

    private class TotalButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            mathOp.setText("+");
        }
    }

    private class SubButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            mathOp.setText("-");
        }
    }

    private class DivButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            mathOp.setText("/");
        }
    }

    private class MultButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            mathOp.setText("x");
        }
    }
}

