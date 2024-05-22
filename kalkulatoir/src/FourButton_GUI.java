import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FourButton_GUI {

    private double result;

    public FourButton_GUI() {
        JFrame frame = new JFrame("Four Button GUI");

        //text field
        JTextField tf = new JTextField(0);
        tf.setBounds(5, 5, 300, 200);
        tf.setHorizontalAlignment(SwingConstants.CENTER);
        tf.setEditable(false);
        frame.add(tf);

        //buttons
        JButton b0 = new JButton("0");
        b0.setBounds(80, 410, 75, 50);
        frame.add(b0);

        JButton b1 = new JButton("1");
        b1.setBounds(5, 360, 75, 50);
        frame.add(b1);

        JButton b2 = new JButton("2");
        b2.setBounds(80, 360, 75, 50);
        frame.add(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(155, 360, 75, 50);
        frame.add(b3);

        JButton b4 = new JButton("4");
        b4.setBounds(5, 310, 75, 50);
        frame.add(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(80, 310, 75, 50);
        frame.add(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(155, 310, 75, 50);
        frame.add(b6);

        JButton b7 = new JButton("7");
        b7.setBounds(5, 260, 75, 50);
        frame.add(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(80, 260, 75, 50);
        frame.add(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(155, 260, 75, 50);
        frame.add(b9);

        JButton bdot = new JButton(".");
        bdot.setBounds(155, 410, 75, 50);
        frame.add(bdot);

        JButton bClear = new JButton("C");
        bClear.setBounds(5, 210, 110, 50);
        frame.add(bClear);

        JButton bAdd = new JButton("+");
        bAdd.setBounds(230, 360, 75, 50);
        frame.add(bAdd);

        JButton bSub = new JButton("-");
        bSub.setBounds(230, 310, 75, 50);
        frame.add(bSub);

        JButton bMul = new JButton("*");
        bMul.setBounds(230, 260, 75, 50);
        frame.add(bMul);

        JButton bDiv = new JButton("/");
        bDiv.setBounds(230, 210, 75, 50);
        frame.add(bDiv);

        JButton beq = new JButton("=");
        beq.setBounds(230, 410, 75, 50);
        frame.add(beq);

        JButton del = new JButton("del");
        del.setBounds(115, 210, 115, 50);
        frame.add(del);

        //del.setFont(del.getFont().deriveFont(20.0f));

        //general frame settings
        frame.setResizable(false);
        frame.setSize(325, 505);
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

        bdot.addActionListener(e -> tf.setText(tf.getText() + "."));

        bAdd.addActionListener(e -> tf.setText(tf.getText() + " + "));

        bSub.addActionListener(e -> tf.setText(tf.getText() + " - "));

        bMul.addActionListener(e -> tf.setText(tf.getText() + " * "));

        bDiv.addActionListener(e -> tf.setText(tf.getText() + " / "));

        bClear.addActionListener(e -> tf.setText(""));

        del.addActionListener(e -> tf.setText(tf.getText().substring(0, tf.getText().length() - 1)));

        //parse text from field
        beq.addActionListener(e -> {
            String text = tf.getText();
            String[] splitequation = text.split(" ");
            if (splitequation[1].equals("-")) {
                splitequation[0] = "0";
            }
            ArrayList < String > equation = new ArrayList < > (Arrays.asList(splitequation));
            for (int c = 0; c < equation.size(); c++) {
                if (equation.get(c).isEmpty()) {
                    equation.remove(c);
                }
            }

            //check for 2 operators in a row
            for (int i = 0; i < equation.size(); i++) {
                try {
                    if (equation.get(i).equals("/") && equation.get(i + 1).equals("-")) {
                        double blah = Double.parseDouble(equation.get(i + 2)) * (-1);
                        String blagh = String.valueOf(blah);
                        equation.remove(i + 1);
                        equation.set(i + 1, blagh);
                    }
                } catch (Exception p) {
                    JOptionPane.showMessageDialog(frame, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.setText("");
                    equation.clear();
                    break;
                }

                try {
                    if (equation.get(i).matches("[+\\-\\*\\/]") && equation.get(i + 1).matches("[+\\-\\*\\/]")) {
                        JOptionPane.showMessageDialog(frame, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                        tf.setText("");
                        equation.clear();
                        break;

                    }
                } catch (Exception p) {
                    JOptionPane.showMessageDialog(frame, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.setText("");
                    equation.clear();
                    break;
                }

                if (equation.get(i).matches("[+\\-\\*\\/]") && equation.get(i + 1).matches("[+\\-\\*\\/\\.]")) {
                    JOptionPane.showMessageDialog(frame, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.setText("");
                    equation.clear();
                    break;
                }

        /* loop through whole arraylist
        if operator is found, do the operation and remove the operator and the two indexes around it */

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
                    if (Double.parseDouble(equation.get(i - 1)) == 0 && Double.parseDouble(equation.get(i + 1)) == 0) {
                        JOptionPane.showMessageDialog(frame, "invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    result = Double.parseDouble(equation.get(i - 1)) / Double.parseDouble(equation.get(i + 1));
                    equation.set(i, String.valueOf(result));
                    equation.remove(i - 1);
                    equation.remove(i);
                    i = 0;
                }
                if (equation.size() == 1) {
                    result = Double.parseDouble(equation.get(i));
                }
            }

            if (result % 1 != 0) {
                tf.setText(text + " = " + result);
            } else {
                result = (int) result;
                tf.setText(text + " = " + (int) result);
            }
        });
    }
}
