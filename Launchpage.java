import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Launchpage  implements ActionListener {
  // extends TicTacToe
    JLabel label = new JLabel();

    //ImageIcon icon = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\frameimage.jpg");
    //Image img = icon.getImage();
    //Image imagescale = img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
   // ImageIcon scaleIcon = new ImageIcon(imagescale);

    JFrame frame = new JFrame(" Welcome to Lucky's TacToe");
   JButton myButton = new JButton("Are you ready to play the game!!!");

    Launchpage(){

       label.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\frameimage.jpg"));
       //label.setIcon(new ImageIcon());
       frame.add(label);

        //Image img = icon.getImage();
        //Image imagescale = img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
        //ImageIcon scaleIcon = new ImageIcon(imagescale);

        //label.setIcon(scaleIcon);
        //myButton.setEnabled();

       myButton.setBounds(120,100,250,70);
       myButton.setFocusable(false);
       myButton.addActionListener(this);
       myButton.setBackground(Color.BLACK);
       myButton.setForeground(Color.white);
       //myButton.setEnabled(false);
        

       frame.setLocation(440,75);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
       frame.setVisible(true);
       frame.setLayout(null);
       frame.add(myButton);
       //frame.setLocation(null);
       //frame.getContentPane().setBackground(new Color(123,50,250));
       frame.add(label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton){
            frame.dispose();
            new TicTacToe();

        }
    }
}
