import java.awt.*;
import javax.swing.*;

public class Main{

    public static void main(String[] args){

        // GUI Setup
        JFrame frame = new JFrame("|ZrC Switch Calculator|");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();

        SwitchCalculator sc = new SwitchCalculator();
        //sc.calculator(); 
        
        c.add(sc);
        frame.pack();
        frame.setVisible(true);
    }
}