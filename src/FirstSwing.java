import javax.swing.*;
import java.awt.event.*;

public class FirstSwing {
    public static void main(String[] args) {
        JFrame f = new JFrame("Swing!");    
        JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JLabel lb = new JLabel();
        lb.setBounds(50, 75, 150, 20);
        lb.setText("label text");
        JButton b = new JButton("Click Me");
        b.setBounds(50, 100, 95, 30);        
        f.add(b);
        f.add(tf);
        f.add(lb);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {                                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                lb.setText(KeyEvent.getKeyText(e.getKeyCode()));
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" botton action ");
                tf.setText("Let's Swing.");
            }
        });
    }
}