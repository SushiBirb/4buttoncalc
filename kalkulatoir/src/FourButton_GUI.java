import javax.script.AbstractScriptEngine;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FourButton_GUI {

    private double result = 0.0;


    public FourButton_GUI() {
        JFrame frame = new JFrame("Four Button GUI");

        //text field
        JTextField tf = new JTextField(50);
        tf.setBounds(50, 50, 300, 50);
        tf.setEditable(false);
        frame.add(tf);

        //buttons
        JButton b0 = new JButton("0");
        b0.setBounds(175, 250, 50, 50);
        frame.add(b0);

        JButton b1 = new JButton("1");
        b1.setBounds(125, 100, 50, 50);
        frame.add(b1);

        JButton b2 = new JButton("2");
        b2.setBounds(175, 100, 50, 50);
        frame.add(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(225, 100, 50, 50);
        frame.add(b3);

        JButton b4 = new JButton("4");
        b4.setBounds(125, 150, 50, 50);
        frame.add(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(125, 200, 50, 50);
        frame.add(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(175, 150, 50, 50);
        frame.add(b6);

        JButton b7 = new JButton("7");
        b7.setBounds(225, 150, 50, 50);
        frame.add(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(175, 200, 50, 50);
        frame.add(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(225, 200, 50, 50);
        frame.add(b9);

        JButton bdot = new JButton(".");
        bdot.setBounds(225, 250, 50, 50);
        frame.add(bdot);

        JButton bClear = new JButton("C");
        bClear.setBounds(125, 250, 50, 50);
        frame.add(bClear);

        JButton bAdd = new JButton("+");
        bAdd.setBounds(300, 100, 50, 50);
        frame.add(bAdd);

        JButton bSub = new JButton("-");
        bSub.setBounds(300, 150, 50, 50);
        frame.add(bSub);

        JButton bMul = new JButton("*");
        bMul.setBounds(300, 200, 50, 50);
        frame.add(bMul);

        JButton bDiv = new JButton("/");
        bDiv.setBounds(300, 250, 50, 50);
        frame.add(bDiv);

        JButton ans = new JButton("ans");
        ans.setBounds(50, 300, 60, 50);
        frame.add(ans);

        JButton beq = new JButton("=");
        beq.setBounds(50, 100, 50, 200);
        frame.add(beq);

        //general frame settings
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //number buttons add to text field


        b0.addActionListener(e -> tf.setText(tf.getText() + "0"));
        b1.addActionListener(e -> tf.setText(tf.getText() + "1"));
        b2.addActionListener(e -> tf.setText(tf.getText() + "2"));
        b3.addActionListener(e -> tf.setText(tf.getText() + "3"));
        b4.addActionListener(e -> tf.setText(tf.getText() + "4"));
        b5.addActionListener(e -> tf.setText(tf.getText() + "5"));
        b6.addActionListener(e -> tf.setText(tf.getText() + "6"));
        b7.addActionListener(e -> tf.setText(tf.getText() + "7"));
        b8.addActionListener(e -> tf.setText(tf.getText() + "8"));
        b9.addActionListener(e -> tf.setText(tf.getText() + "9"));
        ans.addActionListener(e -> tf.setText(String.valueOf(result)));
        bdot.addActionListener(e -> tf.setText(tf.getText() + "."));
        bAdd.addActionListener(e -> tf.setText(tf.getText() + " + "));
        bSub.addActionListener(e -> tf.setText(tf.getText() + " - "));
        bMul.addActionListener(e -> tf.setText(tf.getText() + " * "));
        bDiv.addActionListener(e -> tf.setText(tf.getText() + " / "));
        bClear.addActionListener(e -> tf.setText(""));


        //parse text from field
        beq.addActionListener(e -> {
            String text = tf.getText();
            String[] equatiion = text.split(" ");
            ArrayList<String> equation = new ArrayList<>(Arrays.asList(equatiion));
            System.out.println(equation);

            //loop through whole arraylist
            //if operator is found, do the operation and remove the operator and the two numbers around it
            for (int i = 0; i < equation.size(); i++) {
                if (equation.get(i).equals("+")) {
                    result = Double.parseDouble(equation.get(i - 1)) + Double.parseDouble(equation.get(i + 1));
                    equation.set(i, String.valueOf(result));
                    equation.remove(i - 1);
                    equation.remove(i);
                    i = 0;
                }
                 if (equation.get(i).equals("-")) {
                    result = Double.parseDouble(equation.get(i - 1)) - Double.parseDouble(equation.get(i + 1));
                    equation.set(i, String.valueOf(result));
                    equation.remove(i - 1);
                    equation.remove(i);
                    i = 0;
                }
                if (equation.get(i).equals("*")) {
                    result = Double.parseDouble(equation.get(i - 1)) * Double.parseDouble(equation.get(i + 1));
                    equation.set(i, String.valueOf(result));
                    equation.remove(i - 1);
                    equation.remove(i);
                    i = 0;
                }
                if (equation.get(i).equals("/")) {
                    result = Double.parseDouble(equation.get(i - 1)) / Double.parseDouble(equation.get(i + 1));
                    equation.set(i, String.valueOf(result));
                    equation.remove(i - 1);
                    equation.remove(i);
                    i = 0;
                }
            }

            if (result % 1 != 0) {
                tf.setText(String.valueOf(result));
            } else {
                result = (int) result;
                tf.setText(String.valueOf((int) result));
            }
        });
    }
}

